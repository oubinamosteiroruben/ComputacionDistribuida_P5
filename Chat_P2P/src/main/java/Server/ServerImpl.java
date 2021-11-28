package Server;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import modelos.Usuario;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface {

    private Server server;
    
    public ServerImpl(Server s) throws RemoteException{
        super();
        this.server = s;
    }

    public List<Usuario> iniciarSesion(Usuario usuario) throws RemoteException{
        server.iniciarSesion(usuario);
        
        return server.getAmigos(usuario);
    }
    
}
