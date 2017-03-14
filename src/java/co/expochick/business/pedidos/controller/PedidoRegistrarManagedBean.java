/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Detallepedido;
import co.expochick.backend.persistence.entity.Pedido;
import co.expochick.backend.persistence.entity.facade.DetallepedidoFacade;
import co.expochick.backend.persistence.entity.facade.PedidoFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Alexandra
 */
@Named(value = "pedidoRegistrarManagedBean")
@RequestScoped
public class PedidoRegistrarManagedBean implements Serializable {

    private Pedido pedido;
    private Detallepedido detPedido;
    
    @EJB 
    private PedidoFacade pedfc;
    @EJB
    private DetallepedidoFacade detPedidofc;
    
    public PedidoRegistrarManagedBean() {
    }

    public PedidoFacade getPedfc() {
        return pedfc;
    }

    public void setPedfc(PedidoFacade pedfc) {
        this.pedfc = pedfc;
    } 

    public Detallepedido getDetPedido() {
        return detPedido;
    }

    public void setDetPedido(Detallepedido detPedido) {
        this.detPedido = detPedido;
    }
    
    
    @PostConstruct
    public void init(){
        pedido = new Pedido();
        detPedido = new Detallepedido();
    }
    
    public void registrarPedido(){
        try {
            pedfc.create(pedido);
            
            detPedido.setIdPedido(pedido);
            detPedidofc.create(detPedido);
            
        } catch (Exception e) {
            System.out.println("ERROR - REGISTRAR PEDIDO ! "+e);
        }
    }
    
}
