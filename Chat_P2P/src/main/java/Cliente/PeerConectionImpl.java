
package Cliente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PeerConectionImpl extends UnicastRemoteObject implements PeerConectionInterface{
    
    protected PeerConectionImpl() throws RemoteException {
        super();
    }
    
    public void sayhello()throws RemoteException{
        System.out.println("Hello");
    }
}
