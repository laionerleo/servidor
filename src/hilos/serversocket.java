/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;

import java.net.ServerSocket;
import java.net.Socket;
import socketservidor.Eventos.EventConeccion;
import socketservidor.InformacionCliente;
import socketservidor.escuchadores.ClientListener;
import java.io.IOException;
import java.io.OutputStream;
import socketservidor.escuchadores.MensajeListener;

/**
 *
 * @author Brayan
 */
public class serversocket extends Thread implements Runnable {

    int puerto;
    ServerSocket serverSocket;
    boolean encApagado = true;
    //ClientListener clientListener;
    ///MensajeListener mensajeListener;

    //-----CONSTRUCTOR----
    //Constructor del ServidorRun
    public serversocket(int puerto) {
        try {
            this.puerto = puerto;
            this.start();
            //clientListener = null;
        } catch (Exception e) {

            System.out.println("No se pudo  Crear el servidor de forma Correcta");
        }
    }

    //------METODOS-------
    //Mata el hilo de forma correcta
    public void matarHilo() {

        try {

            serverSocket.close();
            //System.out.println("Cargando...");
            sleep(1000);
            join();
            System.out.println("Se mato el hilo");

        } catch (InterruptedException ex) {

            System.out.println("No se pudo matar el hilo de forma correcta interrumpt");

        } catch (Exception e) {

            System.out.println("No se pudo matar el hilo de forma correcta");
        }

    }

    //En este metodo se aficiona el escuchador de la clase ServerSocket
    public void addListenner(ClientListener aux, MensajeListener men) {
        try {
            //clientListener = aux;
            //mensajeListener = men;
        } catch (Exception e) {
            System.out.println("No adiciono el escuchador de forma correcta");
        }

    }

    //-----RUNNABLE-----
    //Metodo sobreescrito de Runnable
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(puerto); //Creamos el socket servidor.
            System.out.println("Esperando conexiones...");
            while (encApagado) {
                Socket clientSock = serverSocket.accept();

                System.out.println("aqui");
                //DataInputStream entrada = new DataInputStream(clientSock.getInputStream());
                //System.out.println(entrada);
                // mensajeRecibido = entrada.readUTF();//Leemos respuesta
                // System.out.println(mensajeRecibido);
                System.out.println("Nuevo Cliente Conectado");

                //Thread hilo = new Thread(new NuevoCliente(clientSock));
                //Aqui hacer el evento
                //Evento de conectar
                //NuevoCliente nuevoCliente = new NuevoCliente(clientSock);

                //nuevoCliente.addListenner(clientListener, mensajeListener);
                //Zacary ahsCode nul
                //clientListener.conectarCliente(new EventConeccion(puerto, new InformacionCliente(puerto, String.valueOf(nuevoCliente.hashCode()), nuevoCliente)));

            }
        } catch (Exception ex) {
            System.out.println("Error de Coneccion");
        }
    }

}
