/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.frontend.usuarios.converter;

import co.expochick.backend.persistence.entity.Rol;
import co.expochick.frontend.converter.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Alexandra
 */
@FacesConverter(forClass = Rol.class)
public class RolConverter extends AbstractConverter{

    public RolConverter() {
        this.nombreMBean = "rolListarManagedBean";
    }
    
}
