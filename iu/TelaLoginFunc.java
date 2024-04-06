
package org.iu;


import java.util.Scanner;
import org.negocio.excecoes.*;
import org.negocio.Hotel;
public class TelaLoginFunc {
 
    private Scanner scanner;
    private Hotel fachada;
    private TelaFunc telaFunc;
    public TelaLoginFunc(Hotel fachada,Scanner scanner){
        this.scanner = scanner;
        this.fachada = fachada;
        this.telaFunc = new TelaFunc(fachada,scanner);
    }
    
   public void SolicitarLogin(){
   System.out.println("--Login Funcionário--");
   System.out.println("Usuário: ");
   String Usu = this.scanner.nextLine();
   System.out.println("Senha: ");
   String Senha = this.scanner.nextLine();
   boolean result = false;
   try{
       result = this.fachada.login_func(Usu, Senha);
   }catch(LoginException e){
       System.out.println(e.getMessage());
   
}
   if (result == true){
       this.telaFunc.solicitarFunções();
   }
    }
}
   

