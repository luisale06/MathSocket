package mathsocket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client implements Runnable{
    int cantidadjugadores = 0;
    JFrame frame;
    JLabel esperando1, esperando2, nameLabel;
    JButton aceptar, inicio;
    JTextField nametxtfield;
    Thread prep;

    public void start() {

        frame = new JFrame();
        frame.setSize(400, 200);
        frame.setLocation(400, 200);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Jugador 1");
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

        ActionListener nameJ1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                esperando1.setText(nametxtfield.getText());
                cantidadjugadores++;

                if (cantidadjugadores == 2){
                    inicio.setEnabled(true);
                    aceptar.setEnabled(false);
                }
            }
        };
        aceptar.addActionListener(nameJ1);

        ActionListener iniciarjuego = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MathSocket gui = new MathSocket();
                gui.inter(esperando1.getText(), esperando2.getText());
            }
        };
        inicio.addActionListener(iniciarjuego);
    }

    @Override
    public void run(){
        try{
            ServerSocket serversocket = new ServerSocket(4999);

            while(true){
                Socket sckt = serversocket.accept();

                DataInputStream entryflow = new DataInputStream(sckt.getInputStream());
                String res = entryflow.readUTF();

                esperando2.setText(res);
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

    public static void main(String[] args){
        Client client = new Client();
        client.start();
    }
}
