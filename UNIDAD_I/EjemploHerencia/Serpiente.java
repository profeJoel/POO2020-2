package EjemploHerencia;

public class Serpiente extends Animal{
    //atributos

    //metodos
    public Serpiente(String name)
    {
        super(name);
    }    
    
    @Override
    public void makeSound()
    {
        System.out.println(this.name + " Sisea SSSS!");
    }
    
    public void makeSound(String something)
    {
        System.out.println(this.name + " Sisea " + something);
    }
}