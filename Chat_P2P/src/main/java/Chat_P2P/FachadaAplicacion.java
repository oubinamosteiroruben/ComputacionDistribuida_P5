
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
    
    /*private final FachadaRMI frmi;
    
    private Usuario usuarioActual;
    private HashMap<String, Usuario> amigos;
    private ArrayList<String> solicitudesRecibidas;
    */
    
    public FachadaAplicacion(){
        this.fc = new FachadaCliente(this);
        this.fg = new FachadaGui(this);
/*        this.amigos = new HashMap<>();
        this.fg = new FachadaGui(this);
        this.frmi = new FachadaRMI(this);*/
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
    
    
    /*
    //------------------- Login -------------------
    
    public Boolean iniciarSesion(String username, String password) throws Exception{
        boolean resultado = false;
        this.amigos = this.frmi.iniciarSesion(username,password);
        
        if(usuario.isConectado()){
            this.usuarioActual = usuario;
            this.amigos = this.frmi.obtenerAmigos(this.usuarioActual.getUsername());
            this.fg.lanzarChat();
            resultado = true;
        }
        
        /*if(usuario.getPeerInterface() != null){
            this.usuarioActual = usuario;
            usuario.getPeerInterface().setFachadaAplicacion(this);
            this.amigos = this.frmi.obtenerAmigos(this.usuarioActual.getUsername());
            this.fg.lanzarChat();
            resultado = true;
        } */
        /*
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
    
    public ArrayList<String> obtenerPeticiones() throws Exception{
        return this.frmi.obtenerPeticiones(usuarioActual.getUsername());
    }
    
    public void actualizarPeticiones() throws Exception{
        solicitudesRecibidas = obtenerPeticiones();
        this.fg.actualizarPeticiones(solicitudesRecibidas);
    }
    
    public void actualizarAmigos() {
        ArrayList<Usuario> amigosOn = new ArrayList<>(this.amigos.values());
        this.fg.actualizarAmigos(amigosOn);
    }
    
    */
}
