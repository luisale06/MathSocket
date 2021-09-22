/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathsocket;

import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class Reto extends Casilla {

    @Override
    public DoublyLinkedListObj accion(DoublyLinkedListObj l) {
        l.getNext();
        JOptionPane.showMessageDialog(null, "Cayo en Reto va avanzar una casilla");
        return l;

    }

}
