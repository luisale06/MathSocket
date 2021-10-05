package mathsocket;


import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Cuadros {
    public int x = 45;
    public int y = 45;
    public int sqr = 0;
    private Lienzo bola;

    public Cuadros(Lienzo game) {
        bola= game;
    }




    public void paint(Graphics2D circulo) {
        while (sqr <= 15) {
            while (x < 630) {
                circulo.fillRect(x, y, 100, 100);
                sqr++;
                x = x + 150;
            }
            x = 45;
            y = y + 150;
        }
        x= 45;
        y= 45;
        sqr = 0;
    }


}