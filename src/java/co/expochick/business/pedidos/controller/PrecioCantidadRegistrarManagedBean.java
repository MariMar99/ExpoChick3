/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Preciocantidade;
import co.expochick.backend.persistence.entity.facade.PreciocantidadeFacade;
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
@Named(value = "precioCantidadRegistrarManagedBean")
@RequestScoped
public class PrecioCantidadRegistrarManagedBean implements Serializable, Managedbean<Preciocantidade> {

    @EJB private PreciocantidadeFacade prefc;
    private Preciocantidade precioxCant;
    
    public PrecioCantidadRegistrarManagedBean() {
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
    
    public void registrarPrecioCant(){
        try {
            prefc.create(precioxCant);
        } catch (Exception e) {
            System.out.println("ERROR - REGISTRAR PRECIO CANTIDAD ! "+e);
        }
    }
    
    public String registrar(){
        return "";
    }

    @Override
    public Preciocantidade getObject(Integer i) {
        return prefc.find(i);
    }
    
}
