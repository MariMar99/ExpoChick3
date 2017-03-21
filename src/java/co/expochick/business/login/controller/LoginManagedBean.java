/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.login.controller;

import co.expochick.backend.persistence.entity.Usuario;
import co.expochick.backend.persistence.entity.facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alexandra
 */
@Named(value = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {

    private Usuario usuario;
    
    @EJB
    private UsuarioFacade usufc;
    
    public LoginManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
    
    public String iniciarSesion() {
        try {
            usuario = usufc.iniciarSesion(usuario);
            if (usuario != null) {
                usuario.getIdRol();
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuario);
                return "/protegido/inicio.xhtml?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario y/o Contraseña Incorrectos"));
                return "";
            }
        } catch (Exception e) {
            System.out.println("NO INGRESO AL SISTEMA");
            return "";
        }
    }
    
}
