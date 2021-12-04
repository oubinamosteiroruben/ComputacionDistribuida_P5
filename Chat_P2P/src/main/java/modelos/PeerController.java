/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.HashMap;


public class PeerController {
    
    private HashMap<String, Usuario> usuariosOnline;
    private static PeerController instancia;
    
    public PeerController() {
        this.usuariosOnline = new HashMap<>();
    }
    
    public static PeerController getInstance() {
        if (instancia == null) {
            instancia = new PeerController();
        }
        return instancia;
    }
    
    public void anhadirUsuarioOnline(Usuario usuario){
        if(usuariosOnline != null)
            this.usuariosOnline.put(usuario.getUsername(), usuario);
    }
    
    public void notificarAmigoOnline(Usuario usuarioOrigen, Usuario usuarioDestino){
        
    }
    
}
