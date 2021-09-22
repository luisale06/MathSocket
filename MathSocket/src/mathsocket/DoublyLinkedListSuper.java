package mathsocket;

public class DoublyLinkedListSuper {
    private DoubleNodeSuper head;
    private DoubleNodeSuper tail;

    public DoublyLinkedListSuper() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }


    public void addListAtEnd(DoublyLinkedListObj list) {
        DoubleNodeSuper n = new DoubleNodeSuper(tail, list, null);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
    }

    public void addListAtFront(DoublyLinkedListObj list) {
        DoubleNodeSuper n = new DoubleNodeSuper(null, list, head);
        if (isEmpty()) {
            head = tail = n;
        } else {
            head.setPrev(n);
            head = n;
        }
    }

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

    public DoublyLinkedListObj removeListAtEnd() {
        DoublyLinkedListObj lista = tail.getList();

        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.getPrev();
                tail.setNext(null);
            }
        }

        return lista;
    }

    public DoublyLinkedListObj getListAtFront() {
        if (isEmpty()) {
            return null;
        } else {
            return head.getList();
        }
    }

    public int countBNodesObj() {
        DoubleNodeSuper cn = head;
        int count = 0;
        while (cn != null) {
            count++;
            cn = cn.getNext();
        }
        return count;
    }

    public void printSuperList() {
        DoubleNodeSuper cn = head;
        while (cn != null) {
            System.out.println("_________________________");
            cn.getList().printList();
            cn = cn.getNext();
        }
    }

    public DoublyLinkedListObj getNext() {
        DoublyLinkedListObj dato;
        if (head.getNext() != null) {
            //DoubleNode sig = head;
            dato = head.getNext().getList();
            head = head.getNext();

        } else {
            dato = head.getList();
        }
        return dato;

    }

    public DoublyLinkedListObj getPrev() {
        DoublyLinkedListObj dato;
        if (head.getPrev() != null) {
            dato = head.getPrev().getList();
            //DoubleNode sig = head;
            head = head.getPrev();

        } else {
            dato = head.getList();
        }
        return dato;
    }

    public DoublyLinkedListObj getNode() {
        DoubleNodeSuper cn = head;
        DoublyLinkedListObj lista = new DoublyLinkedListObj();
        lista = cn.getList();
        return lista;
    }
    /*public static void main(String args[]) {
        randomCasillas lista = new randomCasillas();
        DoublyLinkedListObj lista1 = lista.generaRandomCasillas();
        DoublyLinkedListObj lista2 = lista1;

        DoublyLinkedListSuper superlista = new DoublyLinkedListSuper();
        superlista.addListAtEnd(lista1);
        superlista.addListAtEnd(lista2);

        superlista.printSuperList();
    }*/
}
