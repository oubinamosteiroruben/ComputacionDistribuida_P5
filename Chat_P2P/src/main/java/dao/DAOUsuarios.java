
package dao;

import Chat_P2P.GeneracionDeContrasenhas;
import org.apache.commons.codec.binary.Hex;
import Server.FachadaServer;
import static definiciones.Definiciones.*;
import java.sql.*;
import java.util.ArrayList;
import modelos.*;

public class DAOUsuarios extends AbstractDAO{
    
    // -------------------------------------------------------------------------
    // ------------------------------ Constructor ------------------------------
    public DAOUsuarios(Connection conexion, FachadaServer fs) {
        super.setConexion(conexion);
        super.setFachadaServer(fs);
    }    
    
    // devuelve true si se puede iniciar sesion y false en otro caso
    public Boolean iniciarSesion(String username, String password){
        // Iniciar sesion
        PreparedStatement st = null;
        ResultSet rs;
        Boolean resultado = false;
        // creamos la clase para generar contraseñas
        GeneracionDeContrasenhas gc = new GeneracionDeContrasenhas();
        Connection con = super.getConexion();
        
        try {
            st = con.prepareStatement("SELECT salt "
                                        + "FROM usuario "
                                        + "WHERE username = ?");
            st.setString(1, username);
            rs = st.executeQuery();
            if (rs.next()) {
                // obtenemos la semilla del usuario
                String saltTexto = rs.getString("salt");
                // obtenemos la contraseña hasheada a partir de la informacion introducida en el login
                String passwordGenerada = Hex.encodeHexString(gc.generarContrasenha(password, 
                                                    Hex.decodeHex(saltTexto.toCharArray())));
                // comprobamos si coincide con la de la base de datos
                st = con.prepareStatement("SELECT password like ? AS resultado "
                                        + "FROM usuario "
                                        + "WHERE username = ?");
                st.setString(1, passwordGenerada);
                st.setString(2, username);
                rs = st.executeQuery();
                // obtenemos la respuesta
                resultado = rs.getBoolean("resultado");

            } else{
                // no existe un usuario con ese nombre, devolvemos false
                resultado = false;
            }
        } catch (SQLException e) {
            this.getFachadaServer().muestraExcepcion(e.getMessage());
        } catch(Exception e){
            this.getFachadaServer().muestraExcepcion(e.getMessage());
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                this.getFachadaServer().muestraExcepcion(e.getMessage());
            }
        }
        
        return resultado;
    }
    
    // devuelve un mensaje especificando lo que ha sucedido
    // si el codigo del mensaje es "EXITO", el usuario se ha podido registrar correctamente
    public Mensaje registrarUsuario(String username, String password){
        // Registrar usuario
        PreparedStatement st = null;
        ResultSet rs;
        Mensaje mensaje = new Mensaje();
        // creamos la clase para generar contraseñas
        GeneracionDeContrasenhas gc = new GeneracionDeContrasenhas();
        Connection con = super.getConexion();
        
        try {
            st = con.prepareStatement("SELECT username "
                                        + "FROM usuario "
                                        + "WHERE username = ?");
            st.setString(1, username);
            rs = st.executeQuery();
            if (rs.next()) {
                // el usuario ya existe, enviamos mensaje y paramos
                mensaje.setCodigo(FRACASO);
                mensaje.setMensaje(MENSAJE_USUARIO_EXISTE);
            } else{
                // generamos la semilla
                byte[] salt = gc.generarSalt();
                // y obtenemos la contraseña
                String contrasenhaHasheada = Hex.encodeHexString(gc.generarContrasenha(password, salt));
                // convertimos la semilla a string para almacenarla en la base de datos
                String saltTexto = Hex.encodeHexString(salt);

                st = con.prepareStatement("INSERT INTO usuario (username, password, salt) VALUES (?,?,?)");
                st.setString(1, username);
                st.setString(2, contrasenhaHasheada);
                st.setString(3, saltTexto);
                if (st.executeUpdate() == 1) {
                    // se ha añadido correctamente
                    mensaje.setCodigo(EXITO);
                    mensaje.setMensaje(MENSAJE_EXITO);
                } else{
                    mensaje.setCodigo(FRACASO);
                    mensaje.setMensaje(MENSAJE_USUARIO_EXISTE);
                }

            }
        } catch (SQLException e) {
            this.getFachadaServer().muestraExcepcion(e.getMessage());
        } catch(Exception e){
            this.getFachadaServer().muestraExcepcion(e.getMessage());
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                this.getFachadaServer().muestraExcepcion(e.getMessage());
            }
        }
        
        return mensaje;
    }
    
    // devuelve la lista de amigos de un usuario
    public ArrayList<String> obtenerAmigos(String username){
        // Obtener amigos
        PreparedStatement st = null;
        ResultSet rs;
        ArrayList<String> amigos = new ArrayList<>();
        
        Connection con = super.getConexion();
        
        try {
            st = con.prepareStatement("SELECT amigo1 as amigo FROM amistad WHERE amigo2 = ? "
                                        + "UNION "
                                        + "SELECT amigo2 as amigo FROM amistad WHERE amigo1 = ?");
            st.setString(1, username);
            st.setString(2, username);
            rs = st.executeQuery();
            while (rs.next()) {
                amigos.add(rs.getString("amigo"));
            } 
        } catch (SQLException e) {
            this.getFachadaServer().muestraExcepcion(e.getMessage());
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                this.getFachadaServer().muestraExcepcion(e.getMessage());
            }
        }
        
        return amigos;
    }
    
    // añade la petición como pendiente y devuelve true si se ha completado con exito
    public Boolean enviarPeticion(String usernameEmisor, String usernameReceptor){
        // Enviar peticion de amistad
        PreparedStatement st = null;
        ResultSet rs;
        Boolean resultado = false;
        
        Connection con = super.getConexion();
        
        try {
            st = con.prepareStatement("SELECT COUNT(*) = 2 AS resultado FROM usuario "
                                        + "WHERE username = ? OR username = ?");
            st.setString(1, usernameEmisor);
            st.setString(2, usernameReceptor);
            rs = st.executeQuery();
            
            if (rs.getBoolean("resultado")) {
                // si existen los dos usuarios, insertamos una peticion nueva
                st = con.prepareStatement("INSERT INTO solicitudAmistad (amigoEmisor, amigoReceptor, estado) "
                                            + "VALUES (?,?,?)");
                st.setString(1, usernameEmisor);
                st.setString(2, usernameReceptor);
                st.setString(3, "p");
                
                resultado = (st.executeUpdate() == 1);
            } else{
                // alguno de los usuarios no está en la base de datos, devolvemos false
                resultado = false;
            }
        } catch (SQLException e) {
            this.getFachadaServer().muestraExcepcion(e.getMessage());
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                this.getFachadaServer().muestraExcepcion(e.getMessage());
            }
        }
        
        return resultado;
    }
    
    // acepta una peticion existente y devuelve true si se ha completado con exito
    public Boolean aceptarPeticion(String usernameEmisor, String usernameReceptor){
        // Aceptar peticion de amistad
        PreparedStatement st = null;
        ResultSet rs;
        Boolean resultado = false;
        
        Connection con = super.getConexion();
        
        try {
            st = con.prepareStatement("SELECT COUNT(*) = 1 AS resultado FROM solicitudAmistad "
                                        + "WHERE amigoEmisor = ? AND amigoReceptor = ? AND estado = ?");
            // aqui se ponen al revés el emisor y el receptor
            st.setString(1, usernameReceptor);
            st.setString(2, usernameEmisor);
            st.setString(3, "p");
            rs = st.executeQuery();
            
            if (rs.getBoolean("resultado")) {
                // si existe esa peticion
                st = con.prepareStatement("UPDATE solicitudAmistad SET estado = ? "
                                            + "WHERE amigoEmisor = ? AND amigoReceptor = ?");
                st.setString(1, "a");
                // se ponen al revés emisor y receptor
                st.setString(2, usernameReceptor);
                st.setString(3, usernameEmisor);
                
                resultado = (st.executeUpdate() == 1);
            } else{
                // si no existe esa peticion como pendiente, devolvemos false
                resultado = false;
            }
        } catch (SQLException e) {
            this.getFachadaServer().muestraExcepcion(e.getMessage());
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                this.getFachadaServer().muestraExcepcion(e.getMessage());
            }
        }
        
        return resultado;
    }
    
    // rechaza una peticion existente y devuelve true si se ha completado con exito
    public Boolean rechazarPeticion(String usernameEmisor, String usernameReceptor){
        // Rechazar peticion de amistad
        PreparedStatement st = null;
        ResultSet rs;
        Boolean resultado = false;
        
        Connection con = super.getConexion();
        
        try {
            st = con.prepareStatement("SELECT COUNT(*) = 1 AS resultado FROM solicitudAmistad "
                                        + "WHERE amigoEmisor = ? AND amigoReceptor = ? AND estado = ?");
            st.setString(1, usernameEmisor);
            st.setString(2, usernameReceptor);
            st.setString(3, "p");
            rs = st.executeQuery();
            
            if (rs.getBoolean("resultado")) {
                // si existe esa peticion
                st = con.prepareStatement("UPDATE solicitudAmistad SET estado = ? "
                                            + "WHERE amigoEmisor = ? AND amigoReceptor = ?");
                st.setString(1, "r");
                st.setString(2, usernameEmisor);
                st.setString(3, usernameReceptor);
                
                resultado = (st.executeUpdate() == 1);
            } else{
                // si no existe esa peticion como pendiente, devolvemos false
                resultado = false;
            }
        } catch (SQLException e) {
            this.getFachadaServer().muestraExcepcion(e.getMessage());
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                this.getFachadaServer().muestraExcepcion(e.getMessage());
            }
        }
        
        return resultado;
    }
    
    // obtiene todas las peticiones pendientes y las devuelve en un arraylist
    public ArrayList<String> obtenerPeticiones(String usernameReceptor){
        // Rechazar peticion de amistad
        PreparedStatement st = null;
        ResultSet rs;
        ArrayList<String> solicitudes = new ArrayList<>();
        
        Connection con = super.getConexion();
        
        try {
            st = con.prepareStatement("SELECT amigoEmisor FROM solicitudAmistad "
                                        + "WHERE amigoReceptor = ? AND estado = ?");
            st.setString(1, usernameReceptor);
            st.setString(2, "p");
            rs = st.executeQuery();
            
            while(rs.next()) {
                solicitudes.add(rs.getString("amigoEmisor"));
            }
        } catch (SQLException e) {
            this.getFachadaServer().muestraExcepcion(e.getMessage());
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                this.getFachadaServer().muestraExcepcion(e.getMessage());
            }
        }
        
        return solicitudes;
    }
    
}
