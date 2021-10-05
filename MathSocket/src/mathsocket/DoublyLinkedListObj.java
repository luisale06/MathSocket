package mathsocket;

import java.io.Serializable;

/**
 * Esta clase se encarga de crear listas doblemente enlazadas de tal forma que estas
 * utilicen la clase DoubleNodeObj para crear la lista de objetos de tipo casilla.
 * Como utilizan los nodos dobles, estas listas están diseñadas para acceder a la
 * casilla siguiente y la anterior.
 * @author Luis Alejandro Barreda Acevedo
 * @see DoublyLinkedListObj
 */
public class DoublyLinkedListObj implements Serializable {

    private DoubleNodeObj head;
    private DoubleNodeObj tail;

    /**
     * Inicializa la lista doblemente enlazada
     */
    public DoublyLinkedListObj() {
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
     * @param det
     */
    public void addObjAtEnd(Casilla det) {
        DoubleNodeObj n = new DoubleNodeObj(tail, det, null);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
    }

    /**
     * Agrega un nodo con la instancia que contiene, al principio de la lista
     * @param det
     */
    public void addObjAtFront(Casilla det) {
        DoubleNodeObj n = new DoubleNodeObj(null, det, head);
        if (isEmpty()) {
            head = tail = n;
        } else {
            head.setPrev(n);
            head = n;
        }
    }

    /**
     * Retorna el contenido del nodo siguiente en la lista
     * @return
     */
    public Casilla getNext(){
        Casilla dato;
        if (head.getNext() !=null){
            //DoubleNode sig = head;
            dato = head.getNext().getObj();
            head = head.getNext();
        }
        else{
            dato = head.getObj();
        }
        return dato;
    }

    /**
     * Retorna el contenido del nodo previo en la lista
     * @return
     */
    public Casilla getPrev() {
        Casilla dato;
        if (head.getPrev() != null) {
            dato = head.getPrev().getObj();
            head = head.getPrev();

        } else {
            dato = head.getObj();
        }
        return dato;
    }

    /**
     * Adquiere el contenido del nodo en cuestión
     * @return
     */
    public Casilla getNode() {
        DoubleNodeObj cn = head;
        Casilla casilla = new Casilla();
        casilla = cn.getObj();
        return casilla;
    }

    /**
     * Imprime el tipo de casilla en cada posición de la lista, una por una
     */
    public void printList() {
        DoubleNodeObj cn = head;
        while (cn != null) {
            System.out.println(cn.getObj().getTipo());
            cn = cn.getNext();
        }
    }

    /**
     * Asigna la posición de cada casilla del 0 en adelante.
     * Se recomienda que esté ordenada antes de asignar posiciones
     */
    public void setPosition() {
        DoubleNodeObj cn = head;
        int count = 0;
        while (cn != null) {
            cn.getObj().setPos(count);
            cn = cn.getNext();
            count++;
        }
    }
}
