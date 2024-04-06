
package org.negocio;



public class Funcionário extends Pessoa{
    protected String estado;
    public Funcionário(int cpf, String nome, String data_nascimento, char sexo, String cep, String usuário, String senha, String estado) {
        super(cpf, nome, data_nascimento, sexo, cep, usuário, senha);
        this.estado =  estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
     
}
