package modelos;

import java.io.Serializable;

public class Mensaje implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int codigo;
    private String mensaje;
    
    public Mensaje(){
        this.codigo = 0;
        this.mensaje = "";
    }
    
    public Mensaje(int codigo, String mensaje){
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
