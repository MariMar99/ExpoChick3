/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.login.controller;

import co.expochick.backend.persistence.entity.Permiso;
import co.expochick.backend.persistence.entity.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
//import javax.annotation.PostConstruct;

/**
 *
 * @author Alexandra
 */
@Named(value = "permisoSessionManagedBean")
@SessionScoped
public class PermisoSessionManagedBean implements Serializable {

    private Usuario usuario;    
    private List<Permiso> permisos;
    
    
    
    public PermisoSessionManagedBean() {
    }
    
    
    
    
}
