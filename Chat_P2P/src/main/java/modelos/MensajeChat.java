
package modelos;

public class MensajeChat {
    
    private String emisor;
    private String receptor;
    private String cuerpo;
    
    
    public MensajeChat(String emisor, String receptor, String cuerpo){
        this.emisor = emisor;
        this.receptor = receptor;
        this.cuerpo = cuerpo;
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
    
}
