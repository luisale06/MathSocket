/*ITCR
Área Académica Ingeniería en Computadores
II Semestre 2021/Algoritmos y Estructura de Datos I
Tarea Extraclase 1
Estudiante: Luis Pablo Céspedes Sequeira.
Carné: 201156162
IDE: NetBeans 12.2*/
package mathsocket;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Esta clase contiene las partes de la interfaz que no intervienen en la lógica
 * del programa, que por esto se puede usar en ambos usuarios.
 *
 * @author Luis Pablo Céspedes Sequeira.
 * @see Lienzo
 */
@SuppressWarnings("serial")
public class Lienzo extends Canvas {
    public int e = 1;
    public int x = 45;
    public int y = 45;
    public int sqr = 0;
    Cuadros cuadros = new Cuadros(this);
    Avatar av = new Avatar(this, 50);
    Avatar av2 = new Avatar(this, 110);
    public String usuario;
    DoublyLinkedListObj list = new DoublyLinkedListObj();
    DoublyLinkedListObj refresh = new DoublyLinkedListObj();

    /**
     * Metodo parametrizado, constructor por defecto del otro usuario, y hacerle
     * los cambios necesarios para asignarlos a las etiquetas que los desplegan
     *
     * @param nombre Nombre del otro ususario para identificar que los datos que
     * se desplegan son del otro usuario
     */
    public Lienzo(DoublyLinkedListObj l,DoublyLinkedListObj l2) {

        list = l;
        refresh = l2;
    }

    void SetPosAvatar(int p) {
        av.setPos(p);
    }
    void SetPosAvatar2(int p) {
        av2.setPos(p);
    }
    void move() {
        av.move();
    }

    void move2() {
        av2.move();
    }
    @Override
    /**
     * Metodo que se encarga de dibujar y escribir objetos de cierta parte de la
     * interfaz
     */
    public void paint(Graphics p) {
        super.paint(p);
        final String color = "Reto";
        Graphics2D g2d = (Graphics2D) p;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        p.setColor(Color.BLACK);
        //cuadros.paint(g2d);
        while (sqr <= 3) {

            while (x < 630 & x >=45) {
                if ("Inicio" == list.getNode().getTipo()) {
                    p.setColor(Color.magenta);
                }
                if ("Reto" == list.getNode().getTipo()) {
                    p.setColor(Color.blue);
                }
                if ("Trampa" == list.getNode().getTipo()) {
                    p.setColor(Color.red);
                }
                if ("Túnel" == list.getNode().getTipo()) {
                    p.setColor(Color.green);
                }
                if ("Fin" == list.getNode().getTipo()) {
                    p.setColor(Color.magenta);
                }
                p.fillRect(x, y, 100, 100);
                x = x + e * 150;
                list.getNext();
            }
            sqr++;
            e= -1*e;
            x = x +(150* e);
            y = y + 150;
        }
        while (list.getNode().getTipo() != "Inicio") {
            list.getPrev();
        }
        x = 45;
        y = 45;
        sqr = 0;
        p.setColor(Color.white);
        av.paint(g2d);
        p.setColor(Color.black);
        av2.paint(g2d);
    }

}
