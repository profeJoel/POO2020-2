package EjemploPokemon;

import java.util.Scanner;

public class EjemploPokemon{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Entrenador ash = new Entrenador("Ash", "Pueblo Paleta");
        Entrenador misty = new Entrenador("Misty", "Ciudad Celeste");
        Entrenador brock = new Entrenador("Brock", "Ciudad Plateada");

        ash.llenarEspacioPokemon();
        System.out.println(ash);
        
        misty.llenarEspacioPokemon();
        System.out.println(misty);

        //brock.llenarEspacioPokemon();
        //System.out.println(brock);
        
        Combate gimnasioCiudadCeleste = new Combate(ash, misty, "Arcoiris");
        gimnasioCiudadCeleste.iniciaCombate();

        gimnasioCiudadCeleste = null;

        System.out.println(">>>>>>>Luego del Enfrentamiento:");
        System.out.println(ash);
        System.out.println(misty);

    }
}