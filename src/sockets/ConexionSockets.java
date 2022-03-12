
package sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConexionSockets {

    private final int puerto = 8080; //puerto para conectar
    private final String host = "localhost"; //direccion ip para la conexion
    protected String mensajeServidor; //variable para mensajes recibidos en el servidor
    protected ServerSocket socketServidor; //socket del servidor
    protected Socket socketCliente; //socket del cliente
    protected DataOutputStream salidaServidor, salidaCliente; //variables de salida
    
    public ConexionSockets() {
    }

    public ConexionSockets(String tipo) throws IOException {
        if (tipo.equalsIgnoreCase("servidor")){
            //creo el socket para el servidor
            socketServidor = new ServerSocket(puerto);
            //creo el socket para el cliente
            socketCliente = new Socket();
        } else {
            //creo el socket para el cliente
            socketCliente = new Socket(host, puerto);
        }
    }

}
