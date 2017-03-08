/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.entity.facade;

import co.expochick.backend.persistence.entity.Preciocantidade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Familia Toro
 */
@Stateless
public class PreciocantidadeFacade extends AbstractFacade<Preciocantidade> {

    @PersistenceContext(unitName = "ExpoChick3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreciocantidadeFacade() {
        super(Preciocantidade.class);
    }
    
}
