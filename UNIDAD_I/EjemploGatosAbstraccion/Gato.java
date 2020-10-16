//package EjemploGatosAbstraccion;

public class Gato{
    //Atributos
    private String name;
    private String sex;
    private int age;
    private int weight;
    private String color;
    private String texture;

    //Métodos
    public Gato(String nombre, String sexo, int edad, int peso, String color, String textura)
    {
        //this indica que es un atributo del objeto
        this.name = nombre;
        this.sex = sexo;
        this.age = edad;
        this.weight = peso;
        this.color = color;
        this.texture = textura;
    }

    public void eat()
    {
        System.out.println(this.name + " esta comiendo algo...");
    }

    public void eat( String algo)
    {
        System.out.println(this.name + " esta comiendo " + algo);
    }

    public void move()
    {
        System.out.println(this.name + " se está moviendo...");
    }
    public void meow()
    {
        System.out.println(this.name + " esta maullando...");
    }
    
    public void purr()
    {
        System.out.println(this.name + " esta ronroneando...");
    }
    
    public void hunt_mice()
    {
        System.out.println(this.name + " esta cazando un raton");
    }

    public void changeColor(String nuevoColor)
    {
        String[] colores = {"blanco", "negro", "rubio", "castano", "rojizo", "marrón", "gris"};
        boolean colorAceptado = false;
        for( String color: colores)
        {
            //System.out.println("color: " + color + " Nuevo color: " + nuevoColor);
            // == compara objetos -> el String color era distintos del String nuevoColor -> es por referencia- > la misma memoria
            //.equals compara el contenido -> revisa los caracteres del String
            if(nuevoColor.equals(color))
                colorAceptado = true;
        }
        if(colorAceptado)
            this.color = nuevoColor;
        else
            System.out.println("El color " + nuevoColor + " NO es Aceptado");
    }

    //Getter y Setter
    public String getName(){
        return this.name;
    }

    public String getColor(){
        return this.color;
    }


    
}