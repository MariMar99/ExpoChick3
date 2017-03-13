/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Detallepedido;
import co.expochick.backend.persistence.entity.facade.DetallepedidoFacade;
import co.expochick.frontend.converter.util.Managedbean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Alexandra
 */
@Named(value = "detallePedidoRegistrarManagedBean")
@RequestScoped
public class DetallePedidoRegistrarManagedBean implements Serializable, Managedbean<Detallepedido> {

    @EJB private DetallepedidoFacade dtpfc;
    private Detallepedido detPedido;
    
    public DetallePedidoRegistrarManagedBean() {
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
    
    public void registrarDetallePedido(){
        try {
            dtpfc.create(detPedido);
        } catch (Exception e) {
            System.out.println("ERROR - REGISTRAR DETALLE PEDIDO ! "+e);
        }
    }

    @Override
    public Detallepedido getObject(Integer i) {
        return dtpfc.find(i);
    }
    
}
