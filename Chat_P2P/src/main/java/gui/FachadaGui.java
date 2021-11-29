
package gui;

import Chat_P2P.FachadaAplicacion;
import gui.paneles.LoginPanel_Login;

public class FachadaGui {
    private final FachadaAplicacion fa;
    private final VUsuario vp;
    private final VLogin vl;
    
    public FachadaGui(FachadaAplicacion fa){
        this.fa = fa;
        vl = new VLogin(fa);
        vp = new VUsuario(fa);
    }
    
    public void iniciarVista(){
        this.vl.setVisible(true);
    }
    
}
