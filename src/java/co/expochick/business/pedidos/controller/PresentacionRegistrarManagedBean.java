/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Presentacion;
import co.expochick.backend.persistence.entity.facade.PresentacionFacade;
import co.expochick.frontend.converter.util.Managedbean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "presentacionRegistrarManagedBean")
@RequestScoped
public class PresentacionRegistrarManagedBean implements Serializable, Managedbean<Presentacion> {

    @EJB private PresentacionFacade prfc;
    private Presentacion presentacion;
    
    public PresentacionRegistrarManagedBean() {
    }

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }
    
    @PostConstruct
    public void init() {
        presentacion = new Presentacion();
    }

    public void registrarPresentacion() {
        try {
            System.out.println(presentacion + "SE VA A REGISTRAR");
            prfc.create(presentacion);
        } catch (Exception e) {
            System.out.println("ERROR - REGISTRAR PRESENTACION ! "+e);
        }
    }    

    @Override
    public Presentacion getObject(Integer i) {
        return prfc.find(i);
    }
    
}
