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
@Named(value = "tEmpaqueRegistrarManagedBean")
@RequestScoped
public class TEmpaqueRegistrarManagedBean {

    private Tipoempaque tEmpaque;
    
    @EJB
    private TipoempaqueFacade tEmpfc;
    
    public TEmpaqueRegistrarManagedBean() {
    }

    public Tipoempaque gettEmpaque() {
        return tEmpaque;
    }

    public void settEmpaque(Tipoempaque tEmpaque) {
        this.tEmpaque = tEmpaque;
    }
    
    @PostConstruct
    public void init(){
        tEmpaque = new Tipoempaque();
    }
    
    public void registrarTipoEmpaque(){
        try {
            tEmpfc.create(tEmpaque);
        } catch (Exception e) {
            System.out.println("ERROR - REGISTRAR TIPO DE EMPAQUE ! "+e);
        }
    }
    
}
