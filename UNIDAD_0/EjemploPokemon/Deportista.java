public class Deportista extends Persona{
 
    public Deportista(String nombre) {
        super(nombre);
    }

    public void corre(){
        System.out.println(getNombre() + " Corre");
    }
     
}