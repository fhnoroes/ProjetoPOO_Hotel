
package org.negocio;



import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.negocio.excecoes.*;
public class Reserva {
    private static int contador = 0 ;
    int cod_reserva;
    private String data_checkin;
    private String data_checkout;
    private int cpf;
    private int id_quarto;
    private float preco;
    
    public Reserva(String data_checkin, String data_checkout, int cpf, int id_quarto) throws DataException{
       String formatoData = "\\d{2}-\\d{2}-\\d{4}";
       Pattern pattern = Pattern.compile(formatoData);
       Matcher matcher = pattern.matcher(data_checkin);
       Matcher matcher2 = pattern.matcher(data_checkout);
       if (matcher.matches()) {
        this.data_checkin = data_checkin;
        } else {
            throw new DataException();
        }
       if (matcher2.matches()) {
        this.data_checkout = data_checkout;
        } else {
            throw new DataException();
        }
       this.cod_reserva = ++contador;
       this.cpf = cpf;
       this.id_quarto = id_quarto;
       this.preco=0.0f;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getData_checkin() {
        return data_checkin;
    }

    public void setData_checkin(String data_checkin) {
        this.data_checkin = data_checkin;
    }

    public String getData_checkout() {
        return data_checkout;
    }

    public void setData_checkout(String data_checkout) {
        this.data_checkout = data_checkout;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(int id_quarto) {
        this.id_quarto = id_quarto;
    }

    public int getCod_reserva() {
        return cod_reserva;
    }

    public void setCod_reserva(int cod_reserva) {
        this.cod_reserva = cod_reserva;
    }


    @Override
public boolean equals(Object obj) {
    Reserva q = (Reserva) obj;
    if(this.cod_reserva== q.getCod_reserva()) {
		return true;
    }else {
        return false;
		}
	}
    
}
