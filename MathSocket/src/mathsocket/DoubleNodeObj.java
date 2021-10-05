package mathsocket;

import java.io.Serializable;

/**
 * Esta clase se encarga de crear nodos de tal forma que estos puedan contener
 * objetos, específicamente instancias de la clase casilla. Además están diseñados
 * con un puntero al nodo siguiente, pero también al nodo previo.
 * @author Luis Alejandro Barreda Acevedo
 * @see DoubleNodeObj
 */
public class DoubleNodeObj implements Serializable {
    private DoubleNodeObj prev;
    private DoubleNodeObj next;
    private Casilla det;

    /**
     * Este método crea una instancia del nodo con sus respectivos punteros y contenido
     * (Casilla)
     * @param p
     * @param deta
     * @param n
     */
    public DoubleNodeObj(DoubleNodeObj p, Casilla deta, DoubleNodeObj n){
        prev = p;
        next = n;
        det = deta;
    }

    /**
     * Devuelve el objeto dentro del nodo
     * @return
     */
    public Casilla getObj(){
        return det;
    }

    /**
     * Devuelve el nodo asociado al puntero siguiente del nodo en cuestión
     * @return
     */
    public DoubleNodeObj getNext(){
        return next;
    }

    /**
     * Devuelve el nodo asociado al puntero previo del nodo en cuestión
     * @return
     */
    public DoubleNodeObj getPrev(){
        return prev;
    }

    /**
     * Cambia el nodo siguiente por el nodo solicitado
     * @param n
     */
    public void setNext(DoubleNodeObj n){
        next = n;
    }

    /**
     * Cambia el nodo previo por el nodo solicitado
     * @param p
     */
    public void setPrev(DoubleNodeObj p){
        prev = p;
    }
}