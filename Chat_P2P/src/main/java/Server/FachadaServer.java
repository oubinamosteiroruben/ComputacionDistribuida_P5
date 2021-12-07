
package Server;

import Cliente.PeerChatInterface;
import Cliente.PeerConectionInterface;
import dao.FachadaDAO;
import definiciones.Definiciones;
import java.util.ArrayList;
import java.util.HashMap;
import modelos.Mensaje;
import modelos.Usuario;

public class FachadaServer {
    private final FachadaDAO fd;
    private final Server server;
    
    private FachadaServer(){
        fd = new FachadaDAO(this);
        server = new Server(this);
    }
    
    public static void main(String args[]) {
        FachadaServer fs;
        fs = new FachadaServer();
        
    }
    
    public Boolean iniciarSesion(String username, String password, PeerChatInterface peerChatInterface, PeerConectionInterface peerConectionInterface){
        Boolean resultado = this.fd.iniciarSesion(username, password);
        if(resultado){
            server.addUsuarioConectado(username,peerChatInterface,peerConectionInterface);
        }
        return resultado;
    }
    
    public HashMap<String,PeerChatInterface> obtenerAmigos(String username){
        return this.server.obtenerInfoAmigosConectados(this.fd.obtenerAmigos(username));
    }
    
    public HashMap<String,PeerConectionInterface> obtenerConectionAmigos(String username){
        return this.server.obtenerConectionAmigosConectados(this.fd.obtenerAmigos(username));
    }
    
    public Mensaje registrarUsuario(String username, String password, PeerChatInterface peerChatInterface, PeerConectionInterface peerConectionInterface){
        Mensaje resultado = this.fd.registrarUsuario(username, password);
        if(resultado.getCodigo() == Definiciones.EXITO){
            server.addUsuarioConectado(username,peerChatInterface,peerConectionInterface);
        }
        return resultado;
    }
    
    public Boolean enviarPeticion(String usernameEmisor, String usernameReceptor){
        boolean resultado = this.fd.enviarPeticion(usernameEmisor, usernameReceptor);
        if(resultado){
            server.addSolicitud(usernameEmisor, usernameReceptor);
        }
        return resultado;
    }
    
    public Boolean aceptarPeticion(String usernameEmisor, String usernameReceptor){
        boolean resultado = this.fd.aceptarPeticion(usernameEmisor, usernameReceptor);
        if(resultado){
            server.solicitudAceptada(usernameEmisor, usernameReceptor);
        }
        return resultado;
    }
    
    public Boolean rechazarPeticion(String usernameEmisor, String usernameReceptor){
        return this.fd.rechazarPeticion(usernameEmisor, usernameReceptor);
    }
    
    public ArrayList<String> obtenerPeticiones(String usuarioActual){
        return this.fd.obtenerPeticiones(usuarioActual);
    }
    
    public void notificarDesconection(String usuario){
        this.server.notificarDesconection(usuario);
    }
    
    public void muestraExcepcion(String e) {
        System.out.println("Excepcion: " + e);
    }
    
}
