
package Chat_P2P;

import Chat_P2P.RMI.FachadaRMI;
import gui.FachadaGui;
import java.util.*;
import modelos.Mensaje;
import modelos.Usuario;

public class FachadaAplicacion {
    
    private final FachadaGui fg;
    private final FachadaRMI frmi;
    
    private Usuario usuarioActual;
    private HashMap<String, Usuario> amigos;
    
    
    public FachadaAplicacion(){
        this.amigos = new HashMap<>();
        this.fg = new FachadaGui(this);
        this.frmi = new FachadaRMI(this);
    }
    
    public static void main(String args[]) {
        FachadaAplicacion fa;

        fa = new FachadaAplicacion();
        fa.iniciaInterfazUsuario();
    }
    
    // ------------------- GUI -------------------
    public void iniciaInterfazUsuario(){
        this.fg.iniciarVista();
    }
    
    //------------------- Login -------------------
    
    public Boolean iniciarSesion(String username, String password) throws Exception{
        boolean resultado = false;
        
        Usuario usuario = this.frmi.iniciarSesion(username,password);
        if(usuario.getPeerInterface() != null){
            this.usuarioActual = usuario;
            this.amigos = this.frmi.obtenerAmigos(this.usuarioActual.getUsername());
            this.fg.lanzarChat();
            resultado = true;
        }
        
        return resultado;
    }
    
    public Mensaje registrarUsuario(String username, String password) throws Exception{
        return this.frmi.registrarUsuario(username, password);
    }
    
    

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public HashMap<String, Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(HashMap<String, Usuario> amigos) {
        this.amigos = amigos;
    }
    
    public void enviarPeticion(String usernameReceptor) throws Exception{
        this.frmi.enviarPeticion(usuarioActual.getUsername(), usernameReceptor);
    }
    
    
    
}