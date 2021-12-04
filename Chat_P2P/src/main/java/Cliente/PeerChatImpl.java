
package Cliente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class PeerChatImpl extends UnicastRemoteObject implements PeerChatInterface{
    
    protected PeerChatImpl() throws RemoteException {
        super();
    }
    
    public void sayhello() throws RemoteException{
        System.out.println("Hello");
    }
    
    
}
