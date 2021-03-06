/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.usuarios.controller;

import co.expochick.backend.persistence.entity.Cliente;
import co.expochick.backend.persistence.entity.Usuario;
import co.expochick.backend.persistence.entity.facade.ClienteFacade;
import co.expochick.backend.persistence.entity.facade.UsuarioFacade;
import co.expochick.frontend.converter.util.Managedbean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/** 
 *
 * @author Alexandra
 */
@Named(value = "clienteRegistrarManagedBean")
@RequestScoped
public class ClienteRegistrarManagedBean implements Serializable, Managedbean<Cliente>{

    private Usuario usuario;
    private Cliente cliente;
    
    @EJB
    private UsuarioFacade usufc;
    @EJB
    private ClienteFacade clifc;
            
    public ClienteRegistrarManagedBean() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        cliente = new Cliente();
        usuario = new Usuario();
    }
    
    public void registrarCliente(){
        try {
            usufc.create(usuario);
            
            //La Sigla es creada por el SIstema
            clifc.create(cliente);
            
            
        } catch (Exception e) {
        }
    }

    @Override
    public Cliente getObject(Integer i) {
        return clifc.find(i);
    }
    
    
}
