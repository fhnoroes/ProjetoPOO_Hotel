
package org.negocio.excecoes;




public class ItemNaoEncontradoException extends Exception{
    private int id;
    
    public ItemNaoEncontradoException(int id){
        super("Item com identificador: "+id+" não foi encontrado.");
        this.id =id;
    }

    public int getId() {
        return id;
    }
    
}
