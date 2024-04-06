
package org.iu;



import java.util.Scanner;
import org.negocio.Hotel;
import org.negocio.excecoes.*;
public class TelaGerenciaCliente {
    private Scanner scanner;
    private Hotel fachada;
    private TelaCadastroCliente telaCadastroCliente;

    public TelaGerenciaCliente(Hotel fachada,Scanner scanner){
        this.scanner = scanner;
        this.fachada = fachada;
        this.telaCadastroCliente = new TelaCadastroCliente(fachada,scanner);
   
    }
    public void crudCliente(){
               
                while(true){
                System.out.println("--Gerenciar Clientes--");
                System.out.println("1-adicionar cliente");
                System.out.println("2-deletar cliente");
                System.out.println("3-consultar cliente");
                System.out.println("5-Atualizar cliente");
                System.out.println("5-voltar");
                System.out.println("Digite a opção desejada: ");
                String escolhaCli = this.scanner.nextLine();
                   if(escolhaCli.equals("1")){
                        this.telaCadastroCliente.Solicitardados();
                    }else if(escolhaCli.equals("2")){
                        try{
                            System.out.println("--Excluir Cliente--");
                            System.out.println("cpf: ");
                            int cpf= this.scanner.nextInt();
                            this.scanner.nextLine();
                            fachada.excluir_cliente(cpf);
                            System.out.println("Cliente apagado com sucesso");
                        }catch(ItemNaoEncontradoException n){
                            System.out.println(n.getMessage());
                        } 
                    }else if(escolhaCli.equals("3")){
                          try{
                            int tamanho =  fachada.consulta_clientes().size();
                            
                            System.out.println("--Cliente--");

                            for (int c=0; c<tamanho;c++){         
                                System.out.println("-Cpf: "+fachada.consulta_clientes().get(c).getCpf()+" -Nome: "+fachada.consulta_clientes().get(c).getNome()+" -Data nascimento: "+fachada.consulta_clientes().get(c).getData_nascimento()+" -Sexo: "+fachada.consulta_clientes().get(c).getSexo()+ " -Cep: "+fachada.consulta_clientes().get(c).getCep()+" -Cartão: "+fachada.consulta_clientes().get(c).getCartao()+" -Usuário: "+fachada.consulta_clientes().get(c).getUsuário()+ " -Senha: "+fachada.consulta_clientes().get(c).getSenha());                  
                            }
                        }catch (RepoVazioException f){
                            System.out.println(f.getMessage());
                        }
                    }else if(escolhaCli.equals("4")){
                                 System.out.println("--Atualizar Cliente--");
                                 System.out.println("Cpf: ");
                                 int cpf = this.scanner.nextInt();
                                 this.scanner.nextLine();
                                 System.out.println("Novo Nome: ");
                                 String nome = this.scanner.nextLine();

                                 System.out.println("Nova Data nascimento: ");
                                 String data_nascimento = this.scanner.nextLine();

                                 System.out.println("Novo Sexo: ");
                                 char sexo = this.scanner.nextLine().charAt(0);

                                 System.out.println("Novo Cep: ");
                                 String cep = this.scanner.nextLine();

                                 System.out.println("Novo cartão: ");
                                 int cartao= this.scanner.nextInt();
                                 this.scanner.nextLine();
                                 System.out.println("Novo Usuário: ");
                                 String usu = this.scanner.nextLine();

                                 System.out.println("Nova Senha: ");
                                 String senha = this.scanner.nextLine();

                            try{
                                this.fachada.atualizar_cliente(cpf,nome,data_nascimento,sexo,cep,usu,senha,cartao);
                                System.out.println("Atualizado com sucesso.");
                            }catch(ItemNaoEncontradoException e){
                                System.out.println(e.getMessage());

                         }
                       }else if(escolhaCli.equals("5")){
                       break; 
                    }else{
                        System.out.println("Erro, opção inválida.");
                    }
                            
                }
    }
}
