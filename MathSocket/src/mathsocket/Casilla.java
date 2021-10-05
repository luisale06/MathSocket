package mathsocket;

import java.io.Serializable;
/**
 * Esta es la clase generica "Casilla" y hereda a "Reto", "Trampa" y "Túnel"
 * Es una forma de declarar los parametros de distintos metodos y asi poder recibir cualquier tipo de casilla sin epecificar
 * su subclase.
 * @author Luis Pablo Céspedes Sequeira.
 * @see Casilla
 */

/**
 * Esta clase contiene como atributos un entero que va indicar la posicion en el tablero de la casilla y un String
 * que indica el tipo de casilla, ambos se agregan a la hora de construir la lista doble enlazada, que guarda las casillas
 */
public class Casilla implements Serializable {

    private String tipo;
    private int pos;
    /**
     * Metodo que agrega el String que indica el tipo de casilla
     */
    public void setTipo(String type) {
        this.tipo = type;
    }
    /**
     * Metodo que retorna el tipo de casilla
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * Metodo que agregala posición de la casilla en el tablero
     */
    public void setPos(int p) {
        this.pos = p;
    }
    /**
     * Metodo que retorna la posicion de la casilla en el tablero
     */
    public int getPos() {
        return pos;
    }
    /**
     * Es un Metodo que varia en cada tipo de Casilla pero en todas retorna la lista recorriendola segun la funcion de cada una
     */
    public DoublyLinkedListObj accion(DoublyLinkedListObj l) {
        return l;
    }
}
