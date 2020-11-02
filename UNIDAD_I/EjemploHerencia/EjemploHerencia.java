package EjemploHerencia;

import java.util.Scanner;

public class EjemploHerencia{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        Perro chocolo = new Perro("Chocolo");
        Gato garfield = new Gato("Garfield");
        Vaca lola = new Vaca("Lola");
        Serpiente juanS = new Serpiente("JuanS");

        chocolo.eat("alimento para perro");
        garfield.eat("Lazanna");
        lola.eat("pasto");
        juanS.eat("no nos gustaria saber...");

        /* Para comprobar acceso de datos de super clase
        chocolo.changeName("Scooby");
        chocolo.eat("alimento para perro");

        chocolo.name = "Spike";
        System.out.println("El perro se llama " + chocolo.name);
        */

        chocolo.makeSound();
        garfield.makeSound();
        lola.makeSound();
        juanS.makeSound();

        /*
        chocolo.makeSound("GOOF");
        garfield.makeSound("MIAUUUU");
        lola.makeSound("MUUUUUUUU");
        juanS.makeSound("SSSSSSSSSSZZZZZZZZZ");
        */
    }
}