/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Pedido;
import co.expochick.backend.persistence.entity.facade.PedidoFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "pedidoRegistrarManagedBean")
@RequestScoped
public class PedidoRegistrarManagedBean implements Serializable {

    @EJB private PedidoFacade pedfc;
    private Pedido pedido;
    
    public PedidoRegistrarManagedBean() {
    }

    public PedidoFacade getPedfc() {
        return pedfc;
    }

    public void setPedfc(PedidoFacade pedfc) {
        this.pedfc = pedfc;
    }    
    
    @PostConstruct
    public void init(){
        pedido = new Pedido();
    }
    
    public void registrarPedido(){
        try {
            pedfc.create(pedido);
        } catch (Exception e) {
            System.out.println("ERROR - REGISTRAR PEDIDO ! "+e);
        }
    }
    
}
