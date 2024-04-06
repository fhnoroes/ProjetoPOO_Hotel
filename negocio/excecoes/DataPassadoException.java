
package org.negocio.excecoes;



public class DataPassadoException extends Exception{
    public DataPassadoException(){
    super("Erro! Não é possível fazer reserva ´para uma data que já passou.");
    }
}
