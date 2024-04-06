
package org.negocio;

import org.dados.Repo_Quarto;
import java.util.ArrayList;
import org.negocio.excecoes.*;
public class NegocioQuarto {
    private Repo_Quarto repositório;
    
    public NegocioQuarto(Repo_Quarto repositório){
        this.repositório = repositório;
    }
    public ArrayList<Quarto> consulta_quartos() throws RepoVazioException{
        ArrayList<Quarto> lista = new ArrayList();
        lista = repositório.getListaQuarto();
        if (lista!=null){
            return lista;
        }else{
            throw new RepoVazioException();
        }
    }
    
 
    public void acrescimo(Quarto q){
        if(q instanceof QuartoBasic){
            float acres = 20.0f; 
            if(((QuartoBasic) q).isAlimentação()==true){
                q.setPreco(q.getPreco()+acres);
                 }
               
        }else{
        float valor= 0.0f;
        if(((QuartoPremium)q).isAlimentação()==true){
            valor += 25.0f;
        }
        if(((QuartoPremium)q).isPiscina() == true){
            valor += 15.0f;
        }
        if(((QuartoPremium)q).isSauna()==true){
            valor += 20.0f;
        }
        if(((QuartoPremium)q).isServiço_de_quarto()==true){
            valor += 15.0f;
        }
        if(((QuartoPremium)q).isVista()==true){
            valor += 10.0f;
        }
        q.setPreco(q.getPreco()+valor); 
        }
        
   
    }
    
    public String tipo_quarto(int id){
      int tamanho = repositório.getListaQuarto().size();
            for(int c=0;c<tamanho;c++){
                if(repositório.getListaQuarto().get(c).getId_quarto()==id){
                    if(repositório.getListaQuarto().get(c) instanceof QuartoPremium){
                        return "premium";
                    }else{
                        return "basic";
                    }
               
                }  
    }
            return "sem tipo";
    }
    
    public void altera_quartoPremium(int id_quarto, String estado, int capacidade, float preco,String andar,boolean serviço_de_quarto,boolean sauna,boolean piscina,boolean alimentação,boolean vista) throws ItemNaoEncontradoException{
        boolean existe = repositório.consulta_repo(id_quarto);
        if(existe){
            repositório.atualizaPremium_repo(id_quarto, estado,  capacidade,  preco, andar, serviço_de_quarto, sauna, piscina, alimentação, vista);
            int tamanho = repositório.getListaQuarto().size();
            for(int c=0;c<tamanho;c++){
                if(repositório.getListaQuarto().get(c).getId_quarto()==id_quarto){
                    this.acrescimo(repositório.getListaQuarto().get(c));
                }
            }  
        }else{
            throw new ItemNaoEncontradoException(id_quarto);
        }
    }
    
     public void altera_quartoBasic(int id_quarto, String estado, int capacidade, float preco,String andar,boolean alimentação) throws ItemNaoEncontradoException{
        boolean existe = repositório.consulta_repo(id_quarto);
        if(existe){
            repositório.atualizaBasic_repo(id_quarto, estado,  capacidade,  preco, andar, alimentação);
            int tamanho = repositório.getListaQuarto().size();
            for(int c=0;c<tamanho;c++){
                if(repositório.getListaQuarto().get(c).getId_quarto()==id_quarto){
                    this.acrescimo(repositório.getListaQuarto().get(c));
                }
            }  
        }else{
            throw new ItemNaoEncontradoException(id_quarto);
        }
    }
    
    public void add_quarto(Quarto q) throws ItemExisteException{
        this.acrescimo(q);
        boolean existe = repositório.consulta_repo(q.getId_quarto());
        if (existe){
            throw new ItemExisteException();
        }else{
            repositório.add_repo(q);
        }
    }
    
    public void excluir_quarto(int id) throws ItemNaoEncontradoException{
        boolean existe =  repositório.consulta_repo(id);
        if (existe){
            repositório.excluir_repo(id);
        }else{
            throw new ItemNaoEncontradoException(id);
        }
    }
    
    
}
