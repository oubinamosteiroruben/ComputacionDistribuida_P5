package Server;

import modelos.Usuario;
import java.rmi.*;
import java.util.List;

public interface ServerInterface extends Remote {
    

    //public int get(int n) throws java.rmi.RemoteException;
    
    public List<Usuario> iniciarSesion(Usuario usuario) throws RemoteException;
    
    public Boolean registrarUsuario(Usuario usuario) throws RemoteException;
    
}
