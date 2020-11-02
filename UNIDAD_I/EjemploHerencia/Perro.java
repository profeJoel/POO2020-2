package EjemploHerencia;

public class Perro extends Animal{
    //atributos

    //metodos
    public Perro(String name)
    {
        super(name);
    }

    public void changeName(String newName)
    {
        //asignacion atributo protected
        this.name = newName;
        //acceder desde metodos public
        //this.setName(newName);
    }

    @Override
    public void makeSound()
    {
        System.out.println(this.name + " ladra woow!");
    }

    public void makeSound(String something)
    {
        System.out.println(this.name + " ladra " + something);
    }
}