/**
 * Clase asbtracta Animal, donde se describe el comportamiento de un animal en general
 */
package ClasesAbstractas;
public abstract class Animal{
    public abstract void haceRuido(); //metodo abstracto no tiene cuerpo
    public void duerme()
    {
        System.out.println("esta zZzZz....");
    }
}