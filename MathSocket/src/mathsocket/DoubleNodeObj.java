package mathsocket;

public class DoubleNodeObj {
    private DoubleNodeObj prev;
    private DoubleNodeObj next;
    private Casilla det;

    /**
     * Constructor with no arguments.
     */
    public DoubleNodeObj(){
        this( null, null, null );
    }

    /**
     * Constructor with a character
     * @param deta is a class for this BNode.
     */
    public DoubleNodeObj(Casilla deta){
        this(null, deta, null);
    }

    /**
     * Constructor with three arguments
     * @param p is a pointer to a previous BNode.
     * @param deta is a class for this BNode.
     * @param n is a pointer to a next BNode.
     */
    public DoubleNodeObj(DoubleNodeObj p, Casilla deta, DoubleNodeObj n){
        prev = p;
        next = n;
        det = deta;
    }

    /**
     * @return c a character for this BNode.
     */
    public Casilla getObj(){
        return det;
    }

    /**
     * @return a pointer to the next BNode or null if none exists
     */
    public DoubleNodeObj getNext(){
        return next;
    }

    /**
     * @return a pointer to the previous BNode or null if none exists
     */
    public DoubleNodeObj getPrev(){
        return prev;
    }

    /**
     * @param deta is assigned to this BNode
     */
    public void setObj(Casilla deta){
        det = deta;
    }

    /**
     * @param n
     */
    public void setNext(DoubleNodeObj n){
        next = n;
    }

    /**
     * @param p
     */
    public void setPrev(DoubleNodeObj p){
        prev = p;
    }
}