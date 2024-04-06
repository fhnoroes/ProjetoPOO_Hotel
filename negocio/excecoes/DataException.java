
package org.negocio.excecoes;



public class DataException extends Exception {
    public DataException(){
        super("Erro data inválida! Coloque no formato dd-mm-aaaa e verifique se o checkin é anterior ao checkout");
    }
}
