package Server;

import modelos.Usuario;
import java.rmi.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import modelos.Mensaje;

public interface ServerInterface extends Remote {
    

    //public int get(int n) throws java.rmi.RemoteException;
    
    public Usuario iniciarSesion(String username, String password) throws RemoteException;
    
    public Mensaje registrarUsuario(String username, String password) throws RemoteException;
    
    public HashMap<String,Usuario> obtenerAmigos(String username) throws RemoteException;
    
   public Boolean enviarPeticion(String usernameEmisor, String usernameReceptor) throws RemoteException;
    
    public ArrayList<String> obtenerPeticiones(String usernameReceptor) throws RemoteException;
}
