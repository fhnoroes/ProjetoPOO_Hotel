
package org.negocio;



public class Cliente extends Pessoa {
    private int cartao;
    public Cliente(int cpf, String nome, String data_nascimento, char sexo, String cep, String usuário, String senha, int cartao) {
        super(cpf, nome, data_nascimento, sexo, cep, usuário, senha);
        this.cartao = cartao;
    }

    public int getCartao() {
        return cartao;
    }

    public void setCartao(int cartao) {
        this.cartao = cartao;
    }

}
