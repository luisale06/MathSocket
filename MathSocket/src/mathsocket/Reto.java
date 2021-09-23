package mathsocket;

import javax.swing.JOptionPane;

public class Reto extends Casilla {

    @Override
    public DoublyLinkedListObj accion(DoublyLinkedListObj l) {
        l.getNext();
        JOptionPane.showMessageDialog(null, "Cayo en Reto va avanzar una casilla");
        return l;

    }

}
