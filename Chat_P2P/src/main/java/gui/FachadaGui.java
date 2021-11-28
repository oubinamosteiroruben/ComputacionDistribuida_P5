
package gui;

import Chat_P2P.FachadaAplicacion;

public class FachadaGui {
    private final FachadaAplicacion fa;
    private final VUsuario vp;
    
    public FachadaGui(FachadaAplicacion fa){
        this.fa = fa;
        vp = new VUsuario(fa);
    }
}
