package EjemploGatosAbstraccion;

import java.util.Scanner;

public class EjemploGatos{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String nombre, sexo, color, textura;
        int edad, peso;
        Gato auxiliar; // no tiene memoria -> parecido a un puntero en C

        System.out.println("Ingrese los datos del primer gato:");
        nombre = input.next();
        sexo = input.next();
        edad = input.nextInt();
        peso = input.nextInt();
        color = input.next();
        textura = input.next();
        Gato oscar = new Gato(nombre, sexo, edad, peso, color, textura);
/*
        System.out.println("Ingrese los datos del segundo gato:");
        nombre = input.next();
        sexo = input.next();
        edad = input.nextInt();
        peso = input.nextInt();
        color = input.next();
        textura = input.next();
        Gato luna = new Gato(nombre, sexo, edad, peso, color, textura);
*/
        //Se puede modificar el color de un gato
        
        System.out.println("Ingrese el nuevo color: ");
        color = input.next();
        //oscar.color = color;
        oscar.changeColor(color);

        System.out.println("Se ha cambiado el color a " + oscar.getName() + " con el color " + oscar.getColor());

    }
}