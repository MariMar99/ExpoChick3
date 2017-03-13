/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Pallet;
import co.expochick.backend.persistence.entity.facade.PalletFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "palletModificarManagedBean")
@RequestScoped
public class PalletModificarManagedBean implements Serializable{

    @EJB private PalletFacade pllfc;
    private Pallet pallet;
    
    public PalletModificarManagedBean() {
    }

    public Pallet getPallet() {
        return pallet;
    }

    public void setPallet(Pallet pallet) {
        this.pallet = pallet;
    }
    
    @PostConstruct
    public void init(){
        pallet = new Pallet();
    }
    
    public void modificarPallet(){
        try {
            pllfc.edit(pallet);
        } catch (Exception e) {
            System.out.println("ERROR - MODIFICAR PALLET ! "+e);
        }
    }
    
}
