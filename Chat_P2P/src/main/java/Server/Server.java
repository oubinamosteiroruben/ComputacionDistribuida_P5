
package Server;

import Cliente.PeerChatInterface;
import Cliente.PeerConectionInterface;
import definiciones.Definiciones;
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
            registryURL = "rmi://localhost:" + portNum + "/chatP2P";
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
    
    /*
    
    public Usuario iniciarSesion(String username, String password){
        Usuario usuarioResultado = new Usuario(username);
        try{
            boolean iniciado = this.fs.iniciarSesion(username, password);
            
            if(iniciado){
                // añadimos el usuario como usuario online
                /*System.out.println("hola 1");
                Peer peer = new Peer();
                System.out.println("hola 2");
                usuarioResultado.setPeerInterface(peer.getPeerInterface());
                System.out.println("hola 3");
                this.usuariosOnline.put(usuarioResultado.getUsername(), usuarioResultado);*/
              /*  PeerController.getInstance().anhadirUsuarioOnline(usuarioResultado);
                usuarioResultado.setConectado(true);
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return usuarioResultado;
    }
    
    public Mensaje registrarUsuario(String username, String password){
        return this.fs.registrarUsuario(username, password);
    }
    
    public HashMap<String, Usuario> obtenerAmigos(String username){
        HashMap<String,Usuario> amigosOnline = new HashMap<>();
        
        for(String user: this.fs.obtenerAmigos(username)){
            if(this.usuariosOnline.get(user) != null){
                // si es amigo y está online, se le envía al cliente
                amigosOnline.put(user, this.usuariosOnline.get(user));
                
                // y se le notifica a ese amigo que ahora está online
                try{
                    PeerController.getInstance().notificarAmigoOnline(this.usuariosOnline.get(username), 
                                                                        this.usuariosOnline.get(user));
                    //this.usuariosOnline.get(user).getPeerInterface().notificarAmigoOnline(this.usuariosOnline.get(username));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return amigosOnline;
    }
    
    public Boolean enviarPeticion(String usernameEmisor, String usernameReceptor){
        return this.fs.enviarPeticion(usernameEmisor, usernameReceptor);
    }
    
    public Boolean aceptarPeticion(String usernameEmisor, String usernameReceptor){
        return this.fs.aceptarPeticion(usernameEmisor, usernameReceptor);
    }
    
    public Boolean rechazarPeticion(String usernameEmisor, String usernameReceptor){
        return this.fs.rechazarPeticion(usernameEmisor, usernameReceptor);
    }
    
    public ArrayList<String> obtenerPeticiones(String usernameReceptor){
        return this.fs.obtenerPeticiones(usernameReceptor);
    }
    
*/
}
