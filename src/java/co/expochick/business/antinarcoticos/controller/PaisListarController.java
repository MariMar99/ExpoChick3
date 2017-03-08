/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.antinarcoticos.controller;

import co.expochick.backend.persistence.entity.Pais;
import co.expochick.backend.persistence.entity.facade.PaisFacade;
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
@Named(value = "paisListarController")
@SessionScoped
public class PaisListarController implements Serializable {

  private Pais pais;
  @EJB
  private PaisFacade paisfaca;

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public PaisFacade getPaisfaca() {
        return paisfaca;
    }

    public void setPaisfaca(PaisFacade paisfaca) {
        this.paisfaca = paisfaca;
    }
  
  public void init(){
      pais = new Pais();
  }
  
   ///////////////////////////////////// CRUD ////////////////////////////////////////////////////////////////////////
    
    
    
   public List<Pais> getPaises() {
        try {
            return this.paisfaca.findAll();
        } catch (Exception e) {
            manejarError(e);
        }
        return null;
    }

    public void eliminarDetalle(Pais ps) {
        try {
            paisfaca.remove(ps);
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
  
  
    public PaisListarController() {
    }
    
}
