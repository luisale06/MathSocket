package mathsocket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Ventana principal donde se ejecuta el juego. Se comunica mediante sockets con
 * la ventana del contrincante. Dichos sockets abren distintos puertos, todos con
 * una función diferente sobre el tablero.
 * @author Luis Alejandro Barreda Acevedo
 * @see MathSocketJ2
 */
public class MathSocketJ2 {

    int mov;
    int cantflujos;
    int cantflujos2;
    double resultado_final;

    //Frame
    public JFrame f = new JFrame("Jugador 2");

    //TextField
    public JTextField t = new JTextField();

    //Labels
    static JLabel casilla = new JLabel();
    static JLabel lDado = new JLabel();
    static JLabel tu = new JLabel();
    static JLabel contrincante = new JLabel();
    static JLabel operando_1 = new JLabel();
    static JLabel operando_2 = new JLabel();
    static JLabel operacion = new JLabel();

    //Buttons
    private final JButton turno = new JButton("Finalizar Turno");
    public JButton b1 = new JButton("1");
    public JButton b2 = new JButton("2");
    public JButton b3 = new JButton("3");
    public JButton b4 = new JButton("4");
    public JButton b5 = new JButton("5");
    public JButton b6 = new JButton("6");
    public JButton b7 = new JButton("7");
    public JButton b8 = new JButton("8");
    public JButton b9 = new JButton("9");
    public JButton b0 = new JButton("0");
    public JButton bdel = new JButton("<");
    public JButton bpun = new JButton(".");
    public JButton bclr = new JButton("Responder");
    public JButton benviar_r = new JButton("Enviar Reto");
    public JButton dice = new JButton("\uD83C\uDFB2"); //DADO
    public JButton emparejar = new JButton("Emparejar");

    //ComboBox
    public String operadores[] = {"+", "-", "×", "÷"};
    public JComboBox cb = new JComboBox(operadores);

    //Font
    public Font font, font2;

    Lienzo panel;
    DoublyLinkedListObj Lista_J1;
    DoublyLinkedListObj Lista_J2;

    DoublyLinkedListObj lista1;
    DoublyLinkedListObj lista2;
    DoublyLinkedListObj lista3;
    DoublyLinkedListObj lista4;

    Dado dado = new Dado();
    Thread prep, prepreto, prepempareja;

    /**
     * Adquiere el nombre del jugador y del contrincante, enviados por la ventana de menú principal
     * para poder utilizarlos en esta interfaz. Además de la copia de las listas enlazadas que
     * controlan el comportamiento del juego. Mediante comandos controla las características de cada
     * objeto (JButton, JLabel, etc.) para después añadirlas al JFrame y que se pueda visualizar
     * la aplicación. Utiliza la clase lienzo para generar el tablero con base en la lista doblemente
     * enlazada con las casillas previamente barajadas en randomCasillas
     * @param jugador
     * @param rival
     * @param superlist2
     */
    public void inter(String jugador, String rival, DoublyLinkedListSuper superlist2) {

        font = new Font("", Font.PLAIN, 35);

        lista1 = superlist2.removeListFromFront();
        lista2 = superlist2.removeListFromFront();
        lista3 = superlist2.removeListFromFront();
        lista4 = superlist2.removeListFromFront();

        panel = new Lienzo(lista3, lista4);
        Lista_J1 = lista1;
        Lista_J2 = lista2;

        casilla.setHorizontalAlignment(JLabel.CENTER);
        casilla.setSize(75, 20);
        casilla.setLocation(760, 75);
        casilla.setFont(font2 = new Font("", Font.PLAIN, 17));
        casilla.setBackground(Color.yellow);
        casilla.setOpaque(true);
        lDado.setHorizontalAlignment(JLabel.CENTER);
        lDado.setSize(45, 20);
        lDado.setLocation(760, 160);
        lDado.setFont(font2 = new Font("", Font.PLAIN, 17));
        lDado.setBackground(Color.yellow);
        lDado.setOpaque(true);
        operando_2.setHorizontalAlignment(JLabel.CENTER);
        operando_2.setSize(15, 20);
        operando_2.setLocation(825, 295);
        operando_1.setHorizontalAlignment(JLabel.CENTER);
        operando_1.setSize(15, 20);
        operando_1.setLocation(725, 295);
        operacion.setHorizontalAlignment(JLabel.CENTER);
        operacion.setSize(135, 20);
        operacion.setLocation(725, 515);
        operacion.setFont(font2 = new Font("", Font.PLAIN, 17));
        operacion.setBackground(Color.yellow);
        operacion.setOpaque(true);

        tu.setText("Tu: " + jugador);
        tu.setFont(font2 = new Font("", Font.PLAIN, 17));
        tu.setBackground(Color.yellow);
        tu.setOpaque(true);
        tu.setSize(200, 20);
        tu.setLocation(445, 660);
        contrincante.setText("Rival: " + rival);
        contrincante.setFont(font2 = new Font("", Font.PLAIN, 17));
        contrincante.setBackground(Color.yellow);
        contrincante.setOpaque(true);
        contrincante.setSize(200, 20);
        contrincante.setLocation(445, 707);

        f.setSize(900, 800);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cb.setBounds(760, 295, 45, 20);
        t.setBounds(725, 545, 135, 30);
        b9.setBounds(815, 580, 45, 35);
        b8.setBounds(770, 580, 45, 35);
        b7.setBounds(725, 580, 45, 35);
        b6.setBounds(815, 615, 45, 35);
        b5.setBounds(770, 615, 45, 35);
        b4.setBounds(725, 615, 45, 35);
        b3.setBounds(815, 650, 45, 35);
        b2.setBounds(770, 650, 45, 35);
        b1.setBounds(725, 650, 45, 35);
        bdel.setBounds(815, 685, 45, 35);
        bpun.setBounds(770, 685, 45, 35);
        b0.setBounds(725, 685, 45, 35);
        dice.setBounds(750, 110, 70, 35);
        benviar_r.setBounds(725, 325, 135, 40);
        bclr.setBounds(725, 720, 135, 40);
        dice.setFont(font);
        turno.setBounds(720, 0, 120, 40);
        emparejar.setBounds(590, 720, 135, 40);

        dice.setEnabled(false);
        turno.setEnabled(false);
        bclr.setEnabled(false);
        benviar_r.setEnabled(false);
        emparejar.setEnabled(false);

        panel.setSize(390, 390);
        f.add(t);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b0);
        f.add(bdel);
        f.add(bclr);
        f.add(bpun);
        f.add(benviar_r);
        f.add(dice);
        f.add(emparejar);
        f.add(casilla);
        f.add(lDado);
        f.add(turno);
        f.add(tu);
        f.add(contrincante);
        f.add(operando_1);
        f.add(operando_2);
        f.add(operacion);
        f.add(cb);
        f.add(panel);
        f.setResizable(false);
        casilla.setText(Lista_J1.getNode().getTipo());
        operando_1.setText("00");
        operando_2.setText("50");
        operacion.setText("Operación");
        lDado.setText("Dado");

        prep = new Thread(this::run1);
        prep.start();

        prepreto = new Thread(this::run2);
        prepreto.start();

        prepempareja = new Thread(this::run3);
        prepempareja.start();

        /**
         * Esta acción del botón "dice", abre un socket que envía un string con el valor de
         * la posición del usuario después de moverse. Dentro del programa del contrincante,
         * se crea un server socket que escucha constantemente este string para poder mover
         * al rival a la posición que cayó en su pantalla
         */
        dice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    mov = dado.getDado();
                    lDado.setText("" + mov);
                    avanzar(mov, Lista_J2);
                    Casilla aux = new Casilla();
                    aux = Lista_J2.getNode();
                    casilla.setText(aux.getTipo());
                    panel.SetPosAvatar2(aux.getPos());
                    panel.move2();
                    panel.repaint();
                    Socket snsocket = new Socket("localhost", 5001);
                    DataOutputStream exitflow = new DataOutputStream(snsocket.getOutputStream());
                    exitflow.writeUTF(String.valueOf(aux.getPos()));
                    dice.setEnabled(false);
                    jugada(aux);
                    snsocket.close();
                }catch (IOException error) {
                    System.out.println(error.getMessage()); //Prints the exception
                }
            }
        });

        /**
         * Esta acción del botón turno. Envía al otro tablero la posición final del jugador
         * al final del turno, para que este pueda actualizarlo correctamente. Envía un
         * string con la posición y se envía a través del mismo puerto que el string del botón dice
         */
        turno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    Socket snsocket = new Socket("localhost", 5001);
                    DataOutputStream exitflow = new DataOutputStream(snsocket.getOutputStream());
                    Casilla aux = new Casilla();
                    aux = Lista_J2.getNode();
                    exitflow.writeUTF(String.valueOf(aux.getPos()));
                    turno.setEnabled(false);
                    snsocket.close();
                }catch (IOException error) {
                    System.out.println(error.getMessage()); //Prints the exception
                }
            }
        });

        /**
         * Al caer en reto, este botón se activa. Envía 3 string almacenados en la clase operación
         * Estos strings son números aleatorios sobre los cuales se aplicará una operación, y dicha operación.
         */
        benviar_r.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket snsocket = new Socket("localhost", 5003);

                    Operacion operacion = new Operacion();
                    operacion.setOperando1(operando_1.getText());
                    operacion.setOperando2(operando_2.getText());
                    operacion.setOperador(String.valueOf(cb.getSelectedItem()));

                    ObjectOutputStream exitflow = new ObjectOutputStream(snsocket.getOutputStream());
                    exitflow.writeObject(operacion);
                    benviar_r.setEnabled(false);
                    cantflujos2++;
                    snsocket.close();
                } catch (IOException error) {
                    System.out.println(error.getMessage()); //Prints the exception
                }
            }
        });

        /**
         * Este botón responde al reto y verifica el resultado del reto propuesto por el contrincante
         * si acierta permanece en su posición y si no, retrocede un espacio. Abre un socket por el cual
         * el contrincante recibe un string con la posición del jugador después de responder y así el
         * contrincante sabe si acertó o no
         */
        bclr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double respuesta = Double.parseDouble(t.getText());

                    if ((respuesta < (resultado_final - 0.1)) || (respuesta > (resultado_final + 0.1))) {
                        retroceder(1, Lista_J2);
                        Casilla aux = new Casilla();
                        aux = Lista_J2.getNode();
                        panel.SetPosAvatar2(aux.getPos());
                        panel.move2();
                        panel.repaint();
                    }
                    bclr.setEnabled(false);
                    operacion.setText("Operación");
                    Socket snsocket = new Socket("localhost", 5005);
                    DataOutputStream exitflow = new DataOutputStream(snsocket.getOutputStream());
                    Casilla aux = new Casilla();
                    aux = Lista_J2.getNode();
                    exitflow.writeUTF(String.valueOf(aux.getPos()));
                    snsocket.close();
                } catch (IOException error) {
                    System.out.println(error.getMessage()); //Prints the exception
                }
            }
        });

        /**
         * Este botón funciona de manera similar al de terminar turno, solo se utiliza cuando se cae en reto.
         * Se activa para enviar un string con la posición del retador, después de avanzar el espacio que dicha
         * casilla lo hace avanzar. NO finaliza el turno, es un botón únicamente par actualizar el tablero del
         * contrincante
         */
        emparejar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket snsocket = new Socket("localhost", 5005);
                    DataOutputStream exitflow = new DataOutputStream(snsocket.getOutputStream());
                    Casilla aux = new Casilla();
                    aux = Lista_J2.getNode();
                    exitflow.writeUTF(String.valueOf(aux.getPos()));
                    emparejar.setEnabled(false);
                    benviar_r.setEnabled(true);
                    snsocket.close();
                } catch (IOException error) {
                    System.out.println(error.getMessage()); //Prints the exception
                }
            }
        });

        /**
         * Asigna a cada tecla del teclado digital, su función
         */
        ActionListener teclas;
        teclas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent teclas) {
                if (teclas.getSource() == b1) {
                    t.setText(t.getText().concat("1"));
                }

                if (teclas.getSource() == b2) {
                    t.setText(t.getText().concat("2"));
                }

                if (teclas.getSource() == b3) {
                    t.setText(t.getText().concat("3"));
                }

                if (teclas.getSource() == b4) {
                    t.setText(t.getText().concat("4"));
                }

                if (teclas.getSource() == b5) {
                    t.setText(t.getText().concat("5"));
                }

                if (teclas.getSource() == b6) {
                    t.setText(t.getText().concat("6"));
                }

                if (teclas.getSource() == b7) {
                    t.setText(t.getText().concat("7"));
                }

                if (teclas.getSource() == b8) {
                    t.setText(t.getText().concat("8"));
                }

                if (teclas.getSource() == b9) {
                    t.setText(t.getText().concat("9"));
                }

                if (teclas.getSource() == b0) {
                    t.setText(t.getText().concat("0"));
                }

                if (teclas.getSource() == bdel) {
                    String s = t.getText();
                    t.setText("");
                    for (int i = 0; i < s.length() - 1; i++) {
                        t.setText(t.getText() + s.charAt(i));
                    }
                }

                if (teclas.getSource() == bpun) {
                    t.setText(t.getText().concat("."));
                }
                f.setVisible(true);
            }
        };

        t.setEditable(false);
        b1.addActionListener(teclas);
        b2.addActionListener(teclas);
        b3.addActionListener(teclas);
        b4.addActionListener(teclas);
        b5.addActionListener(teclas);
        b6.addActionListener(teclas);
        b7.addActionListener(teclas);
        b8.addActionListener(teclas);
        b9.addActionListener(teclas);
        b0.addActionListener(teclas);
        bdel.addActionListener(teclas);
        bpun.addActionListener(teclas);
        f.setVisible(true);
    }

    /**
     * Abre el socket por el que se recibe la posición que obtuvo el contrincante
     * a través del dado o del botón finalizar turno
     */
    public void run1() {
        try {
            ServerSocket serversocket = new ServerSocket(5002);
            while (true) {
                Socket sckt = serversocket.accept();
                DataInputStream entryflow = new DataInputStream(sckt.getInputStream());
                String res = entryflow.readUTF();
                int move = Integer.parseInt(res);
                panel.SetPosAvatar(move);
                panel.move();
                panel.repaint();
                cantflujos++;
                if (cantflujos == 2){
                    dice.setEnabled(true);
                    cantflujos = 0;
                }
                sckt.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Abre el socket por el cuál se reciben los dos valores aleatorios y la operación sobre dichos valores
     * Además guarda el resultado para poder evaluarlo más adelante con el botón responder
     */
    public void run2() {
        try {
            ServerSocket serversocket = new ServerSocket(5004);
            while (true) {
                Socket sckt = serversocket.accept();
                ObjectInputStream entryflow = new ObjectInputStream(sckt.getInputStream());
                Operacion res = (Operacion) entryflow.readObject();

                double opera1 = Double.parseDouble(res.getOperando1());
                double opera2 = Double.parseDouble(res.getOperando2());

                if (res.getOperador().equals("+")) {
                    resultado_final = Math.abs(opera1 + opera2);
                }

                if (res.getOperador().equals("-")) {
                    resultado_final = Math.abs(opera1 - opera2);
                }

                if (res.getOperador().equals("×")) {
                    resultado_final = Math.abs(opera1 * opera2);
                }

                if (res.getOperador().equals("÷")) {
                    resultado_final = Math.abs(opera1 / opera2);
                }
                operacion.setText(res.getOperando1() + res.getOperador() + res.getOperando2());
                bclr.setEnabled(true);
                sckt.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Abre el socket por el cuál se reciben las posiciones del contrincante durante todos los sucesos
     * generados por la casilla reto, mantiene actualizado al jugador de los movimientos del contrincante
     * únicamente durante el reto
     */
    public void run3() {
        try {
            ServerSocket serversocket = new ServerSocket(5006);
            while (true) {
                Socket sckt = serversocket.accept();
                DataInputStream entryflow = new DataInputStream(sckt.getInputStream());
                String res = entryflow.readUTF();
                int move = Integer.parseInt(res);
                panel.SetPosAvatar(move);
                panel.move();
                panel.repaint();
                cantflujos2++;
                if (cantflujos2 == 2) {
                    turno.setEnabled(true);
                }
                cantflujos2 = 0;
                sckt.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Esté método lee el tipo de casilla sobre la que se cayó y genera su acción
     * como se explica en la clase Casilla, la acción me genera el valor entero
     * de las posiciones que avanzará o retrocederá el jugador al caer en ella.
     * Para el caso de trampa o tunel, el botón de finalizar turno se activa inmediatamente
     * para cuando es reto, este botón se activa hasta que el reto haya finalizado.
     * Además, se tiene una condicional if para cuando se llegue a la úlktima posición del
     * tablero, que el juego indique qué jugador ganó y cierre la aplicación
     * @param c
     */
    public void jugada(Casilla c) {

        if (c.getTipo() == "Reto") {
            JOptionPane.showMessageDialog(null, c.getTipo());
            Lista_J2 = c.accion(Lista_J2);
            Casilla aux = new Casilla();
            aux = Lista_J2.getNode();
            casilla.setText(aux.getTipo());
            panel.SetPosAvatar2(aux.getPos());
            panel.move2();
            panel.repaint();
            if (aux.getTipo() == "Fin") {
                JOptionPane.showMessageDialog(null, "Ganó el jugador 2");
                System.exit(0);
            }
            Random valor = new Random();
            int valor1 = 1 + valor.nextInt(50);
            int valor2 = 1 + valor.nextInt(50);
            operando_1.setText(String.valueOf(valor1));
            operando_2.setText(String.valueOf(valor2));
            emparejar.setEnabled(true);
        }

        if (c.getTipo() == "Trampa") {
            JOptionPane.showMessageDialog(null, c.getTipo());
            Lista_J2 = c.accion(Lista_J2);
            Casilla aux;
            aux = Lista_J2.getNode();
            casilla.setText(aux.getTipo());
            panel.SetPosAvatar2(aux.getPos());
            panel.move2();
            panel.repaint();
            turno.setEnabled(true);
        }

        if (c.getTipo() == "Túnel") {
            JOptionPane.showMessageDialog(null, c.getTipo());
            Lista_J2 = c.accion(Lista_J2);
            Casilla aux;
            aux = Lista_J2.getNode();
            casilla.setText(aux.getTipo());
            panel.SetPosAvatar2(aux.getPos());
            panel.move2();
            panel.repaint();
            if (aux.getTipo() == "Fin") {
                JOptionPane.showMessageDialog(null, "Ganó el jugador 2");
                System.exit(0);
            }
            turno.setEnabled(true);
        }

        if (c.getTipo() == "Fin") {
            JOptionPane.showMessageDialog(null, "Ganó el jugador 2");
            System.exit(0);
        }
    }

    /**
     * avanza la cantidad de espacios ingresados en la lista doblemente enlazada al usuario
     * @param a
     * @param l
     */
    public void avanzar(int a, DoublyLinkedListObj l) {
        while (a != 0) {
            l.getNext();
            a--;
        }
    }

    /**
     * retrocede la cantidad de espacios ingresados en la lista doblemente enlazada al usuario
     * @param r
     * @param l
     */
    public void retroceder(int r, DoublyLinkedListObj l) {
        while (r != 0) {
            l.getPrev();
            r--;
        }
    }
}