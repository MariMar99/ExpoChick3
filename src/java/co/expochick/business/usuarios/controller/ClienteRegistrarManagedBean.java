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
public class ClienteRegistrarManagedBean {

    private Cliente cliente;
    private Usuario usuario;
    
    @EJB
    private ClienteFacade clifc;
    @EJB
    private UsuarioFacade usufc;
            
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
            
            cliente.setIdClienteUsuario(Integer.MIN_VALUE);
            clifc.create(cliente);
            
        } catch (Exception e) {
        }
    }
    
    
}
