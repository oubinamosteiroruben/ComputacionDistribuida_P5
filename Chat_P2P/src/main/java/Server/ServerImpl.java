package Server;

import Cliente.PeerChatInterface;
import Cliente.PeerConectionInterface;
import definiciones.Definiciones;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import modelos.Mensaje;
import modelos.Usuario;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface {

    private final FachadaServer fs;
    
    public ServerImpl(FachadaServer fs) throws Exception{
        this.fs = fs;
    }
    
    public HashMap<String,PeerChatInterface> iniciarSesion(String username, String password, PeerChatInterface peerChatInterface, PeerConectionInterface peerConnectionInterface) throws RemoteException{
        HashMap<String,PeerChatInterface> resultado = null;
        if(this.fs.iniciarSesion(username, password,peerChatInterface,peerConnectionInterface)){
            resultado = this.fs.obtenerAmigos(username);
            // se le avisa a los amigos conectados que se ha iniciado sesión
            for(PeerConectionInterface peer: this.fs.obtenerConectionAmigos(username).values()){
                peer.notificarConexion(username, peerChatInterface);
            }
        }
        return  resultado;
    }
    
    public HashMap<String,PeerChatInterface> registrarUsuario(String username, String password, PeerChatInterface peerChatInterface, PeerConectionInterface peerConnectionInterface) throws RemoteException{
        HashMap<String,PeerChatInterface> resultado = null;
        Mensaje mensajeRes = this.fs.registrarUsuario(username, password,peerChatInterface,peerConnectionInterface);
        if(mensajeRes.getCodigo() == Definiciones.EXITO){
            resultado = new HashMap<>();
        }
        return  resultado;
    }
    
    public Boolean enviarPeticion(String usernameEmisor, String usernameReceptor) throws RemoteException{
        return this.fs.enviarPeticion(usernameEmisor, usernameReceptor);
    }
    
    public Boolean aceptarPeticion(String usernameEmisor, String usernameReceptor) throws RemoteException{
        return this.fs.aceptarPeticion(usernameEmisor, usernameReceptor);
    }
    
    public Boolean rechazarPeticion(String usernameEmisor, String usernameReceptor) throws RemoteException{
        return this.fs.rechazarPeticion(usernameEmisor, usernameReceptor);
    }
    
    public ArrayList<String> obtenerPeticiones(String usuarioActual) throws RemoteException{
        return this.fs.obtenerPeticiones(usuarioActual);
    }
    
    public void notificarDesconection(String usuario) throws RemoteException{
        this.fs.notificarDesconection(usuario);
    }
    
  
}
