
package org.dados;

import java.util.ArrayList;
import org.negocio.Cliente;
public class Repo_Cliente implements IRepositório{
private ArrayList<Cliente> clientes = new ArrayList();

   

public Repo_Cliente(){
}

 public ArrayList<Cliente> getClientes() {
        return clientes;
    }

public void atualiza_repo(int e, String nome,String data, char sexo, String cep,String usu, String senha,int cartao){
    int id = e;
        int tamanho = this.clientes.size();
        for(int c = 0; c<tamanho;c++){ 
            if(clientes.get(c).getCpf()==id){
                this.clientes.get(c).setNome(nome);
                this.clientes.get(c).setData_nascimento(data);
                this.clientes.get(c).setSexo(sexo);
                this.clientes.get(c).setCep(cep);
                this.clientes.get(c).setCartao(cartao);
                this.clientes.get(c).setUsuário(usu);
                this.clientes.get(c).setSenha(senha);
                break;
            } 
    }
}

@Override
public void add_repo(Object e) {
        this.clientes.add((Cliente) e);
}

@Override
public void excluir_repo(int e){
    
        int id = e;
        int tamanho = this.clientes.size();
        for(int c = 0; c<tamanho;c++){ 
            if(clientes.get(c).getCpf()==id){
                this.clientes.remove(c);
                break;
            } 
            }

    }


@Override
public boolean consulta_repo(int e) {
    int cpf = e;
    int tamanhoLista = this.clientes.size();
    for(int c = 0; c<tamanhoLista;c++){
        if(this.clientes.get(c).getCpf()==cpf){
            return true;
        }
    }
    return false;
    }
}

