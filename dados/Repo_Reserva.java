
package org.dados;
import org.negocio.Reserva;
import java.util.ArrayList;

public class Repo_Reserva extends Repositório {
   private ArrayList<Reserva> reservas = new ArrayList();
   public Repo_Reserva(){
    }

     public ArrayList<Reserva> getReservas() {
        return reservas;
    }
     
    public void atualiza_repo(int cod_reserva, String data_checkin, String data_checkout, int cpf, int id_quarto,float preco){
        int id = cod_reserva;
        int tamanho = this.reservas.size();
        for(int c = 0; c<tamanho;c++){ 
            if(reservas.get(c).getCod_reserva()==id){
                this.reservas.get(c).setCpf(cpf);
                this.reservas.get(c).setData_checkin(data_checkin);
                this.reservas.get(c).setData_checkout(data_checkout);
                this.reservas.get(c).setPreco(preco);
                break;
            } 
    }
        
    }
    @Override
    public void add_repo(Object e){
        this.reservas.add((Reserva) e);
    }


    @Override
    public void excluir_repo(int e) {
        int id = e;
        int tamanho = this.reservas.size();
        for(int c = 0; c<tamanho;c++){ 
            if(reservas.get(c).getCod_reserva()==id){
                this.reservas.remove(c);
                break;
            } 
    } 
    }

    @Override
    public boolean consulta_repo(int e){
    int id = e;
    int tamanhoLista = this.reservas.size();
    for(int c = 0; c<tamanhoLista;c++){
        if(this.reservas.get(c).getCod_reserva()==id){
            return true;
        }
    }
    return false;
    }
    
   
    
}


        
    

