
package org.negocio;

public abstract class Quarto {
    protected int id_quarto;
    protected String estado;
    protected int capacidade;
    protected float preco;
    protected String andar;
    
    protected Quarto(int id_quarto,String estado, int capacidade, float preco, String andar) {
        this.id_quarto = id_quarto;
        this.estado = estado;
        this.capacidade = capacidade;
        this.preco = preco;
        this.andar = andar;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public float getPreco() {   
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(int id_quarto) {
        this.id_quarto = id_quarto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

@Override
public boolean equals(Object obj) {
    Quarto q = (Quarto) obj;
    if(this.id_quarto == q.getId_quarto()) {
		return true;
    }else {
        return false;
		}
	}
    
    
}
