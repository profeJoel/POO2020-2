package EjemploPokemon;

import java.util.Random;

public class Pokemon{
    //Atributos
    private String nombre;
    private String tipo;
    private int vida;
    private int exp;
    private int pc;
    private int puntosAtaque;
    private int puntosAtaqueCargado;
    private String estado;

    //Metodos
    public Pokemon(String nombre, String tipo, int pc)
    {
        this.nombre = nombre;
        this.tipo = tipo;
        this.pc = pc;
        Random r = new Random(pc);
        this.puntosAtaque = r.nextInt(11) + 10; // random entre 0 y 10, + el minimo valor 10 -> entre 10 y 20
        this.puntosAtaqueCargado = r.nextInt(51) + 50; // random entre 0 y 50, + el minimo valor 50 -> entre 50 y 100
    }

    public int getPc()
    {
        return this.pc;
    }

    public String toString()
    {
        return "\nEl pokemon se llama " + this.nombre + " de tipo " + this.tipo + " con PC : " + this.pc + "\n - Ataque simple = " + this.puntosAtaque + "\n - Ataque Cargado = " + this.puntosAtaqueCargado;
    }

}