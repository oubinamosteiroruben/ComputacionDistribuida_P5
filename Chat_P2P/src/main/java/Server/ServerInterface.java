package Server;

import Cliente.PeerChatInterface;
import Cliente.PeerConectionInterface;
import java.rmi.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ServerInterface extends Remote {
    

    //public int get(int n) throws java.rmi.RemoteException;
    /*
    public Usuario iniciarSesion(String username, String password) throws RemoteException;
    
    public Mensaje registrarUsuario(String username, String password) throws RemoteException;
    
    public HashMap<String,Usuario> obtenerAmigos(String username) throws RemoteException;
    
    public ArrayList<String> obtenerPeticiones(String usernameReceptor) throws RemoteException;


    */
    
    public HashMap<String,PeerChatInterface> iniciarSesion(String username, String password, PeerChatInterface peerChatInterface, PeerConectionInterface peerConnectionInterface) throws RemoteException;

    public HashMap<String,PeerChatInterface> registrarUsuario(String username, String password, PeerChatInterface peerChatInterface, PeerConectionInterface peerConnectionInterface) throws RemoteException;

    public Boolean enviarPeticion(String usernameEmisor, String usernameReceptor) throws RemoteException;
    
    public Boolean aceptarPeticion(String usernameEmisor, String usernameReceptor) throws RemoteException;
    
    public Boolean rechazarPeticion(String usernameEmisor, String usernameReceptor) throws RemoteException;
    
    public ArrayList<String> obtenerPeticiones(String usuarioActual) throws RemoteException;
    
    public void notificarDesconection(String usuario) throws RemoteException;
    
}
