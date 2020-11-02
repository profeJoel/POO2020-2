package EjemploPokemon;
import java.util.Scanner;

public class Entrenador{
    //atributos
    private String nombre;
    private String origen;
    private String genero;
    private int edad;
    private String[] medalla;
    private int nivel;
    private Pokemon[] espacioPokemon;
    private int vacante;
    private int lugarMedalla;

    //métodos
    /** Método Constructor */
    public Entrenador(String nombre, String origen)
    {
        this.nombre = nombre;
        this.origen = origen;
        this.espacioPokemon = new Pokemon[3];
        this.vacante = 0;
        this.lugarMedalla = 0;
        this.medalla = new String[8];
    }

    public Entrenador(String nombre, String origen, int edad)
    {
        this.nombre = nombre;
        this.origen = origen;
        this.edad = edad;
        this.espacioPokemon = new Pokemon[3];
        this.vacante = 0;
        this.lugarMedalla = 0;
        this.medalla = new String[8];
    }

    public void capturaPokemon()
    {
        Scanner input = new Scanner(System.in);
        String nombre, tipo;
        int pc;
        //Asegura que no se agregarán más de 3 pokemon al array
        if(this.vacante >= 0)
        {
            System.out.println("Ingrese el nombre del pokemon: ");
            nombre = input.next();
            System.out.println("Ingrese el tipo del pokemon: ");
            tipo = input.next();
            System.out.println("Ingrese el PC del pokemon: ");
            pc = input.nextInt();

            Pokemon nuevo = new Pokemon(nombre, tipo, pc);
            this.espacioPokemon[this.vacante] = nuevo;
            this.vacante++;
            if(this.vacante == 3)
                this.vacante = -1;
        }
    }

    public void llenarEspacioPokemon()
    {
        for(int i=0; i<3; i++)
            this.capturaPokemon();
    }

    public Pokemon getPokemon(int indice)
    {
        return this.espacioPokemon[indice];
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void ganaMedalla(String nombreMedalla)
    {
        this.medalla[lugarMedalla] = nombreMedalla;
        this.lugarMedalla++;
    }

    public String toString()
    {
        return "\n Entrenador " + this.nombre + " de " + this.origen + " con " + this.medalla[0] + ": \n " + this.espacioPokemon[0] + "\n " + this.espacioPokemon[1] + "\n " + this.espacioPokemon[2]; 
    }

}