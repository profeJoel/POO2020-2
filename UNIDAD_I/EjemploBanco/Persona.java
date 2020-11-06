package EjemploBanco;

import java.util.Date;

public class Persona{
    private int id;
    private String nombre;
    private SimpleDate fechaNacimiento;

    public Persona(int id, String nombre, SimpleDate fecha)
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

    public Date getFechaNacimiento()
    {
        return this.fechaNacimiento;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public bool setId(int id)
    {
        if(id <= 0)
            return false;
        else
            this.id = id;
        return true;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(SimpleDate fecha)
    {
        this.fechaNacimiento = fecha;
    }

    public void mostrar()
    {
        System.out.println("Persona >> id: " + this.id + ", nombre: " + this.nombre + ", fecha Nacimiento: " + this.fechaNacimiento.toString());
    }

    public bool esMayorDeEdad()
    {
        SimpleDate ahora = SimpleDate(2020,11,04);
        return this.fechaNacimiento.calculateAge(ahora) >= 18;
    }

    public int getAge()
    {
        SimpleDate ahora = SimpleDate(2020,11,04);
        return this.fechaNacimiento.calculateAge(ahora);
    }
}