
package Cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PeerConectionInterface extends Remote{
    public void sayhello() throws RemoteException;
    
    public void notificarConexion(String username, PeerChatInterface peerChatInterface) throws RemoteException;
}
