
package sockets;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Servidor extends ConexionSockets{

    //implementa el constructor de la clase madre
    //indicando que es de tipo "servidor"
    public Servidor() throws IOException {
        super("servidor");
    }
    
    //metodo para inicializar el servidor
    public void iniciar(){
        try {
            //accept inicializa el socket
            //queda a la espera de solicitudes
            System.out.println("Esperando conexión...");
            socketCliente = socketServidor.accept();
            
            //se obtiene el flujo se salida del cliente
            System.out.println("Cliente en línea");
            salidaCliente = new DataOutputStream(socketCliente.getOutputStream());
            
            //se envia un mensaje al cliente
            System.out.println("Petición recibida y aceptada");
            
            //se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            
            //mientras haya mensajes del cliente...
            while ((mensajeServidor = entrada.readLine()) != null){
                //se muestran los mensajes recibidos
                System.out.println(mensajeServidor);
            }
            
            //cuando se terminan de leer los mensajes
            //finaliza la conexion con close
            System.out.println("Fin de la conexión.");
            socketServidor.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
