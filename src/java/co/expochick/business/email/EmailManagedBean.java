package co.expochick.business.email;

import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mariana
 */
@Named(value = "emailManagedBean")
//@RequestScoped
@ViewScoped
public class EmailManagedBean {

    private String asunto;
    private String mensaje;
    private String destino;
        
    public EmailManagedBean() {
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public String enviarCorreo(){
        Email e = new Email (asunto, mensaje, destino);
        e.enviarEmailVarios();
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage m = new FacesMessage("Envio de Correo Exitoso!!!");
        fc.addMessage(null, m);
        return "";
    }
    
}
