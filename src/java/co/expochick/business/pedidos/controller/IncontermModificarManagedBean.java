/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Inconterm;
import co.expochick.backend.persistence.entity.facade.IncontermFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "incontermModificarManagedBean")
@RequestScoped
public class IncontermModificarManagedBean implements Serializable {

    private Inconterm inconterm;
    
    @EJB
    private IncontermFacade infc;
    
    public IncontermModificarManagedBean() {
    }

    public Inconterm getInconterm() {
        return inconterm;
    }

    public void setInconterm(Inconterm inconterm) {
        this.inconterm = inconterm;
    }
    
    @PostConstruct
    public void init(){
        inconterm = new Inconterm();
    }
    
    public void modificarInconterm(){
        try {
            infc.edit(inconterm);
        } catch (Exception e) {
            System.out.println("ERROR - MODIFICAR INCONTERM ! "+e);
        }
    }
    
}
