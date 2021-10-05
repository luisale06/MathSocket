package mathsocket;

import java.io.Serializable;

/**
 * Esta clase se encarga de crear nodos de tal forma que estos puedan contener
 * objetos, específicamente instancias de la DoublyLinkedListObj. Además están diseñados
 * con un puntero al nodo siguiente, pero también al nodo previo.
 * @author Luis Alejandro Barreda Acevedo
 * @see DoubleNodeSuper
 */
public class DoubleNodeSuper implements Serializable {
    private DoubleNodeSuper prev;
    private DoubleNodeSuper next;
    private DoublyLinkedListObj list;

    /**
     * Este método crea una instancia del nodo con sus respectivos punteros y contenido
     * (Lista)
     * @param p
     * @param lista
     * @param n
     */
    public DoubleNodeSuper(DoubleNodeSuper p, DoublyLinkedListObj lista, DoubleNodeSuper n){
        prev = p;
        next = n;
        list = lista;
    }

    /**
     * Devuelve el objeto dentro del nodo
     * @return
     */
    public DoublyLinkedListObj getList(){
        return list;
    }

    /**
     * Devuelve el nodo asociado al puntero siguiente del nodo en cuestión
     * @return
     */
    public DoubleNodeSuper getNext(){
        return next;
    }

    /**
     * Devuelve el nodo asociado al puntero previo del nodo en cuestión
     * @return
     */
    public DoubleNodeSuper getPrev(){
        return prev;
    }

    /**
     * Cambia el nodo siguiente por el nodo solicitado
     * @param n
     */
    public void setNext(DoubleNodeSuper n){
        next = n;
    }

    /**
     * Cambia el nodo previo por el nodo solicitado
     * @param p
     */
    public void setPrev(DoubleNodeSuper p){
        prev = p;
    }
}
