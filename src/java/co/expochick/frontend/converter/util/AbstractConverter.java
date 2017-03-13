/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.frontend.converter.util;

import co.expochick.backend.persistence.entity.IEntity;
import java.lang.annotation.Annotation;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Alexandra
 */
public class AbstractConverter implements Converter {

    protected String nombreMBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {

            Integer i = Integer.valueOf(value);
            Managedbean d = (Managedbean) context.getApplication().getELResolver().getValue(context.getELContext(), null, nombreMBean);
            System.out.println(d.getObject(i));
            return d.getObject(i);
        } catch (NumberFormatException e) {
            context.addMessage(null, new FacesMessage("Error! - No se puede Convertir el Objeto"));
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            if (value instanceof IEntity) {
                IEntity conInt = (IEntity) value;
                System.out.println(conInt);
                return conInt.getId();
            }else{
                return null;
            }
        } catch (Exception e) {
            return " "+e.getMessage();
        }
    }

}
