/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Preciocantidade;
import co.expochick.backend.persistence.entity.facade.PreciocantidadeFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Familia Toro
 */
@Named(value = "precioCantidadListarController")
@SessionScoped
@RequestScoped
public class PrecioCantidadListarController implements Serializable {

    private Preciocantidade cantidad;
    @EJB
    private PreciocantidadeFacade pfca;

    public Preciocantidade getCantidad() {
        return cantidad;
    }

    public void setCantidad(Preciocantidade cantidad) {
        this.cantidad = cantidad;
    }

    public PreciocantidadeFacade getPfca() {
        return pfca;
    }

    public void setPfca(PreciocantidadeFacade pfca) {
        this.pfca = pfca;
    }
    
    public void init(){
        cantidad = new Preciocantidade();
    }
     ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
    public List<Preciocantidade> getPas() {
        try {
            return this.pfca.findAll();
        } catch (Exception e) {
            manejarError(e);
        }
        return null;
    }

    public void eliminarDetalle(Preciocantidade pre) {
        try {
            pfca.remove(pre);
            manejarExito("eliminado");
        } catch (Exception e) {
            manejarError(e);
        }
    }
    
    public List<Preciocantidade> listarPrecioCantidad() {
        return pfca.findAll();
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

    public PrecioCantidadListarController() {
    }
    
}
