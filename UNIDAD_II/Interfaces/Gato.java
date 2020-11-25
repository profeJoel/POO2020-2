
package Interfaces;
public class Gato implements Animal{ /**detallo el código del comportamiento de los métodos de la clase Animal */
    private String nombre;

    public Gato(String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public void haceRuido()
    {
        System.out.println(this.nombre + " Maulla...");
    }

    @Override
    public void duerme()
    {
        System.out.println(this.nombre + " esta zZzZz...");
    }

    @Override
    public void seMueve()
    {
        System.out.println(this.nombre + " corre...");
    }
}