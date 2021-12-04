
package modelos;

import java.io.Serializable;


public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String username;
    private Boolean conectado;
    //private PeerInterface peerInterface;
    
    public Usuario(String username){
        this.username = username;
        this.conectado = false;
        //this.peerInterface = null;
    }
    
    /*public Usuario(String username, PeerInterface peerInterface){
        this.username = username;
        this.peerInterface = peerInterface;
    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public Boolean isConectado() {
        return conectado;
    }

    public void setConectado(Boolean conectado) {
        this.conectado = conectado;
    }
    
    /*
    public PeerInterface getPeerInterface() {
        return peerInterface;
    }

    public void setPeerInterface(PeerInterface peerInterface) {
        this.peerInterface = peerInterface;
    }
    */

   
    
    
}
