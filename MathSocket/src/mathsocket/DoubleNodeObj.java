package mathsocket;

public class DoubleNodeObj {
    private DoubleNodeObj prev;
    private DoubleNodeObj next;
    private Casilla det;

    public DoubleNodeObj(){
        this( null, null, null );
    }

    public DoubleNodeObj(Casilla deta){
        this(null, deta, null);
    }

    public DoubleNodeObj(DoubleNodeObj p, Casilla deta, DoubleNodeObj n){
        prev = p;
        next = n;
        det = deta;
    }

    public Casilla getObj(){
        return det;
    }

    public DoubleNodeObj getNext(){
        return next;
    }

    public DoubleNodeObj getPrev(){
        return prev;
    }

    public void setObj(Casilla deta){
        det = deta;
    }

    public void setNext(DoubleNodeObj n){
        next = n;
    }

    public void setPrev(DoubleNodeObj p){
        prev = p;
    }
}
