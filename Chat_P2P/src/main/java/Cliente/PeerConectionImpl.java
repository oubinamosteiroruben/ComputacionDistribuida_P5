
package Cliente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class PeerConectionImpl extends UnicastRemoteObject implements PeerConectionInterface{
    
    protected PeerConectionImpl() throws RemoteException {
        super();
    }
    
    public void sayhello()throws RemoteException{
        System.out.println("Hello");
    }
    
    public void notificarConexion(String username, PeerChatInterface peerChatInterface) throws RemoteException{
        // añadimos el amigo a la lista
        Peer.getInstance().getAmigos().put(username, peerChatInterface);
        
        // actualizamos la interfaz grafica
        ArrayList<String> amigos = new ArrayList<>();
        amigos.addAll(Peer.getInstance().getAmigos().keySet());
        Peer.getInstance().getCliente().getFachadaAplicacion().actualizarAmigosConectados(amigos);
    }
    
    public void notificarSolicitud(String usernameEmisor) throws RemoteException{
        Peer.getInstance().getCliente().getFachadaAplicacion().actualizarPeticiones();
    }
}
