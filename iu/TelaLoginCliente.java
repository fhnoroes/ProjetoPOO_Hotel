
package org.iu;

import org.negocio.excecoes.*;
import java.util.Scanner;
import org.negocio.Hotel;
public class TelaLoginCliente {
    private Scanner scanner;
    private Hotel fachada;
    private TelaCliente  telaCliente;
    public TelaLoginCliente(Hotel fachada,Scanner scanner){
        this.scanner = scanner;
        this.fachada = fachada;
        this.telaCliente = new TelaCliente(fachada,scanner);
    }
    
   public void SolicitarLogin(){
   System.out.println("--Login Cliente--");
   System.out.println("Usuário: ");
   String Usu = this.scanner.nextLine();
   System.out.println("Senha: ");
   String Senha = this.scanner.nextLine();
   boolean result = false;
   try{
       result = this.fachada.login_cliente(Usu, Senha);
   }catch(LoginException e){
       System.out.println(e.getMessage());
   
}
   if (result == true){
       this.telaCliente.solicitarFunções();
   }
    }
}
