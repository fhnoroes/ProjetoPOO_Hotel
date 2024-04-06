
package org.negocio;

import org.dados.Repo_Func;
import java.util.ArrayList;
import org.negocio.excecoes.*;
public class NegocioFunc {
    private Repo_Func repositório;
    
    public NegocioFunc(Repo_Func repositório){
        this.repositório = repositório;
    }
    
    public ArrayList<Funcionário> ver_func () throws RepoVazioException{
        ArrayList<Funcionário> lista = new ArrayList();
        lista = repositório.getFuncs();
        if (lista!=null){
            return lista;
        }else{
            throw new RepoVazioException();
        }
    }
    public boolean verificaLogin(String usu, String senha){
        int tamanho = repositório.getFuncs().size();
        for (int c=0; c<tamanho; c++){
            if(repositório.getFuncs().get(c).getUsuário().equals(usu) && repositório.getFuncs().get(c).getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
    public void atualiza_func (int e, String nome,String data, char sexo, String cep,String usu, String senha,String estado) throws ItemNaoEncontradoException{
        boolean existe = repositório.consulta_repo(e);
        if (existe){
            repositório.atualiza_repo(e, nome, data, sexo, cep, usu, senha, estado);
        }else{
            throw new ItemNaoEncontradoException(e);
        }
    }
    public void add_func(Funcionário f) throws ItemExisteException{
        boolean existe = repositório.consulta_repo(f.getCpf());
        if (existe){
            throw new ItemExisteException();
        }else{
            repositório.add_repo(f);
        }
    }
    
    public void excluir_func(int cpf) throws ItemNaoEncontradoException{
        boolean existe =  repositório.consulta_repo(cpf);
        if (existe){
            repositório.excluir_repo(cpf);   
        }else{
            throw new ItemNaoEncontradoException(cpf);
        }
    }
}
