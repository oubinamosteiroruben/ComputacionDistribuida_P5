
package Chat_P2P;

import Cliente.Cliente;
import Cliente.FachadaCliente;
import Cliente.Peer;
import gui.FachadaGui;
import java.util.*;
import modelos.Mensaje;
import modelos.MensajeChat;
import modelos.Usuario;

public class FachadaAplicacion {
    
    private final FachadaGui fg;
    private final FachadaCliente fc;
    
    
    public FachadaAplicacion(){
        this.fc = new FachadaCliente(this);
        this.fg = new FachadaGui(this);
    }
    
    public static void main(String args[]) {
        FachadaAplicacion fa;

        fa = new FachadaAplicacion();
        
        fa.iniciaInterfazUsuario();
    }
    
    // ------------------- GUI -------------------

    public FachadaGui getFachadaGUI() {
        return fg;
    }
    
    public void iniciaInterfazUsuario(){
        this.fg.iniciarVista();
    }
    
    public void actualizarAmigosConectados(ArrayList<String> amigos){
        this.fg.actualizarAmigosConectados(amigos);
    }
    
    // ------------------- Login -------------------
    public Boolean iniciarSesion(String username, String password) throws Exception{
        boolean iniciado = this.fc.iniciarSesion(username, password);
        if(iniciado){
            Peer.getInstance().setUsuario(username);
            this.fg.lanzarChat();
            
            ArrayList<String> amigos = new ArrayList<>();
            amigos.addAll(Peer.getInstance().getAmigos().keySet());
            actualizarAmigosConectados(amigos);
        }
        
        return iniciado;
    }
    
    public Boolean registrarUsuario(String username, String password) throws Exception{
        boolean iniciado = this.fc.registrarUsuario(username,password);
        if(iniciado){
            Peer.getInstance().setUsuario(username);
            this.fg.lanzarChat();
        }
        
        return iniciado;
    }
    
    public String getUsuarioActual(){
        return this.fc.getUsuarioActual();
    }
    
    public void enviarMensaje(MensajeChat mc) throws Exception{
        this.fc.enviarMensaje(mc);
    }
    
    public void recibirMensaje(MensajeChat mc){
        this.fg.recibirMensaje(mc);
    }
    
    public Boolean enviarPeticion(String usernameOrigen, String usernameDestino) throws Exception{
        return this.fc.enviarPeticion(usernameOrigen, usernameDestino);
    }
    
    public Boolean aceptarPeticion(String usernameOrigen, String usernameDestino) throws Exception{
        return this.fc.aceptarPeticion(usernameOrigen, usernameDestino);
    }
    
    public Boolean rechazarPeticion(String usernameOrigen, String usernameDestino) throws Exception{
        return this.fc.rechazarPeticion(usernameOrigen, usernameDestino);
    }
    
    public ArrayList<String> obtenerPeticiones(String usuarioActual) throws Exception{
        return this.fc.obtenerPeticiones(usuarioActual);
    }
    
    public void actualizarPeticiones(){
        this.fg.actualizarPeticiones();
    }
    
    public void notificarDesconection() throws Exception{
        this.fc.notificarDesconection(this.getUsuarioActual());
    }
    
}
