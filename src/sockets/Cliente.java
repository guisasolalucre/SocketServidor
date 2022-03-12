
package sockets;

import java.io.DataOutputStream;
import java.io.IOException;

public class Cliente extends ConexionSockets {

    //implementa el constructor de la clase madre
    //indicando que es de tipo "cliente"
    public Cliente() throws IOException {
        super("cliente");
    }
    
    //metodo para inicializar el cliente
    public void iniciar(){
        try {
            //flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(socketCliente.getOutputStream());
            
            //envío 3 mensajes de prueba
            for (int i = 0; i < 3; i++) {
                //se escribe en el servidor usando su flujo de datos
                salidaServidor.writeUTF("Este es el mensaje número " + (i+1) + "\n");
            }
            
            //finaliza la conexion
            socketCliente.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
