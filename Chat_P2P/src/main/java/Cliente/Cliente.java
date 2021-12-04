
package Cliente;

import Chat_P2P.FachadaAplicacion;
import Server.ServerInterface;
import definiciones.Definiciones;
import gui.FachadaGui;
import java.rmi.Naming;
import java.util.HashMap;

public class Cliente {
    
    private FachadaAplicacion fa;
    
    public Cliente(FachadaAplicacion fa){
        this.fa = fa;
        try{
            
            Peer.getInstance().setServer(obtenerServidor());
            Peer.getInstance().setPeerChat(new PeerChatImpl());
            Peer.getInstance().setPeerConection(new PeerConectionImpl());
        
        }catch(Exception e){
            System.out.println("Exception: " + e);
        }
    }

    public FachadaAplicacion getFachadaAplicacion() {
        return fa;
    }

    public void setFachadaAplicacion(FachadaAplicacion fa) {
        this.fa = fa;
    }
    
    
    
    public ServerInterface obtenerServidor(){
        ServerInterface serverInterface = null;
        try{
            String hostName = "localhost";
            String registryURL = "rmi://" + hostName + ":" + Definiciones.PORT + "/chatP2P";
                // find the remote object and cast it to an interface object
            serverInterface = (ServerInterface) Naming.lookup(registryURL);
            System.out.println("Lookup completed " );
        }catch(Exception e){
            System.out.println("Exception: " + e);
        }
        return serverInterface;
    }
    
    public Boolean iniciarSesion(String username, String password) throws Exception{
        Boolean resultado = false;
        HashMap<String,PeerChatInterface> amigos = Peer.getInstance().getServer().iniciarSesion(username,password,Peer.getInstance().getPeerChat(),Peer.getInstance().getPeerConection());
        
        if(amigos != null){
            resultado = true;
            // le fijamos los amigos que están online al cliente actual
            Peer.getInstance().setAmigos(amigos);
        }
        return  resultado;
    }
    
    public Boolean registrarUsuario(String username, String password) throws Exception{
        Boolean resultado = false;
        Peer p = Peer.getInstance();
        HashMap<String,PeerChatInterface> amigos = Peer.getInstance().getServer().registrarUsuario(username,password,Peer.getInstance().getPeerChat(),Peer.getInstance().getPeerConection());
        
        if(amigos != null){
            resultado = true;
            Peer.getInstance().setAmigos(amigos);
        }
        return  resultado;
    }
}
