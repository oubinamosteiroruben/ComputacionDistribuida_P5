
package dao;

import Server.FachadaServer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FachadaDAO {
    private final FachadaServer fs;
    private java.sql.Connection conexion;
    private DAOUsuarios daoUsuarios;

    // -------------------------------------------------------------------------
    // ------------------------------ Constructor ------------------------------
    public FachadaDAO(FachadaServer fs) {

        Properties configuracion = new Properties();
        this.fs = fs;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://"
                    + configuracion.getProperty("servidor") + ":"
                    + configuracion.getProperty("puerto") + "/"
                    + configuracion.getProperty("baseDatos"),
                    usuario);
            
            this.daoUsuarios = new DAOUsuarios(this.conexion, this.fs);
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
            this.fs.muestraExcepcion(f.getMessage());
        } catch (IOException i) {
            System.out.println(i.getMessage());
            this.fs.muestraExcepcion(i.getMessage());
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
            this.fs.muestraExcepcion(e.getMessage());
        }
    }

    
}
