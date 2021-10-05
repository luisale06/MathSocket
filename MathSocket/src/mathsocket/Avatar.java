package mathsocket;

import java.awt.Graphics2D;
/**
 * Esta clase se crea el objeto que represanta al jugador en el tablero, ademas se encarga de moverlo entre las casillas
 * @author Luis Pablo Céspedes Sequeira.
 * @see Avatar
 */
public class Avatar {

    public int x = 45;
    public int y;
    public int z;
    public int mov_x = 150;
    public int mov_y = 150;
    public int pos;
    public int cont = 0;
    private Lienzo av;
    /**
     * Metodo que instancia la clase, recibe como parametro el canvas donde se va dibujar y la posicion en "y"
     * ya que esta cambia para cada jugador y asi evitar que dibujen uno encima de otro, el desplazamiento en "x" es dentro
     * del mismo rango en ambos jugadores.
     * El "y" solo puede tener 4 diferentes, uno por cada fila al ser pocos siempre se inicia en el valor inicial y solo se le suma
     * hasta que coincida con la posicion requerida, por eso se guarda este valor en una variable "z", antes de hacer los cambios en "y"
     */
    public Avatar(Lienzo game, int temp) {
        av = game;
        y= temp;
        z=temp;
    }
    /**
     * Metodo que agrega la posicion del jugador en la lista
     */
    void setPos(int p) {
        pos = p;
    }
    /**
     * Metodo que dibuja al objeto Avatar tomando como referencia la posicion del jugador, ya que son 16 diferentes posibles
     * posiciones se hacen las consideraciones para cada una donde tiene 4 posibles posicione horizontales y 4 verticales
     * osea 4 filas y 4 columnas, las cuales representan la secuencia de las casillas
     */
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
