
package Server;

import dao.FachadaDAO;
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
    
    public void muestraExcepcion(String e) {
        System.out.println("Excepcion: " + e);
    }
    
    public Boolean registrarUsuario(Usuario usuario){
        return fd.registrarUsuario(usuario);
    }

}
