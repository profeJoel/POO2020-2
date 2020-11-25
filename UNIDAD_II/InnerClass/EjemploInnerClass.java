/**
 * Outer Class y Inner Class
 * Outer Class es cualquier clase
 * Inner Class son clases que pertenecen (y se crean ) dentro de otra clase (Outer Class)
 */

package InnerClass;

public class EjemploInnerClass{
    public static void main(String[] args)
    {
        Posicion miPosicion = new Posicion("Donde estoy"); //Creacion objeto Outer Class
        Posicion.Coordenada miCoordenada = miPosicion.new Coordenada(0,0); //Creacion objeto Inner Class

        System.out.println("Posicion " + miPosicion.descripcion + " [" + miCoordenada.x + "," + miCoordenada.y + "]");
    }
}