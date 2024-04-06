
package org.dados;
import org.negocio.Funcionário;
import java.util.ArrayList;

public class Repo_Func extends Repositório{
    
    private ArrayList<Funcionário> funcs = new ArrayList();
    
     public Repo_Func() { 
    }
     
    public void atualiza_repo(int e, String nome,String data, char sexo, String cep,String usu, String senha,String estado) {
        int id = e;
        int tamanho = this.funcs.size();
        for(int c = 0; c<tamanho;c++){ 
            if(funcs.get(c).getCpf()==id){
                this.funcs.get(c).setNome(nome);
                this.funcs.get(c).setData_nascimento(data);
                this.funcs.get(c).setSexo(sexo);
                this.funcs.get(c).setCep(cep);
                this.funcs.get(c).setEstado(estado);
                this.funcs.get(c).setUsuário(usu);
                this.funcs.get(c).setSenha(senha);
                break;
            } 
    }
    }

    @Override
    public void add_repo(Object e){
        this.funcs.add((Funcionário) e);
      }
          

    @Override
    public void excluir_repo(int e) {
        int id = e;
        int tamanho = this.funcs.size();
        for(int c = 0; c<tamanho;c++){ 
            if(funcs.get(c).getCpf()==id){
                this.funcs.remove(c);
                break;
            } 
    } 
   
        }

    @Override
    public boolean consulta_repo(int e){
    int cpf = e;
    int tamanhoLista = this.funcs.size();
    for(int c = 0; c<tamanhoLista;c++){
        if(this.funcs.get(c).getCpf()==cpf){
           return true;
        }
    }
    return false;
    }

    public ArrayList<Funcionário> getFuncs() {
        return funcs;
    }

    
}
