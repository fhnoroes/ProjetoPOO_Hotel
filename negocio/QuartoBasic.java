
package org.negocio;




public class QuartoBasic extends Quarto{
    
    private boolean alimentação;
    
    public QuartoBasic(int id_quarto, String estado, int capacidade, float preco,String andar, boolean alimentação) {
        super(id_quarto, estado, capacidade, preco, andar);
        this.alimentação =  alimentação;
    }

    public boolean isAlimentação() {
        return alimentação;
    }

    public void setAlimentação(boolean alimentação) {
        this.alimentação = alimentação;
    }


}
