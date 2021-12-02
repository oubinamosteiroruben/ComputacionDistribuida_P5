
package modelos;

import Chat_P2P.RMI.PeerInterface;
import java.io.Serializable;


public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String username;
    private PeerInterface peerInterface;
    
    public Usuario(String username){
        this.username = username;
        this.peerInterface = null;
    }
    
    public Usuario(String username, PeerInterface peerInterface){
        this.username = username;
        this.peerInterface = peerInterface;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PeerInterface getPeerInterface() {
        return peerInterface;
    }

    public void setPeerInterface(PeerInterface peerInterface) {
        this.peerInterface = peerInterface;
    }

    
    
}
