/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Producto;
import co.expochick.backend.persistence.entity.facade.ProductoFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "productoModificarManagedBean")
@RequestScoped
public class ProductoModificarManagedBean implements Serializable {

    @EJB private ProductoFacade profc;
    private Producto producto;
    
    public ProductoModificarManagedBean() {
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

    public void modificar() {
         try {
             System.out.println(producto);
          profc.edit(producto);
        } catch (Exception e) {
             System.out.println("ERROR - MODIFICAR PRODUCTO ! "+e);
        }        
    }
}
