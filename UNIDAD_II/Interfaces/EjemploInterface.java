/**
 * Interfaces son clases Abstractas , pero que solamente tienen metodos vacios (o sin cuerpo)
 */

package Interfaces;
 public class EjemploInterface{
    public static void main(String[] args)
    {
        Gato michi = new Gato("Michi");
        michi.haceRuido();
        michi.duerme();
        michi.seMueve();
        
        /** Expresiones Lambda son secciones de código resumidas
         * Son equivalentes a métodos comprimidos
         * 
         * parametros -> expresion
         * (p1,p2,...,pn) -> expresion
         * (p1,p2,...,pn) -> { bloques de código };
         * 
         * implementar codigo en un objeto
         */
        SerVivo perro = (comida) -> ("El perro se come " + comida);

        imprimirElemento(perro, "hueso");
    }

    public static void imprimirElemento(SerVivo a, String comida)
    {
        String nuevoString = a.come(comida);
        System.out.println("Miren! " + nuevoString);
    }
 }