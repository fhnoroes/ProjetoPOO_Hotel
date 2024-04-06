
package org.dados;



abstract class Repositório {
    
    
    protected Repositório(){
    }
    abstract void add_repo(Object e);
    abstract void excluir_repo(int e);
    abstract boolean consulta_repo(int e);
}
