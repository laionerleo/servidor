/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos;

import java.util.EventObject;
import servidor.cliente;

/**
 *
 * @author Brayan
 */
public class EventConexion extends EventObject{

     private cliente cliente;
    
    public EventConexion(Object source, cliente cliente) {
        super(source);
        this.cliente=cliente;
    }

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cl) {
        this.cliente = cl;
    }
    
}
