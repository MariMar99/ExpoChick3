/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Tipoempaque;
import co.expochick.backend.persistence.entity.facade.TipoempaqueFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Alexandra
 */
@Named(value = "tipoEmpaqueRegistrarManagedBean")
@RequestScoped
public class TipoEmpaqueRegistrarManagedBean {

    private Tipoempaque empaque;
    
    @EJB
    private TipoempaqueFacade empaquefc;
    
    public TipoEmpaqueRegistrarManagedBean() {
    }

    public Tipoempaque getEmpaque() {
        return empaque;
    }

    public void setEmpaque(Tipoempaque empaque) {
        this.empaque = empaque;
    }
    
    @PostConstruct
    public void init(){
        empaque = new Tipoempaque();
    }
    
    public void registrarEmpaque(){
        try {
            empaquefc.create(empaque);
        } catch (Exception e) {
            System.out.println("ERROR - REGISTRAR TIPO DE EMPAQUE ! "+e);
        }
    }
    
}
