
package org.iu;


import java.util.Scanner;
import org.negocio.Hotel;
import org.negocio.excecoes.*;
public class TelaCadastroFunc {
    private Scanner scanner;
    private Hotel fachada;
    public TelaCadastroFunc(Hotel fachada,Scanner scanner){
        this.scanner = scanner;
        this.fachada = fachada;
    }
    
   public void Solicitardados(){
        System.out.println("--Cadastro Funcionário--");
        System.out.println("Cpf: ");
        int cpf = this.scanner.nextInt();
        this.scanner.nextLine();
        System.out.println("Nome: ");
        String nome = this.scanner.nextLine();
        
        System.out.println("Data nascimento: ");
        String data_nascimento = this.scanner.nextLine();
        
        System.out.println("Sexo: ");
        char sexo = this.scanner.nextLine().charAt(0);
        
        System.out.println("Cep: ");
        String cep = this.scanner.nextLine();
        
        System.out.println("Estado [Ativo/Inativo}: ");
        String estado= this.scanner.nextLine();

        System.out.println("Usuário: ");
        String usu = this.scanner.nextLine();
        
        System.out.println("Senha: ");
        String senha = this.scanner.nextLine();

   try{
       this.fachada.adicionar_func(cpf,nome,data_nascimento,sexo,cep,usu,senha,estado);
       System.out.println("Cadastrado com sucesso.");
   }catch(ItemExisteException e){
       System.out.println(e.getMessage());
   
}
 
    }    
}
