
package org.iu;


import org.negocio.excecoes.*;
import java.util.Scanner;
import org.negocio.Hotel;
public class TelaGerenciaReserva {
    private Scanner scanner;
    private Hotel fachada;
    public TelaGerenciaReserva(Hotel fachada,Scanner scanner){
        this.scanner = scanner;
        this.fachada = fachada;
    }
    
    public void crudReserva(){
                
                while(true){
                        System.out.println("--Gerenciar Reserva--");
                        System.out.println("1-adicionar reserva");
                        System.out.println("2-deletar reserva");
                        System.out.println("3-consultar reserva");
                        System.out.println("4-voltar");
                        System.out.println("Digite a opção desejada: ");
                        String escolhaRe = this.scanner.nextLine();
                    if(escolhaRe.equals("1")){
                        try{
                            System.out.println("--Fazer Reserva--");
                            System.out.println("Cpf: ");
                            int cpf= this.scanner.nextInt();
                            this.scanner.nextLine();
                            System.out.println("Id quarto: ");
                            int id_q= this.scanner.nextInt();
                            this.scanner.nextLine();
                            System.out.println("Checkin: ");
                            String checkin= this.scanner.nextLine();
                            System.out.println("Checkout: ");
                            String checkout= this.scanner.nextLine();
                            fachada.adicionar_reserva(checkin, checkout, cpf, id_q);
                            System.out.println("Reserva feita com sucesso");
                        }catch(ItemNaoEncontradoException|DataException| ItemExisteException|DataPassadoException| QuartoOcupadoException|RepoVazioException re){
                            System.out.println(re.getMessage());
                        }
                    }else if(escolhaRe.equals("2")){
                        try{
                            System.out.println("--Excluir Reserva--");
                            System.out.println("Id reserva: ");
                            int id_r= this.scanner.nextInt();
                            this.scanner.nextLine();
                            fachada.excluir_reserva(id_r);
                            System.out.println("Reserva apagada com sucesso");
                        }catch(ItemNaoEncontradoException n){
                            System.out.println(n.getMessage());
                        }
                    }else if(escolhaRe.equals("3")){
                        try{
                            int tamanho =  fachada.consulta_reservas().size();
                           
                            System.out.println("--Reservas--");

                            for (int c=0; c<tamanho;c++){         
                                    System.out.println("-Cod reserva: "+fachada.consulta_reservas().get(c).getCod_reserva()+" -Preço total: "+fachada.consulta_reservas().get(c).getPreco()+"R$"+" -Checkin: "+fachada.consulta_reservas().get(c).getData_checkin()+" -Checkout: "+fachada.consulta_reservas().get(c).getData_checkout()+ " -Cod quarto: "+fachada.consulta_reservas().get(c).getId_quarto()+" -Cpf: "+fachada.consulta_reservas().get(c).getCpf());                  
                            }
                        }catch (RepoVazioException f){
                            System.out.println(f.getMessage());
                        }
                    }else if(escolhaRe.equals("4")){
                         try{
                                System.out.println("--Atualizar Reserva--");

                                this.scanner.nextLine();
                                System.out.println("Id reserva: ");
                                int id_r= this.scanner.nextInt();
                                this.scanner.nextLine();
                                System.out.println("Novo Cpf: ");
                                int cpf= this.scanner.nextInt();
                                System.out.println("Novo Id quarto: ");
                                int id_q= this.scanner.nextInt();
                                this.scanner.nextLine();
                                System.out.println("Novo Checkin: ");
                                String checkin= this.scanner.nextLine();
                                System.out.println("Novo Checkout: ");
                                String checkout= this.scanner.nextLine();
                                fachada.atualizar_reserva(id_r,checkin, checkout, cpf, id_q);
                                System.out.println("Reserva atualizada com sucesso");
                            }catch(ItemNaoEncontradoException|DataException|DataPassadoException| QuartoOcupadoException|RepoVazioException ae){
                                System.out.println(ae.getMessage());
                            } 
                        }else if(escolhaRe.equals("5")){
                        break;
                    }else{
                        System.out.println("Erro opção inválida.");
                    }
                }
    }
}
