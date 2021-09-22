package mathsocket;

import java.io.Serializable;

public class Casilla implements Serializable {

    /**
     * Variables that are going to be saved
     */
    private String tipo;
    private int pos;

    /**
     * Set y get al tipo
     */
    public void setTipo(String type) {
        this.tipo = type;
    }

    public String getTipo() {
        return tipo;
    }

    public void setPos(int p) {
        this.pos = p;
    }

    public int getPos() {
        return pos;
    }

    public DoublyLinkedListObj accion(DoublyLinkedListObj l) {
        System.out.println("rrrrrrrrrrrr");
        return l;
    }
}
