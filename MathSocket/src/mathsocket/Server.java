package mathsocket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Esta clase contiene los métodos necesarios para ejecutar el menú principal
 * @author Luis Alejandro Barreda Acevedo
 * @see Server
 */
public class Server implements Runnable {

    int cantidadjugadores = 0;
    JFrame frame;
    JLabel nameLabel, esperando1, esperando2;
    JButton aceptar, inicio;
    JTextField nametxtfield;
    Thread prep;
    DoublyLinkedListSuper superlist2;
    ServerSocket serversocket;
    Socket snsocket, sckt;

    /**
     * Este método se encarga de crear el JFrame y agregarle los JButtons, JLabels y demás
     * objetos que permiten la correcta visualización de la aplicación. Esta interfaz es
     * sencilla. Utiliza sockets para saber cuando un jugador se conectó a una partida y
     * cuando ambos están listos para jugar (tiene que estar ambos)
     */
    public void start(DoublyLinkedListSuper superlist) {
        superlist2 = superlist;
        frame = new JFrame();
        frame.setSize(400, 200);
        frame.setLocation(400, 200);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Jugador 2");
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Labels
        nameLabel = new JLabel();
        nameLabel.setText("Introduzca su nombre");
        nameLabel.setBounds(10, 70, 200, 20);
        nameLabel.setForeground(Color.darkGray);
        frame.add(nameLabel);

        esperando1 = new JLabel();
        esperando1.setText("Esperando 1er Jugador...");
        esperando1.setBounds(220, 10, 200, 20);
        esperando1.setForeground(Color.darkGray);
        frame.add(esperando1);

        esperando2 = new JLabel();
        esperando2.setText("Esperando 2do Jugador...");
        esperando2.setBounds(220, 30, 200, 20);
        esperando2.setForeground(Color.darkGray);
        frame.add(esperando2);

        //Buttons
        aceptar = new JButton("Aceptar");
        aceptar.setBounds(10, 140, 90, 20);
        aceptar.setBackground(Color.lightGray);
        aceptar.setForeground(Color.darkGray);
        frame.add(aceptar);

        inicio = new JButton("Inicio");
        inicio.setBounds(220, 140, 90, 20);
        inicio.setBackground(Color.lightGray);
        inicio.setForeground(Color.darkGray);
        inicio.setEnabled(false);
        frame.add(inicio);

        //Text
        nametxtfield = new JTextField();
        nametxtfield.setBounds(10, 30, 120, 30);
        nametxtfield.setBackground(Color.lightGray);
        frame.add(nametxtfield);

        prep = new Thread(this);
        prep.start();

        /**
         * nameJ2 es el método asociado al botón aceptar, adquiere el nombre del jugador y lo
         * envía mediante un socket al otro jugador para que sepa que se está listo. Envía un string
         */
        ActionListener nameJ2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    snsocket = new Socket("localhost", 5000);
                    String nameJ2 = nametxtfield.getText();
                    DataOutputStream exitflow = new DataOutputStream(snsocket.getOutputStream());
                    exitflow.writeUTF(nameJ2);

                    esperando2.setText(nametxtfield.getText());
                    cantidadjugadores++;

                    if (cantidadjugadores == 2){
                        inicio.setEnabled(true);
                        aceptar.setEnabled(false);
                    }

                    aceptar.setEnabled(false);

                    snsocket.close();

                }catch (IOException error) {

                    System.out.println(error.getMessage()); //Prints the exception
                }
            }
        };
        aceptar.addActionListener(nameJ2);

        /**
         * iniciarjuego es el método del botón inicio, genera el tablero asociado al jugador
         * en cuestión y guarda los nombres de ambos
         */
        ActionListener iniciarjuego = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.setEnabled(false);
                MathSocketJ2 gui = new MathSocketJ2();
                gui.inter(esperando2.getText(), esperando1.getText(), superlist2);
            }
        };
        inicio.addActionListener(iniciarjuego);
    }

    /**
     * método run activado por el hilo, genera un server socket. Está constantemente a la
     * escucha del nombre enviado por el otro jugador. Escucha un string
     */
    @Override
    public void run(){
        try{
            serversocket = new ServerSocket(4999);

            while(true){
                sckt = serversocket.accept();

                DataInputStream entryflow = new DataInputStream(sckt.getInputStream());
                String res = entryflow.readUTF();

                esperando1.setText(res);
                cantidadjugadores++;

                if (cantidadjugadores == 2){
                    inicio.setEnabled(true);
                    sckt.close();
                }
                sckt.close();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
