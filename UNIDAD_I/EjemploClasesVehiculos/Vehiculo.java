package EjemploClasesVehiculos;

import java.util.Scanner;

public class Vehiculo{
    //atributos
    public String marca;
    public String modelo;
    public int anio;

    //metodos
    //Constructor
    public Vehiculo(String marca, String modelo, int anio)
    {
        //this -> indicar que el atributo pertenece al objeto
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public String toString()
    {
        String salida = "\n\tMarca: " + this.marca + "\n\tModelo: " + this.modelo + "\n\tAnio: " + this.anio;
        return salida;
    }
}