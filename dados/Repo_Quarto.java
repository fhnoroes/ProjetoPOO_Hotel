
package org.dados;

import java.util.ArrayList;
import org.negocio.Quarto;
import org.negocio.QuartoBasic;
import org.negocio.QuartoPremium;
public class Repo_Quarto implements IRepositório {
    protected ArrayList<Quarto> listaQuarto = new ArrayList();

   
    public Repo_Quarto() {
        
    }

    
    public ArrayList<Quarto> getListaQuarto() {
        return listaQuarto;
    }
    public void atualizaBasic_repo(int id_quarto, String estado, int capacidade, float preco,String andar, boolean alimentação){
        int id = id_quarto;
        int tamanho = this.listaQuarto.size();
        for(int c = 0; c<tamanho;c++){ 
            if(listaQuarto.get(c).getId_quarto()==id && listaQuarto.get(c) instanceof QuartoBasic){
                QuartoBasic p = (QuartoBasic) listaQuarto.get(c);
                p.setEstado(estado);
                p.setAndar(andar);
                p.setCapacidade(capacidade);
                p.setPreco(preco);
                p.setAlimentação(alimentação);
                break;

            } 
    }
    }
    public void atualizaPremium_repo(int id_quarto, String estado, int capacidade, float preco, String andar, boolean serviço_de_quarto,boolean sauna,boolean piscina,boolean alimentação,boolean vista ){
        int id = id_quarto;
        int tamanho = this.listaQuarto.size();
        for(int c = 0; c<tamanho;c++){ 
            if(listaQuarto.get(c).getId_quarto()==id && listaQuarto.get(c) instanceof QuartoPremium){
                QuartoPremium p = (QuartoPremium) listaQuarto.get(c);
                p.setEstado(estado);
                p.setAndar(andar);
                p.setCapacidade(capacidade);
                p.setPreco(preco);
                p.setPiscina(piscina);
                p.setSauna(sauna);
                p.setAlimentação(alimentação);
                p.setServiço_de_quarto(serviço_de_quarto);
                p.setVista(vista);
                break;

            } 
    }
    }
    
    @Override
    public void add_repo(Object e) {
        if (e instanceof QuartoPremium){
        this.listaQuarto.add((QuartoPremium) e);
        }else if (e instanceof QuartoBasic){
          this.listaQuarto.add((QuartoBasic)e);  
        }
    }

    @Override
    public void excluir_repo(int e) {
        int id = e;
        int tamanhoQua = this.listaQuarto.size();
        for(int c = 0; c<tamanhoQua;c++){ 
            if(listaQuarto.get(c).getId_quarto()==id){
                this.listaQuarto.remove(c);    
                break;
            } 
        
    }
       
    }

    @Override
    public boolean consulta_repo(int e) {
        
    int id = e;
    int tamanhoLista = this.listaQuarto.size();
    for(int c = 0; c<tamanhoLista;c++){
        if(this.listaQuarto.get(c).getId_quarto()==id){
            return true;
        }
    }
    return false;
    }
 
    
}
