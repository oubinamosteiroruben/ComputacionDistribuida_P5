package Server;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.Random;
import modelos.Mensaje;
import modelos.Usuario;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface {

    private Server server;
    
    public ServerImpl(Server s) throws RemoteException{
        super();
        this.server = s;
    }

    // esto hay que cambiarlo !!!
    public ArrayList<String> iniciarSesion(String username, String password) throws RemoteException{
        server.iniciarSesion(username, password);
        
        return server.obtenerAmigos(username);
    }
    
    public Mensaje registrarUsuario(String username, String password) throws RemoteException{
        return server.registrarUsuario(username, password);
    }
    
}
