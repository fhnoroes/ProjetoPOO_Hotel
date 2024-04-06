
package org.negocio;

import org.dados.Repo_Reserva;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import org.negocio.excecoes.*;
public class NegocioReserva {
    private Repo_Reserva repositório;
    
    public NegocioReserva(Repo_Reserva repositório){
        this.repositório = repositório;
    }
    public ArrayList<Reserva> ver_reserva() throws RepoVazioException{
        ArrayList<Reserva> lista = new ArrayList();
        lista = repositório.getReservas();
        if (lista!=null){
            return lista;
        }else{
            throw new RepoVazioException();
        }
    }
    
    public float preco_reserva(int id,String checkin, String checkout,ArrayList<Quarto> q) throws ItemNaoEncontradoException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate data_checkin = LocalDate.parse(checkin, formatter);
        LocalDate data_checkout = LocalDate.parse(checkout, formatter);
        long diferencaDias = 1;
        diferencaDias = diferencaDias+ChronoUnit.DAYS.between(data_checkin,data_checkout);
        int tamanho = q.size();
        for(int c = 0;c<tamanho;c++){
            if (q.get(c).getId_quarto()==id){
                float preco_reserva = q.get(c).getPreco()*diferencaDias;
                return preco_reserva;
            }
        }
        throw new ItemNaoEncontradoException(id);
    }
    
    public void atualiza_reserva (int cod_reserva, String data_checkin, String data_checkout, int cpf, int id_quarto,ArrayList<Quarto> q) throws ItemNaoEncontradoException,DataPassadoException, QuartoOcupadoException, DataException{
        this.verifica_datas(id_quarto,data_checkin,data_checkout);
        boolean existe = repositório.consulta_repo(cod_reserva);
        if (existe){
            repositório.atualiza_repo(cod_reserva,data_checkin,data_checkout,cpf,id_quarto,this.preco_reserva(id_quarto, data_checkin, data_checkout, q));
        }else{
            throw new ItemNaoEncontradoException(cod_reserva);
        }
    }
    
    public void verifica_datas(int id,String checkin, String checkout)throws DataPassadoException, QuartoOcupadoException, DataException{
        LocalDateTime now = LocalDateTime.now(); 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = now.format(formatter);
        LocalDate data_atual = LocalDate.parse(formattedDate, formatter);
        LocalDate data_checkin = LocalDate.parse(checkin, formatter);
        LocalDate data_checkout = LocalDate.parse(checkout, formatter);
        
        if(data_checkin.isBefore(data_atual)){
            throw new DataPassadoException();
        }  
        if(data_checkout.isBefore(data_checkin)){
            throw new DataException();  
        }
        boolean quartigual = false;
        int tamanho = repositório.getReservas().size();
      
        for(int c = 0;c<tamanho;c++){
            if (repositório.getReservas().get(c).getId_quarto()==id){
                quartigual = true;
                break;
                  }
                }
            if (quartigual == true){
                for(int e = 0; e<tamanho;e++){
                        LocalDate compdata_checkin = LocalDate.parse(repositório.getReservas().get(e).getData_checkin(), formatter);
                        LocalDate compdata_checkout = LocalDate.parse(repositório.getReservas().get(e).getData_checkout(), formatter);
                        if(data_checkin.isAfter(compdata_checkin) && data_checkin.isBefore(compdata_checkout) || data_checkin.isEqual(compdata_checkin)||data_checkin.isEqual(compdata_checkout)){
                            throw new QuartoOcupadoException(repositório.getReservas().get(e).getId_quarto(),repositório.getReservas().get(e).getData_checkin(),repositório.getReservas().get(e).getData_checkout());
                        }
                        if(data_checkout.isAfter(compdata_checkin) && data_checkout.isBefore(compdata_checkout) || data_checkout.isEqual(compdata_checkout)||data_checkout.isEqual(compdata_checkin)){
                            throw new QuartoOcupadoException(repositório.getReservas().get(e).getId_quarto(),repositório.getReservas().get(e).getData_checkin(),repositório.getReservas().get(e).getData_checkout());
                        }
                   }    
            }
    }
    public void add_reserva(Reserva r,ArrayList<Quarto> q) throws ItemNaoEncontradoException,ItemExisteException, DataPassadoException, DataException, QuartoOcupadoException{
                    int id = r.getId_quarto();
                    String checkin = r.getData_checkin();
                    String checkout = r.getData_checkout();
                    this.verifica_datas(id,checkin,checkout);
                    boolean existe = repositório.consulta_repo(r.getCod_reserva());
                    if (existe){
                        throw new ItemExisteException();
                    }
                    r.setPreco(this.preco_reserva(id,checkin,checkout,q));
                    repositório.add_repo(r);
    }
    
   
    
    public void excluir_reserva(int id) throws ItemNaoEncontradoException{
        boolean existe =  repositório.consulta_repo(id);
        if (existe){
            repositório.excluir_repo(id);   
        }else{
            throw new ItemNaoEncontradoException(id);
        }
    }
}
