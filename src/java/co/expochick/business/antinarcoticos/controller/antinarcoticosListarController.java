package co.expochick.business.antinarcoticos.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import co.expochick.backend.persistence.entity.Antinarcotico;
import co.expochick.backend.persistence.entity.facade.AntinarcoticoFacade;
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
@Named(value = "antinarcoticosListarController")
@SessionScoped
@RequestScoped
public class antinarcoticosListarController implements Serializable {

     private Antinarcotico anti;

    @EJB
    private AntinarcoticoFacade af;

    public Antinarcotico getAnti() {
        return anti;
    }

    public void setAnti(Antinarcotico anti) {
        this.anti = anti;
    }

    public AntinarcoticoFacade getAf() {
        return af;
    }

    public void setAf(AntinarcoticoFacade af) {
        this.af = af;
    }
    
    public void init(){
        anti = new Antinarcotico();
    }

    
    ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
    public List<Antinarcotico> getAntinarcoticos() {
        try {
            return this.af.findAll();
        } catch (Exception e) {
            manejarError(e);
        }
        return null;
    }

    public void eliminarDetalle(Antinarcotico ant) {
        try {
            af.remove(ant);
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


    public antinarcoticosListarController() {
    }
    
}
