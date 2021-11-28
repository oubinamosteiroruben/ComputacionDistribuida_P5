
package dao;

import Server.FachadaServer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuarios extends AbstractDAO{
    
    // -------------------------------------------------------------------------
    // ------------------------------ Constructor ------------------------------
    public DAOUsuarios(Connection conexion, FachadaServer fs) {
        super.setConexion(conexion);
        super.setFachadaServer(fs);
    }    
}
