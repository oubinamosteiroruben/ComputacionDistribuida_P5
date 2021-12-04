
package Server;

import Cliente.PeerChatInterface;
import Cliente.PeerConectionInterface;

public class Sesion {
    private String username;
    private PeerChatInterface peerChatInterface;
    private PeerConectionInterface peerConectionInterface;

    public Sesion(String username, PeerChatInterface peerChatInterface, PeerConectionInterface peerConectionInterface) {
        this.username = username;
        this.peerChatInterface = peerChatInterface;
        this.peerConectionInterface = peerConectionInterface;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PeerChatInterface getPeerChatInterface() {
        return peerChatInterface;
    }

    public void setPeerChatInterface(PeerChatInterface peerChatInterface) {
        this.peerChatInterface = peerChatInterface;
    }

    public PeerConectionInterface getPeerConectionInterface() {
        return peerConectionInterface;
    }

    public void setPeerConectionInterface(PeerConectionInterface peerConectionInterface) {
        this.peerConectionInterface = peerConectionInterface;
    }
    
}
