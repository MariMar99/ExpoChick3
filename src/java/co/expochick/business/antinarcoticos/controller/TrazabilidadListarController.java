/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.antinarcoticos.controller;

import co.expochick.backend.persistence.entity.Trazabilidad;
import co.expochick.backend.persistence.entity.facade.TrazabilidadFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Familia Toro
 */
@Named(value = "trazabilidadListarController")
@SessionScoped
public class TrazabilidadListarController implements Serializable {

    private Trazabilidad taraza;
    @EJB
    private TrazabilidadFacade trafacade;

    public Trazabilidad getTaraza() {
        return taraza;
    }

    public void setTaraza(Trazabilidad taraza) {
        this.taraza = taraza;
    }

    public TrazabilidadFacade getTrafacade() {
        return trafacade;
    }

    public void setTrafacade(TrazabilidadFacade trafacade) {
        this.trafacade = trafacade;
    }
    
    @PostConstruct
    public void init(){
        taraza = new Trazabilidad();
    }
    
     ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
    public List<Trazabilidad> getTrazabili() {
        try {
            return this.trafacade.findAll();
        } catch (Exception e) {
            manejarError(e);
        }
        return null;
    }

    public void eliminarTraza(Trazabilidad aemp) {
        try {
            trafacade.remove(aemp);
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
    
    public TrazabilidadListarController() {
    }
    
}
