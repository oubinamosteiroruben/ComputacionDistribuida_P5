
package Chat_P2P.RMI;

import Chat_P2P.FachadaAplicacion;
import Server.ServerInterface;
import static definiciones.Definiciones.PORT;
import java.io.*;
import java.rmi.*;
import java.util.HashMap;
import modelos.Mensaje;
import modelos.Usuario;

public class FachadaRMI {
    
    private final FachadaAplicacion fa;
    
    private ServerInterface si;
    
    private Integer port;
    
    public FachadaRMI(FachadaAplicacion fa){
        this.fa = fa;
        this.port = Integer.parseInt(PORT);
        try{
            declararServerInterface();
        }catch(Exception e){
            System.out.println("Exception: " + e);
        }
    }
    
    public void declararServerInterface() throws Exception{
        String hostName = "localhost";
        
        /*
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        System.out.println("Enter the RMIRegistry host namer:");
        hostName = br.readLine();
        System.out.println("Enter the RMIregistry port number:");
        String portNum = br.readLine();
        RMIPort = Integer.parseInt(portNum);
        System.out.println("Enter the id:");
        String id = br.readLine();
        */
        
        String registryURL = "rmi://" + hostName + ":" + this.port + "/chatP2P";
            // find the remote object and cast it to an interface object
        ServerInterface serverInterface = (ServerInterface) Naming.lookup(registryURL);
        System.out.println("Lookup completed " );
        this.si = serverInterface;
        
    } //end main
    
    
    public Usuario iniciarSesion(String username, String password) throws Exception{
        // TODO: falla aquí al traer el usuario
        Usuario usuario = new Usuario(username);
        usuario = this.si.iniciarSesion(username, password);
        /*try{
            usuario = this.si.iniciarSesion(username, password);
        } catch(Exception e){
            System.out.println("Excepcion:");
            e.printStackTrace();
        }
        System.out.println("david 2");
        */
        return usuario;
    }
    
    public Mensaje registrarUsuario(String username, String password) throws Exception{
        return this.si.registrarUsuario(username, password);
    }
    
    public HashMap<String, Usuario> obtenerAmigos(String username) throws Exception{
        return this.si.obtenerAmigos(username);
    }
    
    
}
