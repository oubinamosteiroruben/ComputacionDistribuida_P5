
package Cliente;

import Chat_P2P.FachadaAplicacion;

public class FachadaCliente {
    
    private final Cliente cliente;
    private final FachadaAplicacion fa;
    
    public FachadaCliente(FachadaAplicacion fa){
        this.fa = fa;
        this.cliente = new Cliente(fa);
    }
    
    public Boolean iniciarSesion(String username, String password) throws Exception{
        return this.cliente.iniciarSesion(username,password);
    }
    
    public Boolean registrarUsuario(String username, String password) throws Exception{
        return this.cliente.registrarUsuario(username,password);
    }
    
}
