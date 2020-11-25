/**
 * Abstraccion es un proceso de ocultar ciertos detalles de programacion para solamente mostrar los tipos de acciones en una clase
 * 
 * Clases abstractas es que no pueden crear objetos , tambien se denominan interfaces
 * Un Clase abstracta solemente puede ser accedida desde una herencia
 * 
 * Metodos abstractos solo pueden pertenecer a clases abstractas y no tienen cuerpo (no codigo).
 */
package ClasesAbstractas;
 public class EjemploAbstraccion{
    public static void main(String[] args)
    {
        Gato michi = new Gato("Michi");
        michi.haceRuido();
        michi.duerme();
    }
 }