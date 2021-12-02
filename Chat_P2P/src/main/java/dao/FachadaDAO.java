
package dao;

import Server.FachadaServer;

import java.sql.*;
import java.util.ArrayList;
import modelos.Mensaje;
import modelos.Usuario;

public class FachadaDAO {
    private final FachadaServer fs;
    private java.sql.Connection conexion;
    private DAOUsuarios daoUsuarios;

    // -------------------------------------------------------------------------
    // ------------------------------ Constructor ------------------------------
    public FachadaDAO(FachadaServer fs) {

        this.fs = fs;
        String url = "BaseDeDatos/BD_Chat_P2P.db"; // establecer la ruta

        try {
            this.conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (this.conexion != null) {
                System.out.println("La conexión con la base de datos se ha realizado correctamente.");
                this.daoUsuarios = new DAOUsuarios(this.conexion, this.fs);
            }
        }catch (SQLException e) {
            this.fs.muestraExcepcion(e.getMessage());
        }
    }

    
    //-------------------------------------------------------------------
    public void cerrarConexion(String url){
        try {
            this.conexion.close();
        } catch (SQLException e) {
            this.fs.muestraExcepcion(e.getMessage());
        }
     }

    //-------------------------------------------------------------------
    
    public Boolean iniciarSesion(String username, String password){
        return this.daoUsuarios.iniciarSesion(username, password);
    }
    
    public Mensaje registrarUsuario(String username, String password){
        return this.daoUsuarios.registrarUsuario(username, password);
    }
    
    public ArrayList<String> obtenerAmigos(String username){
        return this.daoUsuarios.obtenerAmigos(username);
    }
    
    public Boolean enviarPeticion(String usernameEmisor, String usernameReceptor){
        return this.daoUsuarios.enviarPeticion(usernameEmisor, usernameReceptor);
    }
    
    public Boolean aceptarPeticion(String usernameEmisor, String usernameReceptor){
        return this.daoUsuarios.aceptarPeticion(usernameEmisor, usernameReceptor);
    }
    
    public Boolean rechazarPeticion(String usernameEmisor, String usernameReceptor){
        return this.daoUsuarios.rechazarPeticion(usernameEmisor, usernameReceptor);
    }
    
    public ArrayList<String> obtenerPeticiones(String usernameReceptor){
        return this.daoUsuarios.obtenerPeticiones(usernameReceptor);
    }
    
}
