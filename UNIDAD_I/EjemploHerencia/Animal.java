package EjemploHerencia;

public class Animal{
    //Atributos
    protected String name; // acceso desde sub-clases solamente

    //Metodos
    public Animal(String name)
    {
        super(); // marcar el constructor para la herencia
        this.name = name;
    }

    public void eat(String something)
    {
        System.out.println(this.name + " come " + something);
    }

    public void makeSound()
    {
        System.out.println(this.name + " hace un sonido...");
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String n)
    {
        this.name = n;
    }
}