
package Chat_P2P.RMI;

import Chat_P2P.FachadaAplicacion;
import java.rmi.*;
import modelos.Usuario;

public interface PeerInterface extends Remote {
    
    public void notificarAmigoOnline(Usuario usuario) throws RemoteException;
    
    public void setFachadaAplicacion(FachadaAplicacion fa) throws RemoteException;
    
}
