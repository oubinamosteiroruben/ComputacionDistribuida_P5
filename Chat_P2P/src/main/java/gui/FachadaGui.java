
package gui;

import Chat_P2P.FachadaAplicacion;
import gui.paneles.LoginPanel_Login;
import java.util.ArrayList;
import java.util.HashMap;
import modelos.MensajeChat;
import modelos.Usuario;

public class FachadaGui {
    private final FachadaAplicacion fa;
    private VUsuario vu;
    private final VLogin vl;
    
    public FachadaGui(FachadaAplicacion fa){
        this.fa = fa;
        vl = new VLogin(fa);
        //vu = new VUsuario(fa);
    }
    
    public void iniciarVista(){
        this.vl.setVisible(true);
    }
    
    public void lanzarChat(){
        // cerramos el panel de login
        this.vl.setVisible(false);
        this.vl.dispose();
        // abrimos el chat
        this.vu = new VUsuario(this.fa);
        this.vu.setVisible(true);
      //  this.vu.actualizarAmigos();
    }
    
    public void actualizarAmigosConectados(ArrayList<String> amigos){
        this.vu.actualizarAmigosConectados(amigos);
    }
    
    public void recibirMensaje(MensajeChat mc){
        this.vu.recibirMensaje(mc);
    }
    
    public void actualizarPeticiones(){
        this.vu.actualizarPeticiones();
    }
    
    
}
