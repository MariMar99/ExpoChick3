/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Producto;
import co.expochick.backend.persistence.entity.facade.ProductoFacade;
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
@Named(value = "productoRegistrarManagedBean")
@RequestScoped
public class ProductoRegistrarManagedBean implements Serializable, Managedbean<Producto>{

    private Producto producto;
    @EJB 
    private ProductoFacade profc;
    
    public ProductoRegistrarManagedBean() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    @PostConstruct
    public void init() {
        producto = new Producto();
    }

    public void registrarProducto() {
        try {
            profc.create(producto);
        } catch (Exception e) {
            System.out.println("ERROR - REGISTRAR PRODUCTO ! "+e);
        }
    }

    @Override
    public Producto getObject(Integer i) {
        return profc.find(i);
    }
}
