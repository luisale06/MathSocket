package mathsocket;

import java.awt.*;
/**
 * Esta clase se encarga de crear un canvas en el cual se dibuja el tablero del juego, asignandole un color a cada casilla segun su tipo,
 * ademas crea un tipo de panel con las instrucciones basicas del juego y dibuja las fichas que representan a cada jugador
 * @author Luis Pablo Céspedes Sequeira.
 * @see Lienzo
 */
public class Lienzo extends Canvas {
    public int e = 1;
    public int x = 45;
    public int y = 25;
    public int sqr = 0;
    Cuadros cuadros = new Cuadros(this);
    Avatar av = new Avatar(this, 30);
    Avatar av2 = new Avatar(this, 90);
    //public String usuario = "Antonio Gonzales";
    DoublyLinkedListObj list = new DoublyLinkedListObj();
    DoublyLinkedListObj refresh = new DoublyLinkedListObj();
    /**
     * Metodo que instancia la clase, recibe como parametro una copia de la Lista Doblemente enlazada que almacena, las casillas
     * del tablero cuyo orden se creo de forma aleatoria, por es es un parametro de esta clase ya que cada vez que se instancie
     * debe ser en funcion de esa lista
     */
    public Lienzo(DoublyLinkedListObj l,DoublyLinkedListObj l2) {

        list = l;
        refresh = l2;
    }
    /**
     * Metodo que agrega la posición del objeto  que representa al jugador 1
     */
    void SetPosAvatar(int p) {
        av.setPos(p);
    }
    /**
     * Metodo que agrega la posición del objeto  que representa al jugador 2
     */
    void SetPosAvatar2(int p) {
        av2.setPos(p);
    }
    /**
     * Metodo que mueve la posición del objeto  que representa al jugador 1
     */
    void move() {
        av.move();
    }
    /**
     * Metodo que mueve la posición del objeto  que representa al jugador 2
     */
    void move2() {
        av2.move();
    }
    /**
     * Metodo que mueve la posición del objeto  que representa al jugador 2
     */
    @Override
    /**
     * Metodo que dibuja los componentes del tablero, los objetos que representan a cada jugar y
     * el panel de las instrucciones
     */
    public void paint(Graphics p) {
        super.paint(p);
        final String color = "Reto";
        Graphics2D g2d = (Graphics2D) p;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        p.setColor(Color.yellow);
        p.fillRect(0, 0, 900, 800);
        p.setColor(Color.black);
        p.fillRect(00, 0, 690, 655);

        p.setColor(Color.white);
        Font font2 = new Font("", Font.PLAIN, 69);
        p.setFont(font2);
        p.drawString("→", 150, 170);
        p.drawString("→", 300, 170);
        p.drawString("→", 450, 170);
        p.drawString("←", 150, 320);
        p.drawString("←", 300, 320);
        p.drawString("←", 450, 320);
        p.drawString("→", 150, 470);
        p.drawString("→", 300, 470);
        p.drawString("→", 450, 470);
        p.drawString("←", 150, 620);
        p.drawString("←", 300, 620);
        p.drawString("←", 450, 620);
        p.drawString("↓", 620, 550);
        p.drawString("↓", 5, 400);
        p.drawString("↓", 620, 250);
        Font font3 = new Font("", Font.PLAIN, 27);
        p.setFont(font3);
        p.drawString("Inicio", 45, 160);
        p.drawString("Fin", 45, 610);
        //p.fillRect(700, 0, 185, 800);
        //p.setColor(Color.yellow);
        //p.fillRect(0, 655, 690, 110);
        Font font = new Font("", Font.PLAIN, 17);
        p.setFont(font);
        p.setColor(Color.black);
        p.drawString("Lanzar Dado", 700, 60);
        p.drawString("Crear Reto", 700, 245);
        p.drawString("Responder Reto", 700, 495);
        p.drawString("Jugador 1", 50, 678);
        p.drawString("Jugador 2", 50, 723);
        p.drawString("Reto", 195, 678);
        p.drawString("Trampa", 195, 723);
        p.drawString("Túnel", 340, 678);
        p.drawString("Inicio / Fin", 340, 723);
        //p.drawString("Nombre:   "+usuario, 445, 678);
        p.fillOval(5,705,25,25);
        p.setColor(Color.white);
        p.fillOval(5,660,25,25);
        p.setColor(Color.blue);
        p.fillRect(150,660,25,25);
        p.setColor(Color.green);
        p.fillRect(295,660,25,25);
        p.setColor(Color.red);
        p.fillRect(150,705,25,25);
        p.setColor(Color.magenta);
        p.fillRect(295,705,25,25);
        //cuadros.paint(g2d);
        /**
         * En este ciclo se inicia cada fila del tablero, se empieza de izquierda a derecha pero
         * pero se alterna en cada fila la direccion para dar la secuencia en zig zag que se pide en la especificacion.
         * Se usa una variable la cual segun signo positivo o negativo va cambiar la direccion de cada fila
         */
        while (sqr <= 3) {
            /**
             * En este ciclo se hacen condicionales que se encargan de dar color segun el tipo de casilla, a los cuadros
             * que las representan
             */
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
        /**
         * En este ciclo se vuelve acomodar la lista en su orden original para que cuando se deba volver a pintar
         * el canvas, el recorrido anterior no afecte el orden del nuevo "repaint"
         */
        while (list.getNode().getTipo() != "Inicio") {
            list.getPrev();
        }
        x = 45;
        y = 25;
        sqr = 0;
        p.setColor(Color.white);
        av.paint(g2d);
        p.setColor(Color.black);
        av2.paint(g2d);
    }
}
