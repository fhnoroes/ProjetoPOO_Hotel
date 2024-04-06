
package org.negocio;

import org.dados.Repo_Cliente;
import java.util.ArrayList;
import org.negocio.excecoes.*;
public class NegocioCliente {
    private Repo_Cliente repositório;
    
    public NegocioCliente(Repo_Cliente repositório){
        this.repositório = repositório;
    }
    public ArrayList<Cliente> ver_clientes() throws RepoVazioException{
        ArrayList<Cliente> lista = new ArrayList();
        lista = repositório.getClientes();
        if (lista!=null){
            return lista;
        }else{
            throw new RepoVazioException();
        }
}
     public boolean verificaLogin(String usu, String senha){
        int tamanho = repositório.getClientes().size();
        for (int c=0; c<tamanho; c++){
            if(repositório.getClientes().get(c).getUsuário().equals(usu) && repositório.getClientes().get(c).getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
     public void atualiza_cliente (int e, String nome,String data, char sexo, String cep,String usu, String senha,int cartao) throws ItemNaoEncontradoException{
        boolean existe = repositório.consulta_repo(e);
        if (existe){
            repositório.atualiza_repo(e, nome, data, sexo, cep, usu, senha, cartao);
        }else{
            throw new ItemNaoEncontradoException(e);
        }
    }
    public void add_cliente(Cliente c) throws ItemExisteException{
        boolean existe = repositório.consulta_repo(c.getCpf());
        if (existe){
            throw new ItemExisteException();
        }else{
            repositório.add_repo(c);
        }
    }
    
    public void excluir_cliente(int id) throws ItemNaoEncontradoException{
        boolean existe =  repositório.consulta_repo(id);
        if (existe){
            repositório.excluir_repo(id);   
        }else{
            throw new ItemNaoEncontradoException(id);
        }
    }
}
