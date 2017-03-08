/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.antinarcoticos.controller;

import co.expochick.backend.persistence.entity.Estadoantinarcotico;
import co.expochick.backend.persistence.entity.facade.EstadoantinarcoticoFacade;
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
@Named(value = "estadoAntinarcoticoListarController")
@SessionScoped
public class EstadoAntinarcoticoListarController implements Serializable {

    private Estadoantinarcotico estadoan;
    @EJB
    private EstadoantinarcoticoFacade estadofacadeanti;

    public Estadoantinarcotico getEstadoan() {
        return estadoan;
    }

    public void setEstadoan(Estadoantinarcotico estadoan) {
        this.estadoan = estadoan;
    }

    public EstadoantinarcoticoFacade getEstadofacadeanti() {
        return estadofacadeanti;
    }

    public void setEstadofacadeanti(EstadoantinarcoticoFacade estadofacadeanti) {
        this.estadofacadeanti = estadofacadeanti;
    }
    
    public void init(){
        estadoan = new Estadoantinarcotico();
    }
    
    ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
    public List<Estadoantinarcotico> getEstadoAntinarcotico() {
        try {
            return this.estadofacadeanti.findAll();
        } catch (Exception e) {
            manejarError(e);
        }
        return null;
    }

    public void eliminarEstadoAnti(Estadoantinarcotico estadoanti) {
        try {
            estadofacadeanti.remove(estadoanti);
            manejarExito("eliminado");
        } catch (Exception e) {
            manejarError(e);
        }
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

    
    public EstadoAntinarcoticoListarController() {
    }
    
}
