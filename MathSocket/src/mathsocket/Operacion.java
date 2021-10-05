package mathsocket;

import java.io.Serializable;

/**
 * Clase que guarda los dos valores aleatorios y la operación a realizar.
 * Está Serializada, para poder enviarla a través de sockets
 * @author Luis Alejandro Barreda Acevedo
 * @see Operacion
 */
public class Operacion implements Serializable {

    private String operando1, operando2, operador;

    /**
     * Devuelve el primer operando
     * @return
     */
    public String getOperando1() {
        return operando1;
    }

    /**
     * Cambia el primer operando por el deseado
     * @return
     */
    public void setOperando1(String op1){
        this.operando1 = op1;
    }


    /**
     * Devuelve el segundo operando
     * @return
     */
    public String getOperando2() {
        return operando2;
    }

    /**
     * Cambia el segundo operando por el deseado
     * @return
     */
    public void setOperando2(String op2){
        this.operando2 = op2;
    }


    /**
     * Devuelve el operador
     * @return
     */
    public String getOperador() {
        return operador;
    }
    /**
     * Cambia el operador por el deseado
     * @return
     */
    public void setOperador(String opera){
        this.operador = opera;
    }
}
