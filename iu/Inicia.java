
package org.iu;


import org.negocio.Hotel;

public class Inicia {
    public static void main (String[] args){
  
        Hotel fachada = new Hotel();
        TelaPrincipal tela_principal = new TelaPrincipal(fachada);
        tela_principal.iniciar();
         
    }
}
