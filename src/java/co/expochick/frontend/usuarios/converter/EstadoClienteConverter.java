/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.frontend.usuarios.converter;

import co.expochick.backend.persistence.entity.Estadocliente;
import co.expochick.frontend.converter.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Alexandra
 */
@FacesConverter(forClass = Estadocliente.class)
public class EstadoClienteConverter extends AbstractConverter{

    public EstadoClienteConverter() {
        this.nombreMBean = "estadoClienteManagedBean";
    }
    
}
