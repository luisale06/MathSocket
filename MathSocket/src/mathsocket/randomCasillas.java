package mathsocket;

import java.io.Serializable;

/**
 * Clase que genera 14 casillas de forma aleatoria:
 * 7 de Reto
 * 4 de Trampa
 * 3 de Tunel
 * y añade al principio una casilla de tipo inicio
 * y al final una casilla de tipo final
 * Es importante mencionar que se generan 8 listas diferentes, 4 se guardan en una superlista
 * y las otras 4 en otra (las superlistas son objetos de tipo DoublyLinkedListSuper). Esto con
 * el fin de enviar 4 casillas al primer tablero y otras 4 al otro, ya que se necesitan
 * listas de casillas exactamente iguales, pero guardadas en memoria de manera diferente
 * @author Luis Alejandro Barreda Acevedo
 * @see randomCasillas
 */
public class randomCasillas extends DoublyLinkedListObj implements Serializable {
    int cantidad_reto = 7;
    int cantidad_trampa = 4;
    int cantidad_tunel = 3;
    int size = 14;
    int count = 1;
    int random = (int) (Math.random() * (1 - 4) + 4);
    int fix = random;

    DoublyLinkedListObj casillas_random1 = new DoublyLinkedListObj();
    DoublyLinkedListObj casillas_random2 = new DoublyLinkedListObj();
    DoublyLinkedListObj casillas_random3 = new DoublyLinkedListObj();
    DoublyLinkedListObj casillas_random4 = new DoublyLinkedListObj();
    DoublyLinkedListObj casillas_random5 = new DoublyLinkedListObj();
    DoublyLinkedListObj casillas_random6 = new DoublyLinkedListObj();
    DoublyLinkedListObj casillas_random7 = new DoublyLinkedListObj();
    DoublyLinkedListObj casillas_random8 = new DoublyLinkedListObj();

    DoublyLinkedListSuper sublista1 = new DoublyLinkedListSuper();
    DoublyLinkedListSuper sublista2 = new DoublyLinkedListSuper();

    /**
     * Genera las sublistas gracias a los contadores de las mismas. Estos sirven poara verificar que
     * aún se pueden seguir agregando casillas a las listas. Una vez que se sabe cuál objeto de casilla
     * crear, este se añade a un nodo en cada lista, al final de esta y se sigue con el siguiente bucle.
     * Se añade una instancia de casilla inicio al principio y una instancia de casilla final al final
     * de las 8 listas y se les setea la posición del 0 al 15 a todas.
     * Finalmente se concatenan 4 listas en una superlista y 4 en otra.
     */
    public randomCasillas(){
        while (size >= count) {
            if (random == 1 & cantidad_reto >= 1) {
                Reto reto = new Reto();
                reto.setTipo("Reto");

                casillas_random1.addObjAtEnd(reto);
                casillas_random2.addObjAtEnd(reto);
                casillas_random3.addObjAtEnd(reto);
                casillas_random4.addObjAtEnd(reto);
                casillas_random5.addObjAtEnd(reto);
                casillas_random6.addObjAtEnd(reto);
                casillas_random7.addObjAtEnd(reto);
                casillas_random8.addObjAtEnd(reto);

                cantidad_reto--;
                count++;
            }
            if (random == 2 & cantidad_trampa >= 1) {
                Trampa trampa = new Trampa();
                trampa.setTipo("Trampa");

                casillas_random1.addObjAtEnd(trampa);
                casillas_random2.addObjAtEnd(trampa);
                casillas_random3.addObjAtEnd(trampa);
                casillas_random4.addObjAtEnd(trampa);
                casillas_random5.addObjAtEnd(trampa);
                casillas_random6.addObjAtEnd(trampa);
                casillas_random7.addObjAtEnd(trampa);
                casillas_random8.addObjAtEnd(trampa);

                cantidad_trampa--;
                count++;
            }
            if (random == 3 & cantidad_tunel >= 1) {
                Tunel tunel = new Tunel();
                tunel.setTipo("Túnel");

                casillas_random1.addObjAtEnd(tunel);
                casillas_random2.addObjAtEnd(tunel);
                casillas_random3.addObjAtEnd(tunel);
                casillas_random4.addObjAtEnd(tunel);
                casillas_random5.addObjAtEnd(tunel);
                casillas_random6.addObjAtEnd(tunel);
                casillas_random7.addObjAtEnd(tunel);
                casillas_random8.addObjAtEnd(tunel);

                cantidad_tunel--;
                count++;
            }

            while (random == fix) {
                random = (int) (Math.random() * (1 - 4) + 4);
            }
            fix = random;
        }
        Casilla inicio = new Casilla();
        inicio.setTipo("Inicio");
        Casilla fin = new Casilla();
        fin.setTipo("Fin");

        casillas_random1.addObjAtFront(inicio);
        casillas_random1.addObjAtEnd(fin);
        casillas_random1.setPosition();

        casillas_random2.addObjAtFront(inicio);
        casillas_random2.addObjAtEnd(fin);
        casillas_random2.setPosition();

        casillas_random3.addObjAtFront(inicio);
        casillas_random3.addObjAtEnd(fin);
        casillas_random3.setPosition();

        casillas_random4.addObjAtFront(inicio);
        casillas_random4.addObjAtEnd(fin);
        casillas_random4.setPosition();

        casillas_random5.addObjAtFront(inicio);
        casillas_random5.addObjAtEnd(fin);
        casillas_random5.setPosition();

        casillas_random6.addObjAtFront(inicio);
        casillas_random6.addObjAtEnd(fin);
        casillas_random6.setPosition();

        casillas_random7.addObjAtFront(inicio);
        casillas_random7.addObjAtEnd(fin);
        casillas_random7.setPosition();

        casillas_random8.addObjAtFront(inicio);
        casillas_random8.addObjAtEnd(fin);
        casillas_random8.setPosition();

        sublista1.addListAtEnd(casillas_random1);
        sublista1.addListAtEnd(casillas_random2);
        sublista1.addListAtEnd(casillas_random3);
        sublista1.addListAtEnd(casillas_random4);

        sublista2.addListAtEnd(casillas_random5);
        sublista2.addListAtEnd(casillas_random6);
        sublista2.addListAtEnd(casillas_random7);
        sublista2.addListAtEnd(casillas_random8);
    }

    /**
     * Retorna la primer superlista
     * @return
     */
    public DoublyLinkedListSuper getSubLista1(){
        return sublista1;
    }

    /**
     * Retorna la segunda superlista
     * @return
     */
    public DoublyLinkedListSuper getSubLista2(){
        return sublista2;
    }
}
