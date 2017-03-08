/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.antinarcoticos.controller;

import co.expochick.backend.persistence.entity.Continente;
import co.expochick.backend.persistence.entity.facade.ContinenteFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Familia Toro
 */
@Named(value = "continentesListarController")
@SessionScoped
public class ContinentesListarController implements Serializable {

    private Continente conti;
    @EJB
    private ContinenteFacade contifacade;

    public Continente getConti() {
        return conti;
    }

    public void setConti(Continente conti) {
        this.conti = conti;
    }

    public ContinenteFacade getContifacade() {
        return contifacade;
    }

    public void setContifacade(ContinenteFacade contifacade) {
        this.contifacade = contifacade;
    }
    
    public void init(){
        conti = new Continente();      
    }
    
    ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
    public List<Continente> getContinente() {
        try {
            return this.contifacade.findAll();
        } catch (Exception e) {
            manejarError(e);
        }
        return null;
    }

    public void eliminarEstadoContinente(Continente nente) {
        try {
            contifacade.remove(nente);
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
    
    public ContinentesListarController() {
    }
    
}
