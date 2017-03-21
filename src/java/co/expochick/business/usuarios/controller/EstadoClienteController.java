/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.usuarios.controller;

import co.expochick.backend.persistence.entity.Estadocliente;
import co.expochick.backend.persistence.entity.facade.EstadoclienteFacade;
import co.expochick.frontend.converter.util.Managedbean;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
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
@Named(value = "estadoClienteController")
//@SessionScoped
@RequestScoped
public class EstadoClienteController implements Serializable, Managedbean<Estadocliente> {

    private Estadocliente estadocli;
    @EJB
    private EstadoclienteFacade estadofc;

    public Estadocliente getEstadocli() {
        return estadocli;
    }

    public void setEstadocli(Estadocliente estadocli) {
        this.estadocli = estadocli;
    }

    public EstadoclienteFacade getFacade() {
        return estadofc;
    }

    public void setFacade(EstadoclienteFacade estadofc) {
        this.estadofc = estadofc;
    }
    
    public void init(){
        estadocli = new Estadocliente();
    }
    
    ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
//    public List<Estadocliente> getCliente() {
//        try {
//            return this.estadofc.findAll();
//        } catch (Exception e) {
//            manejarError(e);
//        }
//        return null;
//    }

    public void eliminarDetalle(Estadocliente estcli) {
        try {
            estadofc.remove(estcli);
            manejarExito("eliminado");
        } catch (Exception e) {
            manejarError(e);
        }
    }
    
    public List<Estadocliente> listarEstadosClientes(){
        return estadofc.findAll();
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
    
    public EstadoClienteController() {
    }

    @Override
    public Estadocliente getObject(Integer i) {
        return estadofc.find(i);
    }
    
}
