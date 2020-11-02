package EjemploPokemon;

import java.util.Scanner;

public class EjemploGatos{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Entrenador ash = New Entrenador("Ash", "Pueblo Paleta");
        Entrenador misty = New Entrenador("Misty", "Ciudad Celeste");
        Entrenador brock = New Entrenador("Brock", "Ciudad Plateada");

        Combate mesetaAnil = new Combate(ash, misty);

        mesetaAnil.combatir();

        mesetaAnil = null;
        ash = null;
    }
}