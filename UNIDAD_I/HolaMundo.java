public class HolaMundo{
    public static void main(String[] args){
        System.out.println("Hola Clase de POO");

        int edad = 25;

        String nombre = "Tom";

        System.out.println("Edad: " + edad + " Nombre: " + nombre);
        /*
        double edadGrande = edad;

        /*
        System.out.println("Nueva Edad: " + edadGrande);

        edadGrande = edadGrande / 2;
        System.out.println("Nueva Edad: " + edadGrande);

        edad = (int) edadGrande;
        
        System.out.println("Retorna Edad: " + edad);
        */

        edad = edad + 2;
        System.out.println(edad);
        if(edad >= 18)
            System.out.println(nombre + " es Mayor de edad");
        else
            System.out.println(nombre + " es Menor de edad");
    }
}