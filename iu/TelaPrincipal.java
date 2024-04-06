
package org.iu;

import java.util.Scanner;
import org.negocio.Hotel;
public class TelaPrincipal {
    private Scanner scanner;
    private TelaLoginCliente telaLoginCliente;
    private TelaLoginFunc telaLoginFunc;
    private TelaCadastroCliente telaCadastroCliente;
    private TelaCadastroFunc telaCadastroFunc;

    public TelaPrincipal(Hotel fachada){
        scanner = new Scanner (System.in);
        this.telaLoginCliente = new TelaLoginCliente(fachada,scanner);
        this.telaLoginFunc = new TelaLoginFunc(fachada,scanner);
        this.telaCadastroCliente = new TelaCadastroCliente(fachada,scanner);
        this.telaCadastroFunc = new TelaCadastroFunc(fachada,scanner);
    }
    public void iniciar(){
        
        while (true) {
            System.out.println("--MENU INICIAL--");
            System.out.println("1-Login");
            System.out.println("2-Cadastrar-se");
            System.out.println("3-Finalizar sistema");
            System.out.println("Digite sua escolha: ");
            String escolha =scanner.nextLine();
                
                if (escolha.equals("1")){
                    while (true){
                    System.out.println("--LOGIN--");
                    System.out.println("Deseja logar como?");
                    System.out.println("1-Cliente");
                    System.out.println("2-Funcionário");
                    System.out.println("3-Voltar");
                    String escolhaLogin =scanner.nextLine();
                    
                   
                        if (escolhaLogin.equals("1")){
                            this.telaLoginCliente.SolicitarLogin();
                        }else if(escolhaLogin.equals("2")){
                            this.telaLoginFunc.SolicitarLogin();
                        }else if(escolhaLogin.equals("3")){
                            break;
                        }else{
                            System.out.println("Opção Inválida");
                        }
                            
                    }
                }
                else if (escolha.equals("2")){
                    
                    while (true){
                    System.out.println("--Cadastro--");
                    System.out.println("Deseja cadastrar o que?");
                    System.out.println("1-Cliente");
                    System.out.println("2-Funcionário");
                    System.out.println("3-Voltar");
                    
                    String escolhaCadastro = scanner.nextLine();
                    if(escolhaCadastro.equals("1")){
                        this.telaCadastroCliente.Solicitardados();
                    }else if(escolhaCadastro.equals("2")){
                        this.telaCadastroFunc.Solicitardados();
                    }else if(escolhaCadastro.equals("3")){
                        break;
                    }else{
                        System.out.println("Opção Inválida");
                    }
                    }
                }
                    
                    
                else if (escolha.equals("3")){
                    System.out.println("Finalizando sistema!");
                    System.exit(0);
                    break;
                }else{
                    System.out.println("Opção inválida");
            }
        }
    }
}
