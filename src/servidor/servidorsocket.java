/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import escuchadores.ClientListener;
import eventos.EventConexion;
import hilos.serversocket;
import java.util.LinkedList;

/**
 *
 * @author laioner
 */
public class servidorsocket implements ClientListener {
    LinkedList<cliente> listaclientes;
    private int puerto;
    private serversocket ssock;

    public servidorsocket(LinkedList<cliente> listaclientes, int puerto) {
        this.listaclientes = listaclientes;
        this.puerto = puerto;
        this.ssock = null;
    }

    @Override
    public void conectarCliente(EventConexion coneccion) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        listaclientes.add(coneccion.getCliente());
    }
    
    public void init() {

        try {

            if (ssock == null) {
                ssock = new serversocket(this.puerto);
                ssock.addListenner(this);

                System.out.println("ServerSocket iniciado Correctamente");

            } else {

                System.out.println("ServerSocket ya iniciado");
            }

            // logger.log(Level.INFO,"ServerSocket run...");
        } catch (Exception e) {

            //logger.log(Level.WARNING,"No se pudo iniciar el servidor de forma correcta");
            System.out.println("No se pudo crear el servidor");

        }

    }
}
