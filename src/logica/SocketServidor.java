
package logica;

import java.io.IOException;
import sockets.Servidor;

public class SocketServidor {

    public static void main(String[] args) throws IOException {
        
        //creo una instancia del servidor
        Servidor servidor = new Servidor();
        
        System.out.println("Iniciando el servidor...");
        
        //inicio el servidor
        servidor.iniciar();
        
    }
    
}
