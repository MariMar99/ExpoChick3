/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Detallepedido;
import co.expochick.backend.persistence.entity.facade.DetallepedidoFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "detallePedidoModificarManagedBean")
@RequestScoped
public class DetallePedidoModificarManagedBean implements Serializable {

    @EJB private DetallepedidoFacade dtpfc;
    private Detallepedido detPedido;
    
    public DetallePedidoModificarManagedBean() {
    }

    public Detallepedido getDetPedido() {
        return detPedido;
    }

    public void setDetPedido(Detallepedido detPedido) {
        this.detPedido = detPedido;
    }
    
    @PostConstruct
    public void init(){
        detPedido = new Detallepedido();
    }
    
    public void modificarDetallePedido(){
        try {
            dtpfc.edit(detPedido);
        } catch (Exception e) {
            System.out.println("ERROR -MODIFICAR DETALLE PEDIDO ! "+e);
        }
    }
    
}
