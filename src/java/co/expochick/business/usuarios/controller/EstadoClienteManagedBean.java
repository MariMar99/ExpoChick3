/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.usuarios.controller;

import co.expochick.backend.persistence.entity.Estadocliente;
import co.expochick.backend.persistence.entity.facade.EstadoclienteFacade;
import co.expochick.frontend.converter.util.Managedbean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Alexandra
 */
@Named(value = "estadoClienteManagedBean")
@RequestScoped
public class EstadoClienteManagedBean implements Serializable, Managedbean<Estadocliente> {

    private Estadocliente estadcliente;
    
    @EJB
    private EstadoclienteFacade estadClifc;
    
    public EstadoClienteManagedBean() {
    }

    public Estadocliente getEstadcliente() {
        return estadcliente;
    }

    public void setEstadcliente(Estadocliente estadcliente) {
        this.estadcliente = estadcliente;
    }
    
    @PostConstruct
    public void init(){
        estadcliente = new Estadocliente();
    }
    
    public List<Estadocliente> listEstadoCli(){
        return estadClifc.findAll();
    }

    @Override
    public Estadocliente getObject(Integer i) {
        return estadClifc.find(i);
    }
    
}
