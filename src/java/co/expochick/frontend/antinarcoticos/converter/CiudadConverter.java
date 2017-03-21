/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.frontend.antinarcoticos.converter;

import co.expochick.backend.persistence.entity.Ciudad;
import co.expochick.frontend.converter.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Alexandra
 */
@FacesConverter(forClass = Ciudad.class)
public class CiudadConverter extends AbstractConverter {

    public CiudadConverter() {
        this.nombreMBean = "ciudadManagedBean";
    }    
    
}
