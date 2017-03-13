/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Preciocantidade;
import co.expochick.backend.persistence.entity.facade.PreciocantidadeFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "precioCantidadModificarManagedBean")
@RequestScoped
public class PrecioCantidadModificarManagedBean implements Serializable {

     @EJB private PreciocantidadeFacade prefc;
    private Preciocantidade precioxCant;
    
    public PrecioCantidadModificarManagedBean() {
    }

    public Preciocantidade getPrecioxCant() {
        return precioxCant;
    }

    public void setPrecioxCant(Preciocantidade precioxCant) {
        this.precioxCant = precioxCant;
    }

    @PostConstruct
    public void init (){
        precioxCant = new Preciocantidade();
    }
    
    public void modificarPrecioCant(){
        try {
            prefc.edit(precioxCant);
        } catch (Exception e) {
            System.out.println("ERROR - MODIFICAR PRECIO CANTIDAD ! "+e);
        }
    }
    
}
