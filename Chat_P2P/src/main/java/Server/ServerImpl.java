package Server;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import modelos.Mensaje;
import modelos.Usuario;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface {

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
    
    
    
}
