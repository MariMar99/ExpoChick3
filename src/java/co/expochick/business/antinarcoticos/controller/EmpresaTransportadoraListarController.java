/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.antinarcoticos.controller;

import co.expochick.backend.persistence.entity.Empresatransporte;
import co.expochick.backend.persistence.entity.facade.EmpresatransporteFacade;
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
@Named(value = "empresaTransportadoraListarController")
@SessionScoped
public class EmpresaTransportadoraListarController implements Serializable {

    private Empresatransporte transporte;
    @EJB
    private EmpresatransporteFacade trasnfacade;

    public Empresatransporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Empresatransporte transporte) {
        this.transporte = transporte;
    }

    public EmpresatransporteFacade getTrasnfacade() {
        return trasnfacade;
    }

    public void setTrasnfacade(EmpresatransporteFacade trasnfacade) {
        this.trasnfacade = trasnfacade;
    }
    
    public void init(){
        transporte = new Empresatransporte();
    }
    
     ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
    public List<Empresatransporte> getEmpresa() {
        try {
            return this.trasnfacade.findAll();
        } catch (Exception e) {
            manejarError(e);
        }
        return null;
    }

    public void eliminarEstadoAnti(Empresatransporte empresatransporte) {
        try {
            trasnfacade.remove(empresatransporte);
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

    
    
    
    
    public EmpresaTransportadoraListarController() {
    }
    
}
