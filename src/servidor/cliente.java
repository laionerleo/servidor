/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.net.Socket;
import escuchadores.ClientListener;
import java.util.EventObject;
import hilos.clientesocket;

/**
 *
 * @author laioner
 */
public class cliente  extends EventObject{
    private String identificador;
    boolean clientConect = true;
    clientesocket clientsock;
    ClientListener clientListener;

    public cliente(Object source, String identificador, clientesocket nuevoCliente) {
        super(source);
        this.identificador=identificador;
        this.clientsock=nuevoCliente;
    }
    
}
