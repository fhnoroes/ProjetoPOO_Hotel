
package org.negocio.excecoes;



public class ItemExisteException extends Exception{
    public ItemExisteException(){
        super("Já existe um item armazenado com o mesmo identificador");
    }
    
}
