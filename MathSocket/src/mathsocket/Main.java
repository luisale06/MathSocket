package mathsocket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase contiene los métodos necesarios para ejecutar el programa desde cero
 * @author Luis Alejandro Barreda Acevedo
 * @see Main
 */
public class Main {
    JFrame frame;
    JButton inicio;
    randomCasillas random = new randomCasillas();
    DoublyLinkedListSuper superlist1 = new DoublyLinkedListSuper();
    DoublyLinkedListSuper superlist2 = new DoublyLinkedListSuper();

    /**
     * Este método se encarga de crear el JFrame y agregarle los JButtons, JLabels y demás
     * objetos que permiten la correcta visualización de la aplicación. Esta interfaz es
     * sencilla, solo se utiliza para ejecutar ambos tableros a la vez. Más adelante se explica
     * el funcionamiento de la clase randomCasillas, sin embargo en esta clase se le asignan
     * 4 de estas al primer tablero y las otras 4 al otro tablero.
     */
    public void start(){
        frame = new JFrame();
        frame.setSize(250, 100);
        frame.setLocation(400, 200);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("MathSocket");
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicio = new JButton("Inicio");
        inicio.setBounds(40, 25, 90, 20);
        inicio.setBackground(Color.lightGray);
        inicio.setForeground(Color.darkGray);
        frame.add(inicio);

        superlist1 = random.getSubLista1();
        superlist2 = random.getSubLista2();

        inicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Client client = new Client();
                client.start(superlist1);
                Server server = new Server();
                server.start(superlist2);
                inicio.setEnabled(false);
            }
        });
    }

    /**
     * Método que inicia la aplicación
     * @param args
     */
    public static void main(String args[]){
        Main main = new Main();
        main.start();
    }
}
