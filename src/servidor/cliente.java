/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.net.Socket;
import escuchadores.ClientListener;

/**
 *
 * @author laioner
 */
public class cliente {
    private String identificador;
    Socket cliente;
    String ip;
    String puertoServidor;
    boolean clientConect = true;
    //Lisener 
    ClientListener clientListener;
    
}
