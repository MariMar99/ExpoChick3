/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.usuarios.controller;

import co.expochick.backend.persistence.entity.Usuario;
import co.expochick.backend.persistence.entity.facade.UsuarioFacade;
import co.expochick.frontend.converter.util.Managedbean;
import java.io.Serializable;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Alexandra
 */
@Named(value = "usuarioRegistrarManagedBean")
@RequestScoped
public class UsuarioRegistrarManagedBean implements Serializable, Managedbean<Usuario> {

    private Usuario usuario;
    
    @EJB
    private UsuarioFacade usufc;
    
    public UsuarioRegistrarManagedBean() {
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
    
    
    String claveAleatoria(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }
    
    public void registrarUsuario(){
        try {
            String cadena = claveAleatoria(6); //Llama el metodo que genera la contraseña
            usuario.setClave(cadena);//Se genera
            usufc.create(usuario);
        } catch (Exception e) {
            System.out.println("dfghjkj");
        }
    }

    @Override
    public Usuario getObject(Integer i) {
        return usufc.find(i);
    }
    
}
