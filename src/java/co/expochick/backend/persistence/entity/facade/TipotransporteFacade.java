/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.entity.facade;

import co.expochick.backend.persistence.entity.Tipotransporte;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Familia Toro
 */
@Stateless
public class TipotransporteFacade extends AbstractFacade<Tipotransporte> {

    @PersistenceContext(unitName = "ExpoChick3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipotransporteFacade() {
        super(Tipotransporte.class);
    }
    
}
