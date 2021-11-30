
package Server;

import dao.FachadaDAO;
import java.util.ArrayList;
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
    
    //--------------------------------------------------------
    
    public void cerrarConexion(){
        this.cerrarConexion();
    }
    
    public void muestraExcepcion(String e) {
        System.out.println("Excepcion: " + e);
    }
    
    public Boolean iniciarSesion(String username, String password){
        return this.fd.iniciarSesion(username, password);
    }
    
    public Mensaje registrarUsuario(String username, String password){
        return this.fd.registrarUsuario(username, password);
    }
    
    public ArrayList<String> obtenerAmigos(String username){
        return this.fd.obtenerAmigos(username);
    }
    
    public Boolean enviarPeticion(String usernameEmisor, String usernameReceptor){
        return this.fd.enviarPeticion(usernameEmisor, usernameReceptor);
    }
    
    public Boolean aceptarPeticion(String usernameEmisor, String usernameReceptor){
        return this.fd.aceptarPeticion(usernameEmisor, usernameReceptor);
    }
    
    public Boolean rechazarPeticion(String usernameEmisor, String usernameReceptor){
        return this.fd.rechazarPeticion(usernameEmisor, usernameReceptor);
    }
    
    public ArrayList<String> obtenerPeticiones(String usernameEmisor){
        return this.fd.obtenerPeticiones(usernameEmisor);
    }

}
