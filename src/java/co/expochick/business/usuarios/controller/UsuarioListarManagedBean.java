/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.usuarios.controller;

import co.expochick.backend.persistence.entity.Usuario;
import co.expochick.backend.persistence.entity.facade.UsuarioFacade;
import co.expochick.frontend.converter.util.Managedbean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Alexandra
 */
@Named(value = "usuarioListarManagedBean")
@SessionScoped
public class UsuarioListarManagedBean implements Serializable, Managedbean<Usuario> {

    private Usuario usuario;
    
    @EJB
    private UsuarioFacade usufc;
    
    public UsuarioListarManagedBean() {
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
    
    public List<Usuario> listarUsuarios(){
        return usufc.findAll();
    }

    @Override
    public Usuario getObject(Integer i) {
        return usufc.find(i);
    }
    
    
}
