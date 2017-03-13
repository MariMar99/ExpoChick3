/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Presentacion;
import co.expochick.backend.persistence.entity.facade.PresentacionFacade;
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
@Named(value = "presentacionListarController")
@SessionScoped
@RequestScoped
public class PresentacionListarController implements Serializable {

    private Presentacion pre;
    @EJB
    private PresentacionFacade pfca;

    public Presentacion getPre() {
        return pre;
    }

    public void setPre(Presentacion pre) {
        this.pre = pre;
    }

    public PresentacionFacade getPfca() {
        return pfca;
    }

    public void setPfca(PresentacionFacade pfca) {
        this.pfca = pfca;
    }
    
    public void init(){
        pre = new Presentacion();
    }
    
     ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
    public List<Presentacion> getPresen() {
        try {
            return this.pfca.findAll();
        } catch (Exception e) {
            manejarError(e);
        }
        return null;
    }

    public void eliminarDetalle(Presentacion pres) {
        try {
            pfca.remove(pres);
            manejarExito("eliminado");
        } catch (Exception e) {
            manejarError(e);
        }
    }
    
    public List<Presentacion> listarPresentacion() {
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
    
    public PresentacionListarController() {
    }
    
}
