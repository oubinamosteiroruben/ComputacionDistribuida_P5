
package Chat_P2P;

import Chat_P2P.RMI.FachadaRMI;
import gui.FachadaGui;
import java.util.List;
import modelos.Mensaje;
import modelos.Usuario;

public class FachadaAplicacion {
    
    private final FachadaGui fg;
    private final FachadaRMI frmi;
    
    private Usuario usuarioActual;
    private List<Usuario> amigos;
    
    
    public FachadaAplicacion(){
        this.fg = new FachadaGui(this);
        this.frmi = new FachadaRMI(this);
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
    
    //------------------- Login -------------------
    
    public Mensaje registrarUsuario(String username, String password) throws Exception{
        return this.frmi.registrarUsuario(username, password);
    }
    
    public void iniciarSesion(String username, String password){
        this.frmi.iniciarSesion(username,password);
    }
    
}
