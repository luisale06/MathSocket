package mathsocket;

public class DoubleNodeSuper {
    private DoubleNodeSuper prev;
    private DoubleNodeSuper next;
    private DoublyLinkedListObj list;

    public DoubleNodeSuper(DoubleNodeSuper p, DoublyLinkedListObj lista, DoubleNodeSuper n){
        prev = p;
        next = n;
        list = lista;
    }

    public DoublyLinkedListObj getList(){
        return list;
    }

    public DoubleNodeSuper getNext(){
        return next;
    }

    public DoubleNodeSuper getPrev(){
        return prev;
    }

    public void setList(DoublyLinkedListObj lista){
        list = lista;
    }

    public void setNext(DoubleNodeSuper n){
        next = n;
    }

    public void setPrev(DoubleNodeSuper p){
        prev = p;
    }
}
