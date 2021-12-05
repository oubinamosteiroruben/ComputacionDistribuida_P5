
package Cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;
import modelos.MensajeChat;

public interface PeerChatInterface extends Remote{
    public void sayhello() throws RemoteException;
    
    public void enviarMensaje(MensajeChat mc) throws RemoteException;
    
}
