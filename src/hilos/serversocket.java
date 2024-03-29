/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import escuchadores.ClientListener;
import eventos.EventConexion;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;

import java.net.ServerSocket;
import java.net.Socket;
//import socketservidor.Eventos.EventConeccion;
//import socketservidor.InformacionCliente;/
//import socketservidor.escuchadores.ClientListener;
import java.io.IOException;
import java.io.OutputStream;
import servidor.cliente;
import servidor.servidorsocket;
//import socketservidor.escuchadores.MensajeListener;

/**
 *
 
 */
public class serversocket extends Thread implements Runnable {

    int puerto;
    ServerSocket serverSocket;
   boolean sw = true;
    ClientListener clientListener;

    public serversocket(int puerto) {
        try {
            this.puerto = puerto;
            this.start();
            clientListener = null;

        } catch (Exception e) {

            System.out.println("No se pudo  Crear el servidor de forma Correcta");
        }
    }




    //-----RUNNABLE-----
    //Metodo sobreescrito de Runnable
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(puerto); //Creamos el socket servidor.
            System.out.println("Esperando conexiones...");
            while (sw) {
                Socket Sock = serverSocket.accept();

                System.out.println("aqui");
            
                System.out.println("Nuevo Cliente Conectado");

                clientesocket clientesock = new clientesocket(Sock);
                clientesock.addListenner(clientListener);

                clientListener.conectarCliente(new EventConexion(puerto ,new cliente(puerto, clientesock.getName(), clientesock)));

            }
        } catch (Exception ex) {
            System.out.println("Error de Coneccion="+ex);
        }
    }

    public void addListenner(servidorsocket aux) {
         try {
            clientListener = aux;
            
        } catch (Exception e) {
            System.out.println("No adiciono el escuchador de forma correcta");
        }

    }

}
