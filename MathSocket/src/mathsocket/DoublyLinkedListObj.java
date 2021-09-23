package mathsocket;

public class DoublyLinkedListObj {

    private DoubleNodeObj head;
    private DoubleNodeObj tail;
    private String jugador;
    
    public DoublyLinkedListObj() {
        head = null;
        tail = null;

    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addObjAtEnd(Casilla det) {
        DoubleNodeObj n = new DoubleNodeObj(tail, det, null);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
    }

    public void addObjAtFront(Casilla det) {
        DoubleNodeObj n = new DoubleNodeObj(null, det, head);
        if (isEmpty()) {
            head = tail = n;
        } else {
            head.setPrev(n);
            head = n;
        }
    }

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

    public int countBNodesObj() {
        DoubleNodeObj cn = head;
        int count = 0;
        while (cn != null) {
            count++;
            cn = cn.getNext();
        }
        return count;
    }

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
        int count = 0;
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
