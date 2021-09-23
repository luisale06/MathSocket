package mathsocket;

import java.awt.Graphics2D;

public class Avatar {

    public int x = 45;
    public int y;
    public int z;
    public int mov_x = 150;
    public int mov_y = 150;
    public int pos;
    public int cont = 0;
    private Lienzo av;

    public Avatar(Lienzo game, int temp) {
        av = game;
        y= temp;
        z=temp;
    }

    void setPos(int p) {
        pos = p;
    }

    void move() {
        x = 45;
        y = z;
        if (pos <= 3) {
            while (cont != pos) {
                cont++;
            }
            x = x + cont * mov_x;
        };
        if (pos > 3 & pos <= 7) {
            x = 495;
            while (cont != pos - 4) {
                cont++;
            }
            x = x + -cont * mov_x;
            y = y + mov_y;
        };
        if (pos > 7 & pos <= 11) {
            while (cont != pos - 8) {
                cont++;
            }
            x = x + cont * mov_x;
            y = y + 2 * mov_y;
        };
        if (pos > 11 & pos <= 16) {
            x = 495;
            while (cont != pos - 12) {
                cont++;
            }
            x = x + -cont * mov_x;
            y = y + 3 * mov_y;
        };
    }

    public void paint(Graphics2D circulo) {
        circulo.fillOval(x, y, 30, 30);
    }
}
