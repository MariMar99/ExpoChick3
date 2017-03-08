/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.antinarcoticos.controller;

import co.expochick.backend.persistence.entity.Tipotransporte;
import co.expochick.backend.persistence.entity.facade.TipotransporteFacade;
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
@Named(value = "tipotransporteListarController")
@SessionScoped
public class TipotransporteListarController implements Serializable {

    private Tipotransporte trans;
    @EJB
    private TipotransporteFacade facadet;

    public Tipotransporte getTrans() {
        return trans;
    }

    public void setTrans(Tipotransporte trans) {
        this.trans = trans;
    }

    public TipotransporteFacade getFacadet() {
        return facadet;
    }

    public void setFacadet(TipotransporteFacade facadet) {
        this.facadet = facadet;
    }
    
    
    public void init(){
        trans = new Tipotransporte();
                 
    }
    
    ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
   public List<Tipotransporte> getTipoTransporte() {
        try {
            return this.facadet.findAll();
        } catch (Exception e) {
            manejarError(e);
        }
        return null;
    }

    public void eliminarDetalle(Tipotransporte pt) {
        try {
            facadet.remove(pt);
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
    
    public TipotransporteListarController() {
    }
    
}
