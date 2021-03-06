/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Estadopedido;
import co.expochick.backend.persistence.entity.facade.EstadopedidoFacade;
import co.expochick.frontend.converter.util.Managedbean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Familia Toro
 */
@Named(value = "estadoPedidoListarController")
@SessionScoped
@RequestScoped
public class EstadoPedidoListarController implements Serializable, Managedbean<Estadopedido> {

    private Estadopedido estado;
    @EJB
    private EstadopedidoFacade estadoPedfc;
    //private EstadopedidoFacade ef;
    
    
      @PostConstruct
    public void init() {
        estado = new Estadopedido();
    }
    
    
    ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
//    public List<Estadopedido> getEstadoP() {
//        try {
//            return this.estadoPedfc.findAll();
//        } catch (Exception e) {
//            manejarError(e);
//        }
//        return null;
//    }

    public void eliminarEstadoP(Estadopedido es) {
        try {
            estadoPedfc.remove(es);
            manejarExito("eliminado");
        } catch (Exception e) {
            manejarError(e);
        }
    }
    
    public List<Estadopedido> listarEstadoPedidos(){
        return estadoPedfc.findAll();
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

    
    public EstadoPedidoListarController() {
    }

    @Override
    public Estadopedido getObject(Integer i) {
        return estadoPedfc.find(i);
    }
    
}
