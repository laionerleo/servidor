/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuchadores;

import java.util.EventListener;
import eventos.EventConexion;  //.Eventos.EventConeccion;
//import socketservidor.Eventos.EventMensajeObject;
//import socketservidor.Mensaje;

/**
 *
 * @author Brayan
 */
public interface ClientListener extends EventListener{
    
     void conectarCliente(EventConexion coneccion);
  
}
