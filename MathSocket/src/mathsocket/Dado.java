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
/**
 public class FrecuenciaDados {
 //Atributos
 private final int MAX=11;
 private Dado d1;
 private Dado d2;
 private final int suma[]=new int [MAX];
 //Constructor
 public FrecuenciaDados(){

 }
 //sets y gets
 public Dado getDado1(){
 return d1;
 }
 public Dado getDado2(){
 return d2;
 }
 public void setDado1(Dado d1){
 this.d1=d1;
 }
 public void setDado2(Dado d2){
 this.d2=d2;
 }
 //Método para mostrar las frecuencias de los números de los dados
 public void mostrarFrecuencias(){
 int numeros[]={2,3,4,5,6,7,8,9,10,11,12};
 for(int i=0;i<MAX;i++){
 System.out.println("Número "+numeros[i]);
 }
 }

 }
 */
