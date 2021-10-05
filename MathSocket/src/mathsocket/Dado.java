package mathsocket;

public class Dado {
    //Atributos
    private int dado;
    //Constructor
    public Dado(){

    }
    //sets y gets
    public int getDado(){
        dado=(int)(Math.random()*(1-4)+4);
        return dado;
    }
    public void setDado(int dado){
        this.dado=dado;
    }
    //Métodos necesarios para la ejecución
    public void lanzarDado(){
        System.out.println("El valor del dado es "+dado);
    }
}