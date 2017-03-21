/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Producto;
import co.expochick.backend.persistence.entity.facade.ProductoFacade;
import co.expochick.frontend.converter.util.Managedbean;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Familia Toro
 */
@Named(value = "productoListarController")
//@SessionScoped
@RequestScoped
public class ProductoListarController implements Serializable, Managedbean<Producto> {

    private Producto producto;
    @EJB
    private ProductoFacade pfacade;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ProductoFacade getPfacade() {
        return pfacade;
    }

    public void setPfacade(ProductoFacade pfacade) {
        this.pfacade = pfacade;
    }
    
    public void init(){
        producto = new Producto();
    }
    
    ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
//    public List<Producto> getProduct() {
//        try {
//            return this.pfacade.findAll();
//        } catch (Exception e) {
//            manejarError(e);
//        }
//        return null;
//    }

    public void eliminarDetalle(Producto prod) {
        try {
            pfacade.remove(prod);
            manejarExito("eliminado");
        } catch (Exception e) {
            manejarError(e);
        }
    }
    
    public List<Producto> listarProductos(){
        return pfacade.findAll();
    }
    
    
      //******************************************************************************************


    private void
            manejarError(Exception e) {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se Produjo el Siguiente Error : ", e.getMessage()));

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Insertar :", e.getMessage());

        RequestContext.getCurrentInstance().showMessageInDialog(msg);
    }

    private void manejarExito(String operacion) {
        String msg = "Se ha Realizado Exitosamente la Operacion de " + operacion;

        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(msg));

        FacesMessage sal = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Opereción Exitosa : ", msg);
        RequestContext.getCurrentInstance().showMessageInDialog(sal);

    }
    public ProductoListarController() {
    }

    @Override
    public Producto getObject(Integer i) {
        return pfacade.find(i);
    }
    
}
