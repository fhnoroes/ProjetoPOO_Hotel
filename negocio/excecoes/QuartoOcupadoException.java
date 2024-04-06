
package org.negocio.excecoes;



public class QuartoOcupadoException extends Exception{
    private int id;
    private String checkout;
    private String checkin;

    public String getCheckout() {
        return checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public int getId() {
        return id;
    }

    public QuartoOcupadoException(int id,String checkin, String checkout){
        super("Quarto com id:  "+id+" está ocupado de "+checkin+" até "+checkout);
        this.id =id;
        this.checkin = checkin;
        this.checkout = checkout;
    }
    
}
