
package modelos;

import java.io.Serializable;

public class MensajeChat implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String emisor;
    private String receptor;
    private String cuerpo;
    private Boolean leido;
    
    public MensajeChat(String emisor, String receptor, String cuerpo){
        this.emisor = emisor;
        this.receptor = receptor;
        this.cuerpo = cuerpo;
        this.leido = false;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    
    public Boolean isLeido(){
        return this.leido;
    }
    
    public void setLeido(Boolean leido){
        this.leido = true;
    }
    
}
