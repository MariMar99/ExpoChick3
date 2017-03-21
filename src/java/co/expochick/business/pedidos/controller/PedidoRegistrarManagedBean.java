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
import co.expochick.business.login.controller.LoginManagedBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

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
    
    //Listas Valor determinado
    @Inject
    private LoginManagedBean capturaLogin;
    @Inject 
    private EstadoPedidoListarController estadoPedido;
    
    
    public PedidoRegistrarManagedBean() {
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }


    public Detallepedido getDetPedido() {
        return detPedido;
    }

    public void setDetPedido(Detallepedido detPedido) {
        this.detPedido = detPedido;
    }

    public LoginManagedBean getCapturaLogin() {
        return capturaLogin;
    }

    public void setCapturaLogin(LoginManagedBean capturaLogin) {
        this.capturaLogin = capturaLogin;
    }

    public EstadoPedidoListarController getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedidoListarController estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
    
    
    
    
    
    @PostConstruct
    public void init(){
        pedido = new Pedido();
        detPedido = new Detallepedido();
    }
    
    
    //Registrar pedidopor el Cliente
    
    public void registrarPedido(){
        try {
            //pedido.setIdCliente(getCapturaLogin().);
            pedido.setIdEstadoPedido(getEstadoPedido().getObject(1));
            pedfc.create(pedido);
            
            detPedido.setIdPedido(pedido);
            
            detPedidofc.create(detPedido);
            
        } catch (Exception e) {
            System.out.println("ERROR - REGISTRAR PEDIDO ! "+e);
        }
    }
    
}
