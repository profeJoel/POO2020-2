package EjemploHerencia;

public class Gato extends Animal{
    //atributos

    //metodos
    public Gato(String name)
    {
        super(name);
    }

    @Override
    public void makeSound()
    {
        System.out.println(this.name + " maulla Miau!");
    }

    public void makeSound(String something)
    {
        System.out.println(this.name + " maulla " + something);
    }
}