package co.expochick.business.login.controller;

import co.expochick.backend.persistence.entity.Cliente;
import co.expochick.backend.persistence.entity.Usuario;
import co.expochick.backend.persistence.entity.facade.ClienteFacade;
import co.expochick.backend.persistence.entity.facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;

/**
 *
 * @author Alexandra
 */
@Named(value = "usuariosRegistrarManagedBean")
@ConversationScoped
public class UsuariosRegistrarManagedBean implements Serializable {

    private Usuario usuario;

    private Cliente cliente;

    @EJB
    private UsuarioFacade usufc;

    @EJB
    private ClienteFacade clifc;

    @Inject
    private Conversation conversation;

    public UsuariosRegistrarManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        cliente = new Cliente();
    }
    
    String datosAleatorios(int longitud) {
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

    public String registroUser() {
        try {
            String claves = datosAleatorios(6); //Llama el metodo para poder generar la contraseña
            usuario.setClave(claves);
            
            usufc.create(usuario);
            
            Usuario user = usufc.capturarUsuario(usuario);
            if (user.getIdRol().getIdRol().equals(3)) {
                usuario = user;
                conversation.begin();
                return "/protegido/administrador/registrarcliente.xhtml?faces-redirect=true";
            }
        } catch (Exception e) {
            System.out.println("ERROR CONVERSATION - CREAR USUARIO "+e);
        }
        return "";
    }
    
    public String registrarClient(){
        try {
            String siglas = datosAleatorios(3); //Llama el metodo para poder generar la contraseña
            cliente.setSigla(siglas);
            
            getCliente().setIdClienteUsuario(usuario.getIdUsuario());
            getCliente().setUsuario(usuario);

            clifc.create(cliente);
            
            conversation.end();
            //usuario = null;
            
        } catch (Exception e) {
            System.out.println("ERROR CONVERSATION - REGISTRAR CLIENTE "+e);
        }
        return "";
    }

}
