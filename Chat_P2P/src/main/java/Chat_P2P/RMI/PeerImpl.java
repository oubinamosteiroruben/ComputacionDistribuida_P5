
package Chat_P2P.RMI;

import Chat_P2P.FachadaAplicacion;
import java.rmi.*;
import java.rmi.server.*;
import modelos.Usuario;

public class PeerImpl extends UnicastRemoteObject implements PeerInterface {
    
    private Peer peer;
    
    public PeerImpl() throws RemoteException{
        super();
        this.peer = new Peer();
    }
    
    public void setFachadaAplicacion(FachadaAplicacion fa) throws RemoteException{
        this.peer.setFachadaAplicacion(fa);
    }
    
    public void notificarAmigoOnline(Usuario amigo) throws RemoteException{
        peer.notificarAmigoOnline(amigo);
    }
}
