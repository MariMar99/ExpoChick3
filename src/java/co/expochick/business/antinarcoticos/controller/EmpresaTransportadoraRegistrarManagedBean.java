/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.antinarcoticos.controller;

import co.expochick.backend.persistence.entity.Empresatransporte;
import co.expochick.backend.persistence.entity.facade.EmpresatransporteFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Alexandra
 */
@Named(value = "empresaTransportadoraRegistrarManagedBean")
@RequestScoped
public class EmpresaTransportadoraRegistrarManagedBean {

    private Empresatransporte empTrans;
    
    @EJB
    private EmpresatransporteFacade empTransfc;
    
    public EmpresaTransportadoraRegistrarManagedBean() {
    }

    public Empresatransporte getEmpTrans() {
        return empTrans;
    }

    public void setEmpTrans(Empresatransporte empTrans) {
        this.empTrans = empTrans;
    }
    
    @PostConstruct
    public void init(){
        empTrans = new Empresatransporte();
    }
    
    public void registrarEmpTrans(){
        try {
            empTransfc.create(empTrans);
        } catch (Exception e) {
            System.out.println("ERROR - REGISTRAR EMPRESA DE TRANSPORTE ! "+e);
        }
    }
    
}
