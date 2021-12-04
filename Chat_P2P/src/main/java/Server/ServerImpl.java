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
            for(PeerChatInterface peer: resultado.values()){
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
    
    /*
    private Server server;
    
    public ServerImpl(Server s) throws RemoteException{
        super();
        this.server = s;
    }

   
    public Usuario iniciarSesion(String username, String password) throws RemoteException{
        return server.iniciarSesion(username, password);
    }
    
    public Mensaje registrarUsuario(String username, String password) throws RemoteException{
        return server.registrarUsuario(username, password);
    }
    
    public HashMap<String,Usuario> obtenerAmigos(String username) throws RemoteException{
        return server.obtenerAmigos(username);
    }
    
    public Boolean enviarPeticion(String usernameEmisor, String usernameReceptor) throws RemoteException{
        return server.enviarPeticion(usernameEmisor, usernameReceptor);
    }
    
    public ArrayList<String> obtenerPeticiones(String usernameReceptor) throws RemoteException{
        return server.obtenerPeticiones(usernameReceptor);
    }
    
    */
}
