package EjemploHerencia;

public class Vaca extends Animal{
    //atributos

    //metodos
    public Vaca(String name)
    {
        super(name);
    }

    @Override
    public void makeSound()
    {
        System.out.println(this.name + " brama Muu!");
    }
    
    public void makeSound(String something)
    {
        System.out.println(this.name + " brama " + something);
    }
}