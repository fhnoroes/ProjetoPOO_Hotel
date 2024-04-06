
package org.iu;



import java.util.Scanner;
import org.negocio.Hotel;
import org.negocio.excecoes.*;
public class TelaCliente {
    private Scanner scanner;
    private Hotel fachada;
    public TelaCliente(Hotel fachada,Scanner scanner){
        this.scanner = scanner;
        this.fachada = fachada;
        
    }
    
    public void solicitarFunções(){
        while(true){
        System.out.println("--Bem vindo Hóspede--");
        System.out.println("1-Ver quartos");
        System.out.println("2-Ver reservas");
        System.out.println("3-Fazer reserva");
        System.out.println("4-Atualizar reserva");
        System.out.println("5-Atualizar Cadastro");
        System.out.println("6-Logoff");
        System.out.println("Digite a opção desejada: ");
        String escolha = this.scanner.nextLine();
        
        if (escolha.equals("1")){
          try{
             
            int tamanho = fachada.ver_quartos().size();
 
            System.out.println("--Quartos--");
            
            for (int c =0;c<tamanho;c++){
                if(fachada.tipo_quarto(fachada.ver_quartos().get(c).getId_quarto()).equals("premium")){
                System.out.println("-Id: "+fachada.ver_quartos().get(c).getId_quarto()+" -Preço da diária: " + fachada.ver_quartos().get(c).getPreco()+"R$"+" -Capacidade: "+fachada.ver_quartos().get(c).getCapacidade()+" pessoas"+" -Andar: "+fachada.ver_quartos().get(c).getAndar()+ " -Estado: "+fachada.ver_quartos().get(c).getEstado()+ " -Tipo: Premium");
            }else{
                    System.out.println("-Id: "+fachada.ver_quartos().get(c).getId_quarto()+" -Preço da diária: " + fachada.ver_quartos().get(c).getPreco()+"R$"+" -Capacidade: "+fachada.ver_quartos().get(c).getCapacidade()+" pessoas"+" -Andar: "+fachada.ver_quartos().get(c).getAndar()+ " -Estado: "+fachada.ver_quartos().get(c).getEstado()+ " -Tipo: Basic");
 
                    }
            }
          } catch (RepoVazioException e){
              System.out.println(e.getMessage());
          } 
        }else if(escolha.equals("2")){
            try{
                int tamanho =  fachada.consulta_reservas().size();
                System.out.println("--Reservas--");
                 System.out.println("Cpf: ");
                 int cpf= this.scanner.nextInt();
                 this.scanner.nextLine();
                for (int c=0; c<tamanho;c++){
                       if(fachada.consulta_reservas().get(c).getCpf()==cpf){
                       System.out.println("-Cod reserva: "+fachada.consulta_reservas().get(c).getCod_reserva()+" -Preço total: "+fachada.consulta_reservas().get(c).getPreco()+"R$"+" -Checkin: "+fachada.consulta_reservas().get(c).getData_checkin()+" -Checkout: "+fachada.consulta_reservas().get(c).getData_checkout()+ " -Cod quarto: "+fachada.consulta_reservas().get(c).getId_quarto()+" -Cpf: "+fachada.consulta_reservas().get(c).getCpf());
                   }else{
                        System.out.println("-Cod reserva: "+fachada.consulta_reservas().get(c).getCod_reserva()+" -Preço total: "+fachada.consulta_reservas().get(c).getPreco()+"R$"+" -Checkin: "+fachada.consulta_reservas().get(c).getData_checkin()+" -Checkout: "+fachada.consulta_reservas().get(c).getData_checkout()+ " -Cod quarto: "+fachada.consulta_reservas().get(c).getId_quarto());
                       }
                }
            }catch (RepoVazioException f){
                System.out.println(f.getMessage());
                        }
            }else if (escolha.equals("3")){
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
        }else if(escolha.equals("4")){
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
        }else if(escolha.equals("5")){
            try{
                System.out.println("--Atualizar Cadastro--"); 
                
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
                System.out.println("Novo usuário: ");
                String usu = this.scanner.nextLine();

                System.out.println("Nova senha: ");
                String senha = this.scanner.nextLine();
                this.fachada.atualizar_cliente(cpf,nome,data_nascimento,sexo,cep,usu,senha,cartao);
                System.out.println("Atualizado cadastro com sucesso.");
                
            }catch(ItemNaoEncontradoException ec){
                System.out.println(ec.getMessage());
            }
        }else if (escolha.equals("6")){
            System.out.println("Deslogando...");
            break;
        }else{
            System.out.println("Opção Inválida.");
        }
        }
        }
    }

