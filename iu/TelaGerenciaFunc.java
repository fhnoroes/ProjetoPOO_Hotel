
package org.iu;



import java.util.Scanner;
import org.negocio.Hotel;
import org.negocio.excecoes.*;
public class TelaGerenciaFunc {
    private Scanner scanner;
    private Hotel fachada;
    private TelaCadastroFunc telaCadastroFunc;
    public TelaGerenciaFunc(Hotel fachada,Scanner scanner){
        this.scanner = scanner;
        this.fachada = fachada;
        this.telaCadastroFunc = new TelaCadastroFunc(fachada,scanner);
        
    } 
    
    public void crudFunc(){
        
                while(true){
                        System.out.println("--Gerenciar Funcionários--");
                        System.out.println("1-adicionar funcionário");
                        System.out.println("2-deletar funcionário");
                        System.out.println("3-consultar funcionário");
                        System.out.println("4-Atualiza funcionário");
                        System.out.println("5-Voltar");
                        System.out.println("Digite a opção desejada: ");
                        String escolhaFunc = this.scanner.nextLine();
                    if(escolhaFunc.equals("1")){
                        this.telaCadastroFunc.Solicitardados();
                    }else if(escolhaFunc.equals("2")){
                        try{
                            System.out.println("--Excluir Funcionário--");
                            System.out.println("cpf: ");
                            int cpf= this.scanner.nextInt();
                            this.scanner.nextLine();
                            fachada.excluir_func(cpf);
                            System.out.println("Funcionário apagado com sucesso");
                        }catch(ItemNaoEncontradoException n){
                            System.out.println(n.getMessage());
                        } 
                    }else if(escolhaFunc.equals("3")){
                          try{
                            int tamanho =  fachada.consulta_func().size();
                            
                            System.out.println("--Funcionários--");

                            for (int c=0; c<tamanho;c++){         
                                System.out.println("-Cpf: "+fachada.consulta_func().get(c).getCpf()+" -Nome: "+fachada.consulta_func().get(c).getNome()+" -Data nascimento: "+fachada.consulta_func().get(c).getData_nascimento()+" -Sexo: "+fachada.consulta_func().get(c).getSexo()+ " -Cep: "+fachada.consulta_func().get(c).getCep()+" -Estado: "+fachada.consulta_func().get(c).getEstado()+" -Usuário: "+fachada.consulta_func().get(c).getUsuário()+ " -Senha: "+fachada.consulta_func().get(c).getSenha());                  
                            }
                        }catch (RepoVazioException f){
                            System.out.println(f.getMessage());
                        }
                    }else if(escolhaFunc.equals("4")){
                                System.out.println("--Atualizar Funcionário--");
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

                                System.out.println("Novo Estado [Ativo/Inativo}: ");
                                String estado= this.scanner.nextLine();

                                System.out.println("Novo Usuário: ");
                                String usu = this.scanner.nextLine();

                                System.out.println("Nova Senha: ");
                                String senha = this.scanner.nextLine();

                           try{
                               this.fachada.atualizar_func(cpf,nome,data_nascimento,sexo,cep,usu,senha,estado);
                               System.out.println("Atualizado com sucesso.");
                           }catch(ItemNaoEncontradoException e){
                               System.out.println(e.getMessage());

                        }
                    }else if(escolhaFunc.equals("5")){
                       break; 
                    }else{
                        System.out.println("Erro, opção inválida.");
                    }
                    }           
    }
}
