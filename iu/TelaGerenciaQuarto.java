
package org.iu;

import org.negocio.Hotel;

import java.util.Scanner;
import org.negocio.excecoes.*;
public class TelaGerenciaQuarto {
    private Scanner scanner;
    private Hotel fachada;
    public TelaGerenciaQuarto(Hotel fachada,Scanner scanner){
        this.scanner = scanner;
        this.fachada = fachada;  
    }
    
    public void crudQuarto(){
                
                while(true){
                        System.out.println("--Gerenciar Quarto--");
                        System.out.println("1-adicionar quarto");
                        System.out.println("2-deletar quarto");
                        System.out.println("3-consultar quarto");
                        System.out.println("4-atualizar quarto");
                        System.out.println("5-voltar");
                        System.out.println("Digite a opção desejada: ");
                        String escolhaQ = this.scanner.nextLine();
                    if(escolhaQ.equals("1")){
                            System.out.println("--Fazer Quarto--");
                            System.out.println("Tipo [premium/basic]: ");
                            String tipo= this.scanner.nextLine();
                            
                            if(tipo.equals("premium")){
                                try{
                                    System.out.println("--Fazer Quarto Premium--");
                                    System.out.println("Id: ");
                                    int id= this.scanner.nextInt();
                                    this.scanner.nextLine();
                                    System.out.println("Estado[ativo/inativo]: ");
                                    String estado= this.scanner.nextLine();
                                    System.out.println("Capacidade: ");
                                    int cap= this.scanner.nextInt();
                                    this.scanner.nextLine();
                                    System.out.println("Preço: ");
                                    float preco= this.scanner.nextFloat();
                                    this.scanner.nextLine();
                                    System.out.println("Andar: ");
                                    String andar = this.scanner.nextLine();
                                    System.out.println("Serviço de Quarto [true,false]: ");
                                    boolean sq = this.scanner.nextBoolean();
                                    this.scanner.nextLine();
                                    System.out.println("Sauna [true,false]: ");
                                    boolean sauna = this.scanner.nextBoolean();
                                    this.scanner.nextLine();
                                    System.out.println("Piscina [true,false]: ");
                                    boolean piscina = this.scanner.nextBoolean();
                                    this.scanner.nextLine();
                                    System.out.println("Alimentação [true,false]: ");
                                    boolean alimentacao = this.scanner.nextBoolean();
                                    this.scanner.nextLine();
                                    System.out.println("Vista [true,false]: ");
                                    boolean vista = this.scanner.nextBoolean();
                                    this.scanner.nextLine();
                                    fachada.adicionar_quartoPremium(id,estado,cap,preco,andar,sq,sauna,piscina,alimentacao,vista);
                                    System.out.println("Quarto adicionado com sucesso.");
                                }catch(ItemExisteException n){
                                    System.out.println(n.getMessage());
                                    
                                }
                            }else if(tipo.equals("basic")){
                                try{
                                    System.out.println("--Fazer Quarto Basic--");
                                    System.out.println("Id: ");
                                    int id= this.scanner.nextInt();
                                    this.scanner.nextLine();
                                    System.out.println("Estado[ativo/inativo]: ");
                                    String estado= this.scanner.nextLine();
                                    System.out.println("Capacidade: ");
                                    int cap= this.scanner.nextInt();
                                    this.scanner.nextLine();
                                    System.out.println("Preço: ");
                                    float preco= this.scanner.nextFloat();
                                    this.scanner.nextLine();
                                    System.out.println("Andar: ");
                                    String andar = this.scanner.nextLine();
                                    System.out.println("Alimentação [true,false]: ");
                                    boolean alimentacao = this.scanner.nextBoolean();
                                    this.scanner.nextLine();
                                    fachada.adicionar_quartoBasic(id,estado, cap, preco,andar, alimentacao);
                                    System.out.println("Quarto adicionado com sucesso.");
                                }catch(ItemExisteException n){
                                    System.out.println(n.getMessage());
                                    
                                } 
                            }else{
                                System.out.println("Erro, tipo inválido");
                            }
                         
                            
                    }else if(escolhaQ.equals("2")){
                        try{
                            System.out.println("--Excluir Quarto--");
                            System.out.println("Id quarto: ");
                            int id_q= this.scanner.nextInt();
                            this.scanner.nextLine();
                            fachada.excluir_quarto(id_q);
                            System.out.println("Quarto apagado com sucesso");
                        }catch(ItemNaoEncontradoException n){
                            System.out.println(n.getMessage());
                        }
                    }else if(escolhaQ.equals("3")){
                        
                       try{
                            int tamanho = fachada.ver_quartos().size();
                           
                            System.out.println("--Quartos--");
            
                            for (int c =0;c<tamanho;c++){
                                if(fachada.tipo_quarto(fachada.ver_quartos().get(c).getId_quarto()).equals("premium")){
                                System.out.println("-Id: "+ fachada.ver_quartos().get(c).getId_quarto()+" -Preço da diária: " +  fachada.ver_quartos().get(c).getPreco()+"R$"+" -Capacidade: "+ fachada.ver_quartos().get(c).getCapacidade()+" pessoas"+" -Andar: "+ fachada.ver_quartos().get(c).getAndar()+ " -Estado: "+ fachada.ver_quartos().get(c).getEstado()+ " -Tipo: Premium");
                            }else{
                                    System.out.println("-Id: "+ fachada.ver_quartos().get(c).getId_quarto()+" -Preço da diária: " +  fachada.ver_quartos().get(c).getPreco()+"R$"+" -Capacidade: "+ fachada.ver_quartos().get(c).getCapacidade()+" pessoas"+" -Andar: "+ fachada.ver_quartos().get(c).getAndar()+ " -Estado: "+ fachada.ver_quartos().get(c).getEstado()+ " -Tipo: Basic");

                                    }
                            }
                          } catch (RepoVazioException e){
                              System.out.println(e.getMessage());
                          } 
                    }else if(escolhaQ.equals("4")){
                          
                            System.out.println("--Atualizar Quarto--");
                            System.out.println("Tipo [premium/basic]: ");
                            String tipo= this.scanner.nextLine();
                            
                            if(tipo.equals("premium")){
                                try{
                                    System.out.println("--Atualizar Quarto Premium--");
                                    System.out.println("Id: ");
                                    int id= this.scanner.nextInt();
                                    this.scanner.nextLine();
                                    System.out.println("Novo Estado[ativo/inativo]: ");
                                    String estado= this.scanner.nextLine();
                                    System.out.println("Nova Capacidade: ");
                                    int cap= this.scanner.nextInt();
                                    this.scanner.nextLine();
                                    System.out.println("Novo Preço: ");
                                    float preco= this.scanner.nextFloat();
                                    this.scanner.nextLine();
                                    System.out.println("Novo Andar: ");
                                    String andar = this.scanner.nextLine();
                                    System.out.println("Novo Serviço de Quarto [true,false]: ");
                                    boolean sq = this.scanner.nextBoolean();
                                    this.scanner.nextLine();
                                    System.out.println("Nova Sauna [true,false]: ");
                                    boolean sauna = this.scanner.nextBoolean();
                                    this.scanner.nextLine();
                                    System.out.println("Nova Piscina [true,false]: ");
                                    boolean piscina = this.scanner.nextBoolean();
                                    this.scanner.nextLine();
                                    System.out.println("Nova Alimentação [true,false]: ");
                                    boolean alimentacao = this.scanner.nextBoolean();
                                    this.scanner.nextLine();
                                    System.out.println("Nova Vista [true,false]: ");
                                    boolean vista = this.scanner.nextBoolean();
                                    this.scanner.nextLine();
                                    fachada.atualizar_quartoPremium(id,estado,cap,preco,andar,sq,sauna,piscina,alimentacao,vista);
                                    System.out.println("Quarto atualizado com sucesso.");
                                }catch(ItemNaoEncontradoException n){
                                    System.out.println(n.getMessage());
                                    
                                }
                            }else if(tipo.equals("basic")){
                                try{
                                    System.out.println("--Atualizar Quarto Basic--");
                                    System.out.println("Id: ");
                                    int id= this.scanner.nextInt();
                                    this.scanner.nextLine();
                                    System.out.println("Novo Estado[ativo/inativo]: ");
                                    String estado= this.scanner.nextLine();
                                    System.out.println("Nova Capacidade: ");
                                    int cap= this.scanner.nextInt();
                                    this.scanner.nextLine();
                                    System.out.println("Novo Preço: ");
                                    float preco= this.scanner.nextFloat();
                                    this.scanner.nextLine();
                                    System.out.println("Novo Andar: ");
                                    String andar = this.scanner.nextLine();
                                    System.out.println("Nova Alimentação [true,false]: ");
                                    boolean alimentacao = this.scanner.nextBoolean();
                                    this.scanner.nextLine();
                                    fachada.atualizar_quartoBasic(id,estado, cap, preco,andar, alimentacao);
                                    System.out.println("Quarto atualizado com sucesso.");
                                }catch(ItemNaoEncontradoException n){
                                    System.out.println(n.getMessage());
                                    
                                } 
                            }else{
                                System.out.println("Erro, tipo inválido");
                            }
                    }else if(escolhaQ.equals("5")){
                        break;
                    }else{
                        System.out.println("Erro opção inválida.");
                    }
                }
    }
}
