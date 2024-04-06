
package org.negocio;



public abstract class Pessoa {
   protected int cpf;
   protected String nome;
   protected String data_nascimento;
   protected char sexo;
   protected String cep;
   protected String senha;
   protected String usuário;
   
   protected Pessoa(int cpf, String nome, String data_nascimento, char sexo, String cep, String usuário, String senha){
    this.cpf = cpf;
    this.nome = nome;
    this.data_nascimento = data_nascimento;
    this.sexo = sexo;
    this.cep = cep;
    this.usuário = usuário;
    this.senha = senha;    
   }
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }


   public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuário() {
        return usuário;
    }

    public void setUsuário(String usuário) {
        this.usuário = usuário;
    }
    
@Override
public boolean equals(Object obj) {
    Pessoa p = (Pessoa) obj;
    if(this.cpf == p.getCpf()) {
		return true;
    }else {
        return false;
		}
	}


}

