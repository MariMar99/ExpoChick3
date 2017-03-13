/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Estadoproducto;
import co.expochick.backend.persistence.entity.facade.EstadoproductoFacade;
import co.expochick.frontend.converter.util.Managedbean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Familia Toro
 */
@Named(value = "estadoProductoController")
@SessionScoped
public class EstadoProductoController implements Serializable, Managedbean<Estadoproducto> {

    private Estadoproducto producto;
    
    @EJB
    private EstadoproductoFacade productofacade;

    public Estadoproducto getProducto() {
        return producto;
    }

    public void setProducto(Estadoproducto producto) {
        this.producto = producto;
    }

    public EstadoproductoFacade getProductofacade() {
        return productofacade;
    }

    public void setProductofacade(EstadoproductoFacade productofacade) {
        this.productofacade = productofacade;
    }
    
    @PostConstruct
    public void init(){
         producto = new Estadoproducto();
    }
    
    
     ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
        public List<Estadoproducto> getEstadoPro() {

        return this.productofacade.findAll();

    }
     
    public List<Estadoproducto> listarEstadoProducto() {
        return productofacade.findAll();

    }

  
    
    
      //******************************************************************************************
    public EstadoProductoController() {
    }

    @Override
    public Estadoproducto getObject(Integer i) {
        return productofacade.find(i);
    }
    
}
