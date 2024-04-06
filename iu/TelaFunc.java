
package org.iu;


import java.util.Scanner;
import org.negocio.Hotel;
public class TelaFunc {
    private Scanner scanner;
    private Hotel fachada;
    private TelaGerenciaCliente telaGerenciaCliente;
    private TelaGerenciaFunc telaGerenciaFunc;
    private TelaGerenciaReserva telaGerenciaReserva;
    private TelaGerenciaQuarto telaGerenciaQuarto;
    
    public TelaFunc(Hotel fachada,Scanner scanner){
        this.scanner = scanner;
        this.fachada = fachada;
        this.telaGerenciaCliente = new TelaGerenciaCliente(fachada,scanner);
        this.telaGerenciaFunc = new TelaGerenciaFunc(fachada,scanner);
        this.telaGerenciaQuarto =  new TelaGerenciaQuarto(fachada,scanner);
        this.telaGerenciaReserva =  new TelaGerenciaReserva(fachada,scanner);
        
    }
    
    public void solicitarFunções(){
        while(true){
            System.out.println("--Bem vindo Funcionário--");
            System.out.println("1-Gerenciar Reserva");
            System.out.println("2-Gerenciar Clientes");
            System.out.println("3-Gerenciar Funcionários");
            System.out.println("4-Gerenciar Quarto ");
            System.out.println("5-Logoff ");
            System.out.println("Digite a opção desejada: ");
            String escolha = this.scanner.nextLine();
        
            if (escolha.equals("1")){
               this.telaGerenciaReserva.crudReserva();
            }else if (escolha.equals("2")){
                this.telaGerenciaCliente.crudCliente();
            }else if (escolha.equals("3")){
                  this.telaGerenciaFunc.crudFunc();
            }else if(escolha.equals("4")){
               this.telaGerenciaQuarto.crudQuarto();
            }else if (escolha.equals("5")){
                System.out.println("Deslogando...");
                break;
            }else{
                System.out.println("Erro opção inválida.");
            }
        }
    }
}

    


