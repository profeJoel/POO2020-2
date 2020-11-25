
package ClasesAbstractas;
public class Gato extends Animal{
    private String nombre;

    public Gato(String nombre)
    {
        this.nombre = nombre;
    }

    public void haceRuido()
    {
        System.out.println(this.nombre + " Maulla...");
    }
}