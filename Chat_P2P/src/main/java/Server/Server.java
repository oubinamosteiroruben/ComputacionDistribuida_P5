
package Server;

import Cliente.PeerChatInterface;
import Cliente.PeerConectionInterface;
import definiciones.Definiciones;
import static definiciones.Definiciones.HOSTNAME;
import modelos.Usuario;
import java.util.*;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;
import java.io.*;
import modelos.Mensaje;
import modelos.PeerController;


public class Server {
    
    private HashMap<String, Sesion> usuariosOnline;
    private final FachadaServer fs;
    
    public Server(FachadaServer fs){
        this.fs = fs;
        this.usuariosOnline = new HashMap<>();
        iniciarServidor();
    }
 
    
    public void iniciarServidor() {
        String portNum, registryURL;
        try{
            portNum = Definiciones.PORT;
            int RMIPortNum = Integer.parseInt(portNum);
            startRegistry(RMIPortNum);
            ServerImpl exportedObj = new ServerImpl(this.fs);
            registryURL = "rmi://" + HOSTNAME + ":" + portNum + "/chatP2P";
            Naming.rebind(registryURL, exportedObj);
            System.out.println("Server chatp2p registered.  Registry currently contains:");
            // list names currently in the registry
            listRegistry(registryURL);
            System.out.println("Server chatp2p ready.");
        }// end try
        catch (Exception re) {
            System.out.println("Exception in Server.iniciarServidor: " + re);
        } // end catch
    } // end main

    // This method starts a RMI registry on the local host, if it
    // does not already exists at the specified port number.
    private static void startRegistry(int RMIPortNum) throws RemoteException{
        try {
            Registry registry = LocateRegistry.getRegistry(RMIPortNum);
            registry.list( );  // This call will throw an exception
            // if the registry does not already exist
        }
        catch (RemoteException e) {
            // No valid registry at that port.
            System.out.println("RMI registry cannot be located at port "+ RMIPortNum);
            Registry registry = LocateRegistry.createRegistry(RMIPortNum);
            System.out.println("RMI registry created at port " + RMIPortNum);
        }
    } // end startRegistry

    // This method lists the names registered with a Registry object
    private static void listRegistry(String registryURL) throws RemoteException, MalformedURLException {
        System.out.println("Registry " + registryURL + " contains: ");
        String [ ] names = Naming.list(registryURL);
        for (int i=0; i < names.length; i++)
            System.out.println(names[i]);
    } //end listRegistry
    
    
    public void addUsuarioConectado(String username, PeerChatInterface peerChatInterface, PeerConectionInterface peerConectionInterface){
        Sesion sesion = new Sesion(username,peerChatInterface,peerConectionInterface);
        this.usuariosOnline.put(username, sesion);
    }
    
    public HashMap<String,PeerChatInterface> obtenerInfoAmigosConectados(List<String> nombresAmigos){
        HashMap<String,PeerChatInterface> amigos = new HashMap<>();
        
        for(String amigo: nombresAmigos){
            Sesion s = this.usuariosOnline.get(amigo);
            if(s!=null){
                amigos.put(amigo, s.getPeerChatInterface());
            }
        }
        
        return amigos;
    }
    
    public HashMap<String,PeerConectionInterface> obtenerConectionAmigosConectados(List<String> nombresAmigos){
        HashMap<String,PeerConectionInterface> amigos = new HashMap<>();
        
        for(String amigo: nombresAmigos){
            Sesion s = this.usuariosOnline.get(amigo);
            if(s!=null){
                amigos.put(amigo, s.getPeerConectionInterface());
            }
        }
        
        return amigos;
    }
    
    public void addSolicitud(String usernameEmisor, String usernameReceptor){
        Sesion sesion = this.usuariosOnline.get(usernameReceptor);
        if(sesion != null){
            PeerConectionInterface peerConection = sesion.getPeerConectionInterface();
            if(peerConection != null){
                try{
                    peerConection.notificarSolicitud(usernameEmisor);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void solicitudAceptada(String amigo1, String amigo2){
        // si los dos están en linea, les avisamos mutuamente
        if(this.usuariosOnline.containsKey(amigo1) && this.usuariosOnline.containsKey(amigo2)){
            try{
                Sesion sesion1 = this.usuariosOnline.get(amigo1);
                Sesion sesion2 = this.usuariosOnline.get(amigo2);
                // avisamos al amigo 1
                sesion1.getPeerConectionInterface().notificarConexion(sesion2.getUsername(), sesion2.getPeerChatInterface());
                // avisamos al amigo 2
                sesion2.getPeerConectionInterface().notificarConexion(sesion1.getUsername(), sesion1.getPeerChatInterface());
            } catch(Exception e){
                e.printStackTrace();
            }      
        }
    }
    
    public void notificarDesconection(String usuario){
        HashMap<String,PeerConectionInterface> amigos = this.fs.obtenerConectionAmigos(usuario);
        for(PeerConectionInterface peer: amigos.values()){
            try{
                peer.notificarDesconexion(usuario);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        
        this.usuariosOnline.remove(usuario);
    }
    
}
