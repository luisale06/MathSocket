package mathsocket;

public class DoublyLinkedListObj {

    private DoubleNodeObj head;
    private DoubleNodeObj tail;
    private String jugador;
    /**
     * Constructs a new DoublyLinkedList object with head and tail as null.
     */
    public DoublyLinkedListObj() {
        head = null;
        tail = null;

    }

    /**
     * Returns true if the list is empty false otherwise
     *
     * @return true if the list empty false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Add a character BNode containing the character c to the end of the linked
     * list. This routine does not require a search.
     *
     * @param det a single character
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
     * Add a character BNode containing the character c to the front of the
     * linked list. No search is required.
     *
     * @param det a single character
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
     * Remove and return the character at the front of the doubly linked list.
     *
     * @return the character at the front precondition: the list is not empty
     */
    public Casilla removeObjFromFront() {
        Casilla deta = head.getObj();
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.getNext();
                head.setPrev(null);
            }
        }
        return deta;
    }

    /**
     * Remove and return the character at the end of the doubly linked list. No
     * searching is required.
     *
     * @return the character at the end precondition: the list is not empty
     */
    public Casilla removeObjAtEnd() {
        Casilla deta = tail.getObj();

        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.getPrev();
                tail.setNext(null);
            }
        }

        return deta;
    }

    /**
     * Counts the number of BNodes in the list. We are not maintaining a counter
     * so a search is required.
     *
     * @return the number of BNodes in the doubly linked list between head and
     * tail inclusive
     */
    public int countBNodesObj() {
        DoubleNodeObj cn = head;
        int count = 0;
        while (cn != null) {
            count++;
            cn = cn.getNext();
        }
        return count;
    }

    /**
     * Reverse the list. a -> b -> c becomes c -> b -> a
     */
    public void reverse() {
        DoubleNodeObj cn = head;
        DoubleNodeObj tmp;

        while (cn != null) {
            tmp = cn.getNext();
            cn.setNext(cn.getPrev());
            cn.setPrev(tmp);

            cn = cn.getPrev();
        }
        tmp = head;
        head = tail;
        tail = tmp;
        head.setPrev(null);
        tail.setNext(null);
    }
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
    public Casilla getPrev() {
        Casilla dato;
        if (head.getPrev() != null) {
            dato = head.getPrev().getObj();
            //DoubleNode sig = head;
            head = head.getPrev();

        } else {
            dato = head.getObj();
        }
        return dato;
    }

    public Casilla getNode() {
        DoubleNodeObj cn = head;
        Casilla casilla = new Casilla();
        casilla = cn.getObj();
        return casilla;
    }

    public Casilla getObjAtFront() {
        if (isEmpty()) {
            return null;
        } else {
            return head.getObj();
        }
    }

    public void printList() {
        DoubleNodeObj cn = head;
        while (cn != null) {
            System.out.println(cn.getObj().getTipo());
            cn = cn.getNext();
        }
    }

    public void setPosition() {
        DoubleNodeObj cn = head;
        int count = 1;
        while (cn != null) {
            cn.getObj().setPos(count);
            cn = cn.getNext();
            count++;
        }
    }

    public void SetJugador(String str) {
        jugador = str;

    }

    public String GetJugador() {
        return jugador;

    }
}
