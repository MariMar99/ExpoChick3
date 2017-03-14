/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.frontend.usuarios.converter;

import co.expochick.backend.persistence.entity.Usuario;
import co.expochick.frontend.converter.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Alexandra
 */
@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter extends AbstractConverter{

    public UsuarioConverter() {
        this.nombreMBean = "usuarioRegistrarManagedBean";
    }
    
}
