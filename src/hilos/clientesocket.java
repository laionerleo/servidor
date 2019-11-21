/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import escuchadores.ClientListener;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laioner
 */
public class clientesocket extends Thread implements Runnable  {
    Socket cliente;
     String ip;
    String puertoServidor;
    boolean clientConect = true;
    ClientListener clientListener;
    

    public clientesocket(Socket cliente) {
        this.cliente = cliente;
          this.ip = cliente.getInetAddress().getHostAddress();
        this.puertoServidor = String.valueOf(cliente.getLocalPort());
        this.start();
    }
    
    
     public void addListenner(ClientListener aux) {
        try {
            clientListener = aux;
        } catch (Exception e) {
            System.out.println("No adiciono el escuchador de forma correcta");
        }

    }
    
    
       @Override
    public void run() {
        try {
            if (cliente != null) {
                String mensajeRecibido;
                System.out.println("Se ha conectado: " + cliente.getInetAddress().getHostName());
                InputStream inputStream = cliente.getInputStream();
                DataInputStream entrada = new DataInputStream(inputStream);
               // entrada=new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                while (clientConect) {
                    //mensajeRecibido = entrada.readLine();//Leemos
                    mensajeRecibido = entrada.readUTF();//Leemos
                    if (mensajeRecibido.length() > 0) {
                            System.out.println("mensaje:"+mensajeRecibido);
                    }

                }
            } else {
                System.out.println("se a retirado");
            }

        } catch (Exception ex) {
            //log("Lost a connection. \n");
            System.out.println("lost a conexion  \n");
            this.stop();
            //Logger.getLogger(ServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
