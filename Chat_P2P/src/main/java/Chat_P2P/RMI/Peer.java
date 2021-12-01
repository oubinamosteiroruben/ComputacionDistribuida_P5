
package Chat_P2P.RMI;

import definiciones.Definiciones;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;
import java.io.*;

public class Peer {
    
    public Peer(){
        String portNum, registryURL;
        try{
            portNum = Definiciones.PORT;
            Integer RMIPortNum = Integer.parseInt(portNum);
            startRegistry(RMIPortNum);
            PeerImpl exportedObj = new PeerImpl();
            registryURL = "rmi://localhost:" + portNum + "/chat";
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
}
