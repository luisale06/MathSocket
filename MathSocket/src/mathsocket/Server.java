package mathsocket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Server {

    JFrame frame;
    JLabel nameLabel;
    JButton aceptar;
    JTextField nametxtfield;

    public void start() {

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

        //Buttons
        aceptar = new JButton("Aceptar");
        aceptar.setBounds(10, 140, 90, 20);
        aceptar.setBackground(Color.lightGray);
        aceptar.setForeground(Color.darkGray);
        frame.add(aceptar);

        //Text
        nametxtfield = new JTextField();
        nametxtfield.setBounds(10, 30, 120, 30);
        nametxtfield.setBackground(Color.lightGray);
        frame.add(nametxtfield);

        ActionListener nameJ2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket snsocket = new Socket("localhost", 4999);
                    String nameJ2 = nametxtfield.getText();
                    DataOutputStream exitflow = new DataOutputStream(snsocket.getOutputStream());
                    exitflow.writeUTF(nameJ2);

                    JLabel namesent = new JLabel();
                    namesent.setText("Nombre Enviado");
                    namesent.setBounds(250, 10, 200, 20);
                    namesent.setForeground(Color.darkGray);
                    frame.add(namesent);

                    JLabel esperando = new JLabel();
                    esperando.setText("Esperando Partida...");
                    esperando.setBounds(250, 30, 200, 20);
                    esperando.setForeground(Color.darkGray);
                    frame.add(esperando);

                    aceptar.setEnabled(false);

                    snsocket.close();

                } catch (IOException error) {

                    System.out.println(error.getMessage()); //Prints the exception
                }
            }
        };
        aceptar.addActionListener(nameJ2);
    }

    public static void main(String[] args){
        Server server = new Server();
        server.start();
    }
}
