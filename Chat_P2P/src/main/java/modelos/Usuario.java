
package modelos;

import java.io.Serializable;


public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String username;
    private Boolean conectado;
    
    public Usuario(String username){
        this.username = username;
        this.conectado = false;
    }
    
    
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
    
    
}
