
package Server;

import definiciones.Definiciones;
import modelos.Usuario;
import java.util.ArrayList;
import java.util.List;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;
import java.io.*;


public class Server {
    
    private List<Usuario> usuariosOnline;
    private final FachadaServer fs;
    
    public Server(FachadaServer fs){
        this.fs = fs;
        this.usuariosOnline = new ArrayList<>();
    }
 
    
    public void iniciarServidor() {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String portNum, registryURL;
        try{
            portNum = Definiciones.PORTNUMBER;
            int RMIPortNum = Integer.parseInt(portNum);
            startRegistry(RMIPortNum);
            ServerImpl exportedObj = new ServerImpl(this);
            registryURL = "rmi://localhost:" + portNum + "/p5";
            Naming.rebind(registryURL, exportedObj);
            System.out.println("P5 Server registered.  Registry currently contains:");
            // list names currently in the registry
            listRegistry(registryURL);
            System.out.println("P5 Server ready.");
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
    
    
    public void iniciarSesion(Usuario usuario){
        for(Usuario u: usuariosOnline){
            if(u.getUsername().equals(usuario.getUsername())){
                usuariosOnline.remove(u);
            }
        }
    }
    
    public List<Usuario> getAmigos(Usuario usuario){
        /*
        HAY QUE IMPLEMENTARLO
        */
        return null;
    }
    
    
    public Boolean registrarUsuario(Usuario usuario){
        return fs.registrarUsuario(usuario);
    }
    
}