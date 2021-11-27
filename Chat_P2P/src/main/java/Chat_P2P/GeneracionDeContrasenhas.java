package Chat_P2P;

import java.security.SecureRandom;
import java.security.spec.KeySpec;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class GeneracionDeContrasenhas {

    public static final String PBKDF2 = "PBKDF2WithHmacSHA1";
    public static final String SYMMETRIC_ALGORITHM = "AES";
    public static final String ENCODING_MSG = "UTF-8";
    public static final int numeroDeIteraciones = 655536;
    /**
     * numeroDeBitsClaveGenerada
     *      256 y 192 bits nos da como resultado "Illegal key size or default parameters". 
     *      Para poder utilizar mas bits en la clave tenemos que instalar "Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files" 
     * */
    public static final int numeroDeBitsClaveGenerada = 128; 
    public static final int numeroDeBitsSalt = 256;

    public byte[] generarSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] bytes = new byte[numeroDeBitsSalt/8]; /* 256 bits = 32 bytes */
        sr.nextBytes(bytes);
        return bytes;
    }

    public byte[] generarContrasenha(String password, byte[] salt) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(PBKDF2);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, numeroDeIteraciones, numeroDeBitsClaveGenerada);
        SecretKey derivedKey = factory.generateSecret(spec);
        SecretKey secret = new SecretKeySpec(derivedKey.getEncoded(), SYMMETRIC_ALGORITHM);
        return secret.getEncoded();
    }   

    public void funcionDePruebaParaLaGestionDeContrasenhas() throws Exception {
        // aqui tenemos la contraseña que queremos hashear
        String password = "loquemeinteresadelared";
        
        // creamos la clase donde tenemos todas las funciones necesarias
        GeneracionDeContrasenhas gc = new GeneracionDeContrasenhas();
        
        // para registrar un usuario nuevo
            // generamos la semilla
            byte[] salt = gc.generarSalt();
            // y obtenemos la contrasela
            String contrasenhaHasheada = Hex.encodeHexString(gc.generarContrasenha(password, salt));
            // convertimos la semilla a string para almacenarla en la base de datos
            String saltTexto = Hex.encodeHexString(salt);
            // TODO: ahora tendriamos que añadir en la base de datos al usuario(username, contrasenhaHasheada, saltTexto)
        
        // para iniciar sesion con un usuario existente
            // TODO: lo primero es buscar en la base de datos el usuario y obtener el salt (pongamos que es saltEjemplo)
            String saltEjemplo = "6c6798a6c075629685cc97835d45d52beea72902e06b75e6b2d81710686fbd36";
            // obtenemos la contraseña hasheada a partir de la informacion introducida en el login
            String result = Hex.encodeHexString(gc.generarContrasenha("aquiVaLaContrasenhaIntroducida", Hex.decodeHex(saltEjemplo.toCharArray())));
            // TODO: y ahora hacemos una consulta para comprobar si "result" coincide con la contraseña de la base de datos
            
    }

}