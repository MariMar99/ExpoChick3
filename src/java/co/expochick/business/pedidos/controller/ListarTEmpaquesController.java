/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Tipoempaque;
import co.expochick.backend.persistence.entity.facade.TipoempaqueFacade;
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
@Named(value = "listarTEmpaquesController")
@SessionScoped
public class ListarTEmpaquesController implements Serializable {

    private Tipoempaque empque;
    @EJB
    private TipoempaqueFacade facadeempaue;

    public Tipoempaque getEmpque() {
        return empque;
    }

    public void setEmpque(Tipoempaque empque) {
        this.empque = empque;
    }

    public TipoempaqueFacade getFacadeempaue() {
        return facadeempaue;
    }

    public void setFacadeempaue(TipoempaqueFacade facadeempaue) {
        this.facadeempaue = facadeempaue;
    }
    
    public void init(){
        empque = new Tipoempaque();
    }
    
     ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
    public List<Tipoempaque> getEmpaque() {
        try {
            return this.facadeempaue.findAll();
        } catch (Exception e) {
            manejarError(e);
        }
        return null;
    }

    public void eliminarCiudad(Tipoempaque emp) {
        try {
            facadeempaue.remove(emp);
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
    
    public ListarTEmpaquesController() {
    }
    
}
