package mathsocket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MathSocket {

    int mov;
    int mov2;
    public JFrame f = new JFrame("Tab");
    static JLabel casilla = new JLabel();
    static JLabel lDado = new JLabel();
    private final JButton b = new JButton("←");
    private final JButton c = new JButton("→");
    private final JButton d = new JButton("★");
    static JLabel casilla2 = new JLabel();
    static JLabel lDado2 = new JLabel();
    static JLabel primerjugador = new JLabel();
    static JLabel segundojugador = new JLabel();
    private final JButton b2 = new JButton("←");
    private final JButton c2 = new JButton("→");
    private final JButton d2 = new JButton("★");
    Tablero tablero3 = new Tablero();
    Lienzo panel = new Lienzo(tablero3.getTablero(),tablero3.getTablero());
    DoublyLinkedListObj Lista_J1 = new DoublyLinkedListObj();
    DoublyLinkedListObj Lista_J2 = new DoublyLinkedListObj();

    DoublyLinkedListSuper SUPERLISTA = new DoublyLinkedListSuper();

    Dado dado = new Dado();
    Dado dado2 = new Dado();
    MathSocket() {
        Tablero tablero = new Tablero();
        Tablero tablero2 = new Tablero();
        //DoublyLinkedListObj list = new DoublyLinkedListObj();
        // list = tablero.getTablero();
        Lista_J1 = tablero.getTablero();
        Lista_J2 = tablero2.getTablero();
        Lista_J1.SetJugador("J1");
        Lista_J1.SetJugador("J2");
        randomCasillas superlist = new randomCasillas();
        DoublyLinkedListSuper list = new DoublyLinkedListSuper();
        SUPERLISTA = superlist.getSuperList();
    }

    public void inter(String nombre1, String nombre2) {
        casilla.setHorizontalAlignment(JLabel.CENTER);
        casilla.setSize(45, 20);
        casilla.setLocation(600, 90);
        lDado.setHorizontalAlignment(JLabel.CENTER);
        lDado.setSize(50, 50);
        lDado.setLocation(600, 150);
        casilla2.setHorizontalAlignment(JLabel.CENTER);
        casilla2.setSize(45, 20);
        casilla2.setLocation(600, 490);
        lDado2.setHorizontalAlignment(JLabel.CENTER);
        lDado2.setSize(50, 50);
        lDado2.setLocation(600, 550);

        primerjugador.setText(nombre1);
        primerjugador.setSize(45, 20);
        primerjugador.setLocation(0, 10);

        segundojugador.setText(nombre2);
        segundojugador.setSize(45, 20);
        segundojugador.setLocation(0, 0);

        f.setSize(800, 800);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.setBounds(600, 110, 45, 20);
        c.setBounds(650, 110, 45, 20);
        d.setBounds(630, 190, 45, 20);
        b2.setBounds(600, 510, 45, 20);
        c2.setBounds(650, 510, 45, 20);
        d2.setBounds(630, 590, 45, 20);
        panel.setSize(390, 390);
        f.add(casilla);
        f.add(lDado);
        f.add(b);
        f.add(c);
        f.add(d);
        f.add(casilla2);
        f.add(lDado2);
        f.add(b2);
        f.add(c2);
        f.add(d2);
        f.add(primerjugador);
        f.add(segundojugador);
        f.add(panel);
        casilla.setText(Lista_J1.getNode().getTipo());
        casilla2.setText(Lista_J2.getNode().getTipo());
        lDado.setText("Dado");
        lDado2.setText("Dado");
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                avanzar(mov, Lista_J1);
                Casilla aux = new Casilla();
                aux = Lista_J1.getNode();
                casilla.setText(aux.getTipo());
                System.out.println(aux.getPos());
                panel.SetPosAvatar(aux.getPos());
                panel.move();
                panel.repaint();
                jugada(aux);
            }
        });
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retroceder(mov, Lista_J1);
                Casilla aux = new Casilla();
                aux = Lista_J1.getNode();
                casilla.setText(aux.getTipo());
                System.out.println(aux.getPos());
                panel.SetPosAvatar(aux.getPos());
                panel.move();
                panel.repaint();
                //jugada(aux);
            }
        });
        d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mov = dado.getDado();
                lDado.setText("" + mov);
            }
        });
        c2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                avanzar(mov2, Lista_J2);
                Casilla aux = new Casilla();
                aux = Lista_J2.getNode();
                casilla2.setText(aux.getTipo());
                System.out.println(aux.getPos());
                panel.SetPosAvatar2(aux.getPos());
                panel.move2();
                panel.repaint();
                //jugada(aux);
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retroceder(mov2, Lista_J2);
                Casilla aux = new Casilla();
                aux = Lista_J2.getNode();
                casilla2.setText(aux.getTipo());
                System.out.println(aux.getPos());
                panel.SetPosAvatar2(aux.getPos());
                panel.move2();
                panel.repaint();
                //jugada(aux);
            }
        });
        d2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mov2 = dado2.getDado();
                lDado2.setText("" + mov2);
            }
        });
    }
    public void cambio(String str) {
        casilla.setText("" + str);
    }
    public void jugada(Casilla c) {

        if (c.getTipo() == "Reto") {
            /** JOptionPane.showMessageDialog(null, c.getTipo());
             Lista_J1 = c.accion(Lista_J1);
             Casilla aux = new Casilla();
             aux = Lista_J1.getNode();
             casilla.setText(aux.getTipo());
             System.out.println(aux.getPos());
             panel.SetPosAvatar(aux.getPos());
             panel.move();
             panel.repaint();  */


        }
        if (c.getTipo() == "Trampa") {
            JOptionPane.showMessageDialog(null, c.getTipo());
            Lista_J1 = c.accion(Lista_J1);
            Casilla aux = new Casilla();
            aux = Lista_J1.getNode();
            casilla.setText(aux.getTipo());
            System.out.println(aux.getPos());
            panel.SetPosAvatar(aux.getPos());
            panel.move();
            panel.repaint();
        }
        if (c.getTipo() == "Túnel") {
            /**JOptionPane.showMessageDialog(null, c.getTipo());
             Lista_J1 = c.accion(Lista_J1);
             Casilla aux = new Casilla();
             aux = Lista_J1.getNode();
             casilla.setText(aux.getTipo());
             System.out.println(aux.getPos());
             panel.SetPosAvatar(aux.getPos());
             panel.move();
             panel.repaint();
             */
            /**
             * list.getNext(); list.getNext();
             * panel.SetPosAvatar(list.getNode().getPos()); panel.move();
             * panel.repaint();
             */
        }
    }

    public void avanzar(int a, DoublyLinkedListObj l) {
        while (a != 0) {
            l.getNext();
            a--;
        }

    }

    public void retroceder(int r, DoublyLinkedListObj l) {
        while (r != 0) {
            l.getPrev();
            r--;
        }
    }
    public void avanzar2(int a, DoublyLinkedListObj l) {
        while (a != 0) {
            l.getNext();
            a--;
        }

    }

    public void retroceder2(int r, DoublyLinkedListObj l) {
        while (r != 0) {
            l.getPrev();
            r--;
        }
    }
    
    //public static void main(String[] args) {}
}
