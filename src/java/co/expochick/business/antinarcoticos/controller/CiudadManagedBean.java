/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.antinarcoticos.controller;

import co.expochick.backend.persistence.entity.Ciudad;
import co.expochick.backend.persistence.entity.facade.CiudadFacade;
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
@Named(value = "ciudadManagedBean")
@RequestScoped
public class CiudadManagedBean implements Serializable, Managedbean<Ciudad> {

    private Ciudad ciudad;
    
    @EJB
    private CiudadFacade ciufc;
    
    public CiudadManagedBean() {
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    @PostConstruct
    public void init(){
        ciudad = new Ciudad();
    }
    
    public List<Ciudad> listarCiudad(){
        return ciufc.findAll();
    }

    @Override
    public Ciudad getObject(Integer i) {
        return ciufc.find(i);
    }
    
}
