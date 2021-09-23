package mathsocket;

import javax.swing.JOptionPane;

public class Tunel extends Casilla {

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
