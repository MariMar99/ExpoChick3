/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.frontend.antinarcoticos.converter;

import co.expochick.backend.persistence.entity.Estadoantinarcotico;
import co.expochick.frontend.converter.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mariana
 */
@FacesConverter(forClass = Estadoantinarcotico.class)
public class EstadoAntinarcoticosConverter extends AbstractConverter{

    public EstadoAntinarcoticosConverter() {
        this.nombreMBean = "estadoAntinarcoticosManagedBean";
    }
    
}