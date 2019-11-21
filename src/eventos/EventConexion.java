/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos;

import java.util.EventObject;
import socketservidor.InformacionCliente;

/**
 *
 * @author Brayan
 */
public class EventConexion extends EventObject{

     private InformacionCliente cliente;
    
    public EventConexion(Object source, InformacionCliente cliente) {
        super(source);
        this.cliente=cliente;
    }

    public InformacionCliente getCliente() {
        return cliente;
    }

    public void setCliente(InformacionCliente cliente) {
        this.cliente = cliente;
    }
    
}
