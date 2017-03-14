/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.antinarcoticos.controller;

import co.expochick.backend.persistence.entity.Ciudad;
import co.expochick.backend.persistence.entity.facade.CiudadFacade;
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
@Named(value = "ciudadListarController")
@SessionScoped
public class CiudadListarController implements Serializable {

    private Ciudad ciu;
    @EJB
    private CiudadFacade facadeciudad;

    public Ciudad getCiu() {
        return ciu;
    }

    public void setCiu(Ciudad ciu) {
        this.ciu = ciu;
    }

    public CiudadFacade getFacadeciudad() {
        return facadeciudad;
    }

    public void setFacadeciudad(CiudadFacade facadeciudad) {
        this.facadeciudad = facadeciudad;
    }
    
    public void init(){
        ciu = new Ciudad();
    }
    
    ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
    public List<Ciudad> getCiudad() {
        try {
            return this.facadeciudad.findAll();
        } catch (Exception e) {
            manejarError(e);
        }
        return null;
    }

    public void eliminarCiudad(Ciudad dad) {
        try {
            facadeciudad.remove(dad);
            manejarExito("eliminado");
        } catch (Exception e) {
            manejarError(e);
        }
    }
    
    public List<Ciudad> listarCiudades(){
        return facadeciudad.findAll();
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
    public CiudadListarController() {
    }
    
}
