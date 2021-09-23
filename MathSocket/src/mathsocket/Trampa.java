package mathsocket;

import javax.swing.JOptionPane;

public class Trampa extends Casilla {

    @Override
    public DoublyLinkedListObj accion(DoublyLinkedListObj l) {
        int m = (int) (Math.random() * (1 - 3) + 3);;
        int v = m;
        while (m > 0) {
            l.getPrev();
            m--;
        }
        StringBuilder result = new StringBuilder();
        result.append("Esta casilla trampa le asigno retroceder:  ").append(System.lineSeparator());
        result.append(v).append(System.lineSeparator());
        JOptionPane.showMessageDialog(null, result.toString());
        return l;
    }
}
