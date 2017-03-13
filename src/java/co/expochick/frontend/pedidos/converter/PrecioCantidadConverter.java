/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.frontend.pedidos.converter;

import co.expochick.backend.persistence.entity.Preciocantidade;
import co.expochick.frontend.converter.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Alexandra
 */
@FacesConverter(forClass = Preciocantidade.class)
public class PrecioCantidadConverter extends AbstractConverter{

    public PrecioCantidadConverter() {
        this.nombreMBean = "precioCantidadRegistrarManagedBean";
    }
    
}
