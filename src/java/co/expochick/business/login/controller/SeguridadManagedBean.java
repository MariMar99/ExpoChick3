/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.login.controller;

import co.expochick.backend.persistence.entity.Usuario;
import co.expochick.backend.persistence.entity.facade.UsuarioFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Alexandra
 */
@Named(value = "seguridadManagedBean")
@RequestScoped
public class SeguridadManagedBean {

    private Usuario usuario;

    @EJB
    private UsuarioFacade usufc;

    public SeguridadManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public void verificarSesion() {
        try {
            Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            if (user == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("./../permisos.xhtml");
            }
        } catch (Exception e) {

        }
    }

    public void cerrarSesion(){
       FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
   }
    
}
