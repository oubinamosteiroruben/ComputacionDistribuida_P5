
package Chat_P2P.RMI;

import Chat_P2P.FachadaAplicacion;
import static definiciones.Definiciones.BASE_PORT;
import java.io.*;
import java.rmi.*;
import modelos.Mensaje;

public class FachadaRMI {
    
    private final FachadaAplicacion fa;
    
    private ServerInterface si;
    
    private Integer port;
    
    public FachadaRMI(FachadaAplicacion fa){
        this.fa = fa;
        this.port = BASE_PORT;
        try{
            declararServerInterface();
        }catch(Exception e){
            System.out.println("Exception: " + e);
        }
    }
    
    public void declararServerInterface() throws Exception{
        int RMIPort;
        String hostName;
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        System.out.println("Enter the RMIRegistry host namer:");
        hostName = br.readLine();
        System.out.println("Enter the RMIregistry port number:");
        String portNum = br.readLine();
        RMIPort = Integer.parseInt(portNum);
        System.out.println("Enter the id:");
        String id = br.readLine();
        String registryURL = "rmi://" + hostName+ ":" + portNum + "/p5";
            // find the remote object and cast it to an interface object
        ServerInterface h = (ServerInterface) Naming.lookup(registryURL);
        System.out.println("Lookup completed " );
        this.si = h;
    } //end main
    
    public Mensaje registrarUsuario(String username, String password) throws Exception{
        return this.si.registrarUsuario(username, password);
    }
    
    public void iniciarSesion(String username, String password){
        
    }
    
}
