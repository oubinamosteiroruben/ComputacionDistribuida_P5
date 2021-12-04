
package Chat_P2P.RMI;

import Chat_P2P.FachadaAplicacion;
import definiciones.Definiciones;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;
import java.io.*;
import modelos.Usuario;

public class Peer {
    
    private FachadaAplicacion fa;
    private PeerInterface peerInterface;
    
    public Peer(){
        
        String portNum, registryURL;
        try{
            portNum = Definiciones.PORT;
            Integer RMIPortNum = Integer.parseInt(portNum);
            startRegistry(RMIPortNum);
            PeerImpl exportedObj = new PeerImpl();
            this.peerInterface = exportedObj;
            registryURL = "rmi://localhost:" + portNum + "/peer";
            Naming.rebind(registryURL, exportedObj);
            System.out.println("Peer registered.  Registry currently contains:");
            // list names currently in the registry
            listRegistry(registryURL);
            System.out.println("Peer Server ready.");
        }// end try
        catch (Exception re) {
            System.out.println("Exception in Peer: " + re);
        } // end catch
    }
    

    // This method starts a RMI registry on the local host, if it
    // does not already exists at the specified port number.
    private static void startRegistry(int RMIPortNum)
            throws RemoteException{
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

    
    public FachadaAplicacion getFachadaAplicacion() {
        return fa;
    }

    public void setFachadaAplicacion(FachadaAplicacion fa) {
        this.fa = fa;
    }

    public PeerInterface getPeerInterface() {
        return peerInterface;
    }

    public void setPeerInterface(PeerInterface peerInterface) {
        this.peerInterface = peerInterface;
    }
    
    
    public void notificarAmigoOnline(Usuario amigo){
        if(this.fa != null){
            // añadimos el amigo a sus amigos online
            this.fa.getAmigos().put(amigo.getUsername(), amigo);
            this.fa.actualizarAmigos();
        }
    }
}
