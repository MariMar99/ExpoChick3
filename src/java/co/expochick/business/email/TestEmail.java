/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.email;

/**
 *
 * @author Mariana
 */
public class TestEmail {
    public static void main(String[] args){
        Email e = new Email ("Me merezco Un OSCAR por excelent Copy+Pegar", 
                "Miraaaaaaaaaaaa ... jajajajjaja toca enviarlo por consola porque no me funciona el Payara....:P ufff por fin una que te gano :P Me merezco un OSCAR.... Pd: Mi Espanglish a que es Genial!!! en el asunto", "alexandrams1999@hotmail.com");
        e.enviarEmail();
        
    }
}
