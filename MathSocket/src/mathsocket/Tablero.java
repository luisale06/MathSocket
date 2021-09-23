package mathsocket;

public class Tablero extends  DoublyLinkedListObj {

    DoublyLinkedListObj tab = new DoublyLinkedListObj();
    Casilla aux0 = new Casilla();
    Reto aux1 = new Reto();
    Trampa aux2 = new Trampa();
    Reto aux3 = new Reto();
    Casilla aux4 = new Casilla();
    Reto aux5 = new Reto();
    Tunel aux6 = new Tunel();
    Reto aux7 = new Reto();
    Casilla aux8 = new Casilla();
    Reto aux9 = new Reto();
    Casilla aux10 = new Casilla();
    Reto aux11 = new Reto();
    Casilla aux12 = new Casilla();
    Reto aux13 = new Reto();
    Casilla aux14 = new Casilla();
    Casilla aux15 = new Casilla();

    public Tablero() {
        aux0.setTipo("Inicio");
        aux0.setPos(0);
        tab.addObjAtEnd(aux0);
        aux1.setTipo("Reto");
        aux1.setPos(1);
        tab.addObjAtEnd(aux1);
        aux2.setTipo("Trampa");
        aux2.setPos(2);
        tab.addObjAtEnd(aux2);
        aux3.setTipo("Reto");
        aux3.setPos(3);
        tab.addObjAtEnd(aux3);
        aux4.setTipo("Trampa");
        aux4.setPos(4);
        tab.addObjAtEnd(aux4);
        aux5.setTipo("Reto");
        aux5.setPos(5);
        tab.addObjAtEnd(aux5);
        aux6.setTipo("Túnel");
        aux6.setPos(6);
        tab.addObjAtEnd(aux6);
        aux7.setTipo("Reto");
        aux7.setPos(7);
        tab.addObjAtEnd(aux7);
        aux8.setTipo("Trampa");
        aux8.setPos(8);
        tab.addObjAtEnd(aux8);
        aux9.setTipo("Reto");
        aux9.setPos(9);
        tab.addObjAtEnd(aux9);
        aux10.setTipo("Trampa");
        aux10.setPos(10);
        tab.addObjAtEnd(aux10);
        aux11.setTipo("Reto");
        aux11.setPos(11);
        tab.addObjAtEnd(aux11);
        aux12.setTipo("Túnel");
        aux12.setPos(12);
        tab.addObjAtEnd(aux12);
        aux13.setTipo("Reto");
        aux13.setPos(13);
        tab.addObjAtEnd(aux13);
        aux14.setTipo("Trampa");
        aux14.setPos(14);
        tab.addObjAtEnd(aux14);
        aux15.setTipo("Fin");
        aux15.setPos(15);
        tab.addObjAtEnd(aux15);
        tab.SetJugador("JUGADOR");
    }

    public DoublyLinkedListObj getTablero() {
        return tab;
    }
}
