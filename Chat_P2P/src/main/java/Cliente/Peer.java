
package Cliente;

import Server.ServerInterface;
import java.util.HashMap;

public class Peer {

    private String usuario;
    private Cliente cliente;
    
    private HashMap<String,PeerChatInterface> amigos;
    
    private PeerChatInterface peerChat;
    private PeerConectionInterface peerConection;
    
    private ServerInterface server;
    
    private static Peer instance;
    
    public Peer(){
        this.amigos = new HashMap<>();
    } 
    
    public static Peer getInstance(){
        if(instance== null){
            instance = new Peer();
        }
        return instance;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getUsuario(){
        return this.usuario;
    }

    public  HashMap<String, PeerChatInterface> getAmigos() {
        return this.amigos;
    }

    public void setAmigos(HashMap<String, PeerChatInterface> amigos) {
        this.amigos = amigos;
    }

    public  PeerChatInterface getPeerChat() {
        return peerChat;
    }

    public void setPeerChat(PeerChatInterface peerChat) {
        this.peerChat = peerChat;
    }

    public  PeerConectionInterface getPeerConection() {
        return peerConection;
    }

    public void setPeerConection(PeerConectionInterface peerConection) {
        this.peerConection = peerConection;
    }

    public ServerInterface getServer() {
        return server;
    }

    public void setServer(ServerInterface server) {
        this.server = server;
    }
    
    
}


