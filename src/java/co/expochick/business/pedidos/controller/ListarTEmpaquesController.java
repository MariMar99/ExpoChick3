/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Tipoempaque;
import co.expochick.backend.persistence.entity.facade.TipoempaqueFacade;
import co.expochick.frontend.converter.util.Managedbean;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Familia Toro
 */
@Named(value = "listarTEmpaquesController")
//@SessionScoped
@RequestScoped
public class ListarTEmpaquesController implements Serializable, Managedbean<Tipoempaque> {

    private Tipoempaque empaque;
    @EJB
    private TipoempaqueFacade empaquefc;

    public Tipoempaque getEmpque() {
        return empaque;
    }

    public void setEmpque(Tipoempaque empaque) {
        this.empaque = empaque;
    }

    public TipoempaqueFacade getFacadeempaue() {
        return empaquefc;
    }

    public void setFacadeempaue(TipoempaqueFacade empaquefc) {
        this.empaquefc = empaquefc;
    }
    
    public void init(){
        empaque = new Tipoempaque();
    }
    
     ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
//    public List<Tipoempaque> getEmpaque() {
//        try {
//            return this.empaquefc.findAll();
//        } catch (Exception e) {
//            manejarError(e);
//        }
//        return null;
//    }

    public void eliminarCiudad(Tipoempaque emp) {
        try {
            empaquefc.remove(emp);
            manejarExito("eliminado");
        } catch (Exception e) {
            manejarError(e);
        }
    }
    
    public List<Tipoempaque> listarTipoEmpaques(){
        return empaquefc.findAll();
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

    @Override
    public Tipoempaque getObject(Integer i) {
        return empaquefc.find(i);
    }
    
}
