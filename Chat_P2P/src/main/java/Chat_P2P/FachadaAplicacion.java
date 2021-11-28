
package Chat_P2P;

import gui.FachadaGui;

public class FachadaAplicacion {
    
    private FachadaGui fg;
    
    public FachadaAplicacion(){
        this.fg = new FachadaGui(this);
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
    
    
    
}
