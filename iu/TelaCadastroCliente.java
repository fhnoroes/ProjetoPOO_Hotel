
package org.iu;


import java.util.Scanner;
import org.negocio.Hotel;
import org.negocio.excecoes.*;
public class TelaCadastroCliente {
    private Scanner scanner;
    private Hotel fachada;
    public TelaCadastroCliente(Hotel fachada,Scanner scanner){
        this.scanner = scanner;
        this.fachada = fachada;
    }
    
   public void Solicitardados(){
        System.out.println("--Cadastro Hóspede--");
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
        
        System.out.println("cartão: ");
        int cartao= this.scanner.nextInt();
        this.scanner.nextLine();
        System.out.println("Usuário: ");
        String usu = this.scanner.nextLine();
        
        System.out.println("Senha: ");
        String senha = this.scanner.nextLine();

   try{
       this.fachada.adicionar_cliente(cpf,nome,data_nascimento,sexo,cep,usu,senha,cartao);
       System.out.println("Cadastrado com sucesso.");
   }catch(ItemExisteException e){
       System.out.println(e.getMessage());
   
}
 
    }    
}
