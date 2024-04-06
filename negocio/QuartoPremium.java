
package org.negocio;



public class QuartoPremium extends Quarto {
    private boolean serviço_de_quarto;
    private boolean sauna;
    private boolean piscina;
    private boolean alimentação;
    private boolean vista;

    public QuartoPremium(int id_quarto,String estado, int capacidade, float preco,String andar,boolean serviço_de_quarto,boolean sauna,boolean piscina,boolean alimentação,boolean vista ) {
        super(id_quarto,estado, capacidade, preco, andar);
        this.serviço_de_quarto = serviço_de_quarto;
        this.sauna =sauna;
        this.piscina = piscina;
        this.alimentação = alimentação;
        this.vista = vista;
    }

   
    public boolean isVista() {
        return vista;
    }

    public void setVista(boolean vista) {
        this.vista = vista;
    }
   

    public boolean isAlimentação() {
        return alimentação;
    }

    public void setAlimentação(boolean alimentação) {
        this.alimentação = alimentação;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    public boolean isServiço_de_quarto() {
        return serviço_de_quarto;
    }

    public void setServiço_de_quarto(boolean serviço_de_quarto) {
        this.serviço_de_quarto = serviço_de_quarto;
    }

    public boolean isSauna() {
        return sauna;
    }

    public void setSauna(boolean sauna) {
        this.sauna = sauna;
    }
    
    
}
