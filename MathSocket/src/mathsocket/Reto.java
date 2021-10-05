package mathsocket;

import javax.swing.JOptionPane;
/**
 * Esta es uns subclase de casilla, la cual se le sobrescribe el metodo accion acorde a la función de las casilllas Reto
 * @author Luis Pablo Céspedes Sequeira.
 * @see Reto
 */
public class Reto extends Casilla {
    /**
     * Metodo que hace avanzar una posicion en la lista enlazada que almacena el desplazamiento del jugador en el tablero
     */
    @Override
    public DoublyLinkedListObj accion(DoublyLinkedListObj l) {
        l.getNext();
        JOptionPane.showMessageDialog(null, "Cayo en Reto va avanzar una casilla");
        return l;

    }

}
