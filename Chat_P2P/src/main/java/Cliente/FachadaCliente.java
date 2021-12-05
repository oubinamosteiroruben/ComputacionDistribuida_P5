
package Cliente;

import Chat_P2P.FachadaAplicacion;
import java.util.ArrayList;
import modelos.Mensaje;
import modelos.MensajeChat;

public class FachadaCliente {
    
    private final Cliente cliente;
    private final FachadaAplicacion fa;
    
    public FachadaCliente(FachadaAplicacion fa){
        this.fa = fa;
        this.cliente = new Cliente(fa);
        Peer.getInstance().setCliente(this.cliente);
    }
    
    public Boolean iniciarSesion(String username, String password) throws Exception{
        return this.cliente.iniciarSesion(username,password);
    }
    
    public Boolean registrarUsuario(String username, String password) throws Exception{
        return this.cliente.registrarUsuario(username,password);
    }
    
    public String getUsuarioActual(){
        return Peer.getInstance().getUsuario();
    }
    
    public void enviarMensaje(MensajeChat mc) throws Exception{
        Peer.getInstance().getAmigos().get(mc.getReceptor()).enviarMensaje(mc);
    }
    
    public Boolean enviarPeticion(String usernameOrigen, String usernameDestino) throws Exception{
        return this.cliente.enviarPeticion(usernameOrigen, usernameDestino);
    }
    
    public Boolean aceptarPeticion(String usernameOrigen, String usernameDestino) throws Exception{
        return this.cliente.aceptarPeticion(usernameOrigen, usernameDestino);
    }
    
    public Boolean rechazarPeticion(String usernameOrigen, String usernameDestino) throws Exception{
        return this.cliente.rechazarPeticion(usernameOrigen, usernameDestino);
    }
    
    public ArrayList<String> obtenerPeticiones(String usuarioActual) throws Exception{
        return this.cliente.obtenerPeticiones(usuarioActual);
    }
    
}
