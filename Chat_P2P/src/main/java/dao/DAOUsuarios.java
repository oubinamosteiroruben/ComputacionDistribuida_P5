
package dao;

import Server.FachadaServer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelos.Usuario;

public class DAOUsuarios extends AbstractDAO{
    
    // -------------------------------------------------------------------------
    // ------------------------------ Constructor ------------------------------
    public DAOUsuarios(Connection conexion, FachadaServer fs) {
        super.setConexion(conexion);
        super.setFachadaServer(fs);
    }    
    
    
    public Boolean registrarUsuario(Usuario usuario){
        // Registrar usuario
        // Si es posible realizar el registrar return true -- sino, false
        return false;
    }
}
