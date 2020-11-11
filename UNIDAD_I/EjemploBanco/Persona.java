package EjemploBanco;

import java.time.LocalDate;

public class Persona{
    private int id;
    private String nombre;
    private LocalDate fechaNacimiento;

    public Persona(int id, String nombre, LocalDate fecha)
    {
        super();
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fecha;
    }

    public int getId()
    {
        return this.id;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public LocalDate getFechaNacimiento()
    {
        return this.fechaNacimiento;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    /*
    public boolean setId(int id)
    {
        if(id <= 0)
            return false;
        else
            this.id = id;
        return true;
    }
    */

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(LocalDate fecha)
    {
        this.fechaNacimiento = fecha;
    }

    public void mostrar()
    {
        System.out.println("Persona >> id: " + this.id + ", nombre: " + this.nombre + ", fecha Nacimiento: " + this.fechaNacimiento);
    }

    public boolean esMayorDeEdad()
    {
        return this.getAge() >= 18;
    }

    public int getAge()
    {
        LocalDate ahora = LocalDate.now();
        return ahora.getYear() - this.fechaNacimiento.getYear();
    }

    public static boolean mayor(int a, int b)
    {
        return a > b;
    }
}