
package dao;

import Server.FachadaServer;

public abstract class AbstractDAO {

    private java.sql.Connection conexion;
    private FachadaServer fs;

    // -------------------------------------------------------------------------
    // --------------------------------- Getters -------------------------------
    protected java.sql.Connection getConexion() {
        return this.conexion;
    }

    protected FachadaServer getFachadaServer() {
        return fs;
    }

    // -------------------------------------------------------------------------
    // --------------------------------- Setters -------------------------------
    protected void setFachadaServer(FachadaServer fs) {
        this.fs = fs;
    }

    protected void setConexion(java.sql.Connection conexion) {
        this.conexion = conexion;
    }
}

