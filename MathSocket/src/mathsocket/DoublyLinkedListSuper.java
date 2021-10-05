package mathsocket;

import java.io.Serializable;

/**
 * Esta clase se encarga de crear listas doblemente enlazadas de tal forma que estas
 * utilicen la clase DoubleNodeSuper para crear la lista de objetos de tipo DoublyLinkedListObj.
 * Como utilizan los nodos dobles, estas listas están diseñadas para acceder a la
 * lista siguiente y la anterior.
 * @author Luis Alejandro Barreda Acevedo
 * @see DoublyLinkedListSuper
 */
public class DoublyLinkedListSuper implements Serializable {
    private DoubleNodeSuper head;
    private DoubleNodeSuper tail;

    /**
     * Inicializa la lista doblemente enlazada
     */
    public DoublyLinkedListSuper() {
        head = null;
        tail = null;
    }

    /**
     * Verifica si la lista está vacía
     * @return
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Agrega un nodo con la instancia que contiene, al final de la lista
     * @param list
     */
    public void addListAtEnd(DoublyLinkedListObj list) {
        DoubleNodeSuper n = new DoubleNodeSuper(tail, list, null);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
    }

    /**
     * Elimina el nodo al principio de la lista
     * @return
     */
    public DoublyLinkedListObj removeListFromFront() {
        DoublyLinkedListObj lista = head.getList();
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.getNext();
                head.setPrev(null);
            }
        }
        return lista;
    }
}
