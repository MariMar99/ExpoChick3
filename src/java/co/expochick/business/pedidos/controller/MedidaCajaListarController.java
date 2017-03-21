/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Medidacaja;
import co.expochick.backend.persistence.entity.facade.MedidacajaFacade;
import co.expochick.frontend.converter.util.Managedbean;
import javax.inject.Named;


//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Familia Toro
 */
@Named(value = "medidaCajaListarController")
//@SessionScoped
@RequestScoped
public class MedidaCajaListarController implements Serializable, Managedbean<Medidacaja> {

    private Medidacaja caja;
    
    @EJB
    private MedidacajaFacade mf;

    public Medidacaja getCaja() {
        return caja;
    }

    public void setCaja(Medidacaja caja) {
        this.caja = caja;
    }

    public MedidacajaFacade getMf() {
        return mf;
    }

    public void setMf(MedidacajaFacade mf) {
        this.mf = mf;
    }
    
    
    @PostConstruct
    public void init(){
        caja = new Medidacaja();
    }
    
     ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
    public List<Medidacaja> listarMedidasCajas(){
        return mf.findAll();
    }
//    public List<Medidacaja> getPasa() {
//        try {
//            return this.mf.findAll();
//        } catch (Exception e) {
//            manejarError(e);
//        }
//        return null;
//    }

    public void eliminarDetalle(Medidacaja pa) {
        try {
            mf.remove(pa);
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


    public MedidaCajaListarController() {
    }

    @Override
    public Medidacaja getObject(Integer i) {
        return mf.find(i);
    }
    
}
