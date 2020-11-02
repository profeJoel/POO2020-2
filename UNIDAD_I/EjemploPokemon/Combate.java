package EjemploPokemon;

public class Combate{
    //Atributos
    private Entrenador p1, p2;
    private String nombreMedalla;

    //Métodos
    public Combate(Entrenador p1, Entrenador p2, String nombreMedalla)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.nombreMedalla = nombreMedalla;
    }

    public void iniciaCombate()
    {
        int contador = 0;
        for(int i=0; i<3; i++)
            if(p1.getPokemon(i).getPc() >= p2.getPokemon(i).getPc())
                contador++;
        
        if(contador >= 2)
        {
            System.out.println("El ganador es " + p1.getNombre());
            p1.ganaMedalla(nombreMedalla);
        }
        else
            System.out.println("El ganador es " + p2.getNombre());
    }

}