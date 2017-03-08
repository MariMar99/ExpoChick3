/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.antinarcoticos.controller;

import co.expochick.backend.persistence.entity.Cliente;
import co.expochick.backend.persistence.entity.facade.ClienteFacade;
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
@Named(value = "clientesListarController")
@SessionScoped
public class ClientesListarController implements Serializable {

    private Cliente cli;
    @EJB
    private ClienteFacade fac;

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public ClienteFacade getFac() {
        return fac;
    }

    public void setFac(ClienteFacade fac) {
        this.fac = fac;
    }
    
    public void init(){
        cli = new Cliente();
    }
    
     ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
    public List<Cliente> getClientes() {
        try {
            return this.fac.findAll();
        } catch (Exception e) {
            manejarError(e);
        }
        return null;
    }

    public void eliminarEstadoContinente(Cliente clinente) {
        try {
            fac.remove(clinente);
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
    
    public ClientesListarController() {
    }
    
}
