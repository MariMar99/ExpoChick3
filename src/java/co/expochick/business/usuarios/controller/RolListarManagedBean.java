/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.usuarios.controller;

import co.expochick.backend.persistence.entity.Rol;
import co.expochick.backend.persistence.entity.facade.RolFacade;
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
@Named(value = "rolListarManagedBean")
@RequestScoped
public class RolListarManagedBean implements Serializable, Managedbean<Rol> {

    private Rol rol;
    
    @EJB 
    private RolFacade rolfc;
    
    public RolListarManagedBean() {
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    @PostConstruct
    public void init(){
        rol = new Rol();
    }
    
    public List<Rol> listarRol(){
        return rolfc.findAll();
    }

    @Override
    public Rol getObject(Integer i) {
        return rolfc.find(i);
    }
    
    
}
