package mathsocket;

public class randomCasillas extends DoublyLinkedListObj{
    int cantidad_reto = 7;
    int cantidad_trampa = 4;
    int cantidad_tunel = 3;
    int size = 14;
    int count = 1;
    int random = (int) (Math.random() * (1 - 4) + 4);
    int fix = random;
    DoublyLinkedListObj casillas_random = new DoublyLinkedListObj();
    DoublyLinkedListSuper superlista = new DoublyLinkedListSuper();

    public randomCasillas(){
        while (size >= count) {
            if (random == 1 & cantidad_reto >= 1) {
                Reto reto = new Reto();
                reto.setTipo("Reto");
                casillas_random.addObjAtEnd(reto);
                cantidad_reto--;
                count++;
            }
            if (random == 2 & cantidad_trampa >= 1) {
                Trampa trampa = new Trampa();
                trampa.setTipo("Trampa");
                casillas_random.addObjAtEnd(trampa);
                cantidad_trampa--;
                count++;
            }
            if (random == 3 & cantidad_tunel >= 1) {
                Tunel tunel = new Tunel();
                tunel.setTipo("Tunel");
                casillas_random.addObjAtEnd(tunel);
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
        fin.setTipo("Final");
        casillas_random.addObjAtFront(inicio);
        casillas_random.addObjAtEnd(fin);
        casillas_random.setPosition();

        /*System.out.println("Cantidad de Nodos: " + casillas_random.countBNodesObj());
        System.out.println("Imprimiendo lista...");
        casillas_random.printList();*/

        DoublyLinkedListObj lista1 = casillas_random;
        DoublyLinkedListObj lista2 = lista1;

        /*lista1.printList();
        System.out.println("------------------------");
        lista2.printList();*/

        superlista.addListAtEnd(lista1);
        superlista.addListAtEnd(lista2);
        superlista.printSuperList();
    }

    public DoublyLinkedListSuper getSuperList(){
        return superlista;
    }
}
