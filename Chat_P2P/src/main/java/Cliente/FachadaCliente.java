
package Cliente;

import Chat_P2P.FachadaAplicacion;
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
    
}
