package Server;

import modelos.Usuario;
import java.rmi.*;
import java.util.ArrayList;
import modelos.Mensaje;

public interface ServerInterface extends Remote {
    

    //public int get(int n) throws java.rmi.RemoteException;
    
    public ArrayList<String> iniciarSesion(String username, String password) throws RemoteException;
    
    public Mensaje registrarUsuario(String username, String password) throws RemoteException;
    
}
