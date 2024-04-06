
package org.negocio.excecoes;



public class LoginException extends Exception {
     public LoginException(){
        super("Usuário ou senha incorretos");
     }
}
