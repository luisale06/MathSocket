package mathsocket;

import javax.swing.JOptionPane;
/**
 * Esta es uns subclase de casilla, la cual se le sobrescribe el metodo accion acorde a la función de las casilllas Tunel
 * @author Luis Pablo Céspedes Sequeira.
 * @see Tunel
 */
public class Tunel extends Casilla {
    /**
     * Metodo que instancia un nuemro aleatorio entre 1 y 3 que va indicar el numero de veces que avanza la posicion de la lista que guarda
     * el desplazamiento del jugador, se hace atra vez de un ciclo donde el numero aleatorio indica la cantidad de iteraciones
     */
    @Override
    public DoublyLinkedListObj accion(DoublyLinkedListObj l) {
        int m = (int) (Math.random() * (1 - 3) + 3);;
        int v = m;
        while (m > 0) {
            l.getNext();
            m--;
        }
        StringBuilder result = new StringBuilder();
        result.append("Esta casilla túnel le asigno avanzar:  ").append(System.lineSeparator());
        result.append(v).append(System.lineSeparator());
        JOptionPane.showMessageDialog(null, result.toString());
        return l;
    }
}
