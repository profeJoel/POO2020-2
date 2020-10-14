package EjemploClasesVehiculos;

import java.util.Scanner;

public class EjemploClases{

    public static void ingresarVehiculos(Vehiculo[] autos)
    {
        int n = autos.length;
        Scanner leer = new Scanner(System.in);
        String marca, modelo;
        int anio;
        for(int i = 0; i < n; i++)
        {
            //Ingresando cada valor
            System.out.println("\nVehiculo ["+i+"]\nIngrese la Marca del Vehiculo: ");
            marca = leer.next();
            System.out.println("Ingrese la Modelo del Vehiculo: ");
            modelo = leer.next();
            System.out.println("Ingrese el anio del Vehiculo: ");
            anio = leer.nextInt();

            //crear un nuevo objeto
            Vehiculo nuevo;
            nuevo = new Vehiculo(marca, modelo, anio);
            autos[i] = nuevo; // Agregar el nuevo objeto al array
        }
    }

    public static void mostrarVehiculos(Vehiculo[] autos)
    {
        int n = autos.length;
        for(int i = 0; i < n; i++)
            System.out.println("Vehiculo [" + i + "] :" + autos[i]);
    }

    public static void ordenarPorAnio(Vehiculo[] autos)
    {
        int n = autos.length;
        Vehiculo aux;
        int i,j;
        for(i = 0; i < n; i++)
        {
            for(j = 0; j < n; j++)
            {
                /*
                < significa ordenar ascendentemente
                > significa ordenar descedentemente
                */
                if(autos[i].anio > autos[j].anio)
                {
                    aux = autos[i];
                    autos[i] = autos[j];
                    autos[j] = aux;
                }
            }
        }
    }

    public static void ordenarAlfabeticamente(Vehiculo[] autos)
    {
        int n = autos.length;
        Vehiculo aux;
        int i,j;
        for(i = 0; i < n; i++)
        {
            for(j = 0; j < n; j++)
            {
                /*
                < significa ordenar ascendentemente
                > significa ordenar descedentemente
                */
                if(autos[i].marca.charAt(0) < autos[j].marca.charAt(0))
                {
                    aux = autos[i];
                    autos[i] = autos[j];
                    autos[j] = aux;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        /*
        Vehiculo willy;
        willy = new Vehiculo("VolksWagen", "bettle", 1980);

        System.out.println("Marca del auto: " + willy.marca);
        System.out.println("Anio del auto: " + willy.anio);
        */
        int cantidadVehiculos = 5;
        Vehiculo[] autitos; // declaracion del array
        autitos = new Vehiculo[cantidadVehiculos]; // inicializando la cantidad de posiciones

        ingresarVehiculos(autitos);
        System.out.println("\nVehiculos Ingresados");
        mostrarVehiculos(autitos);

        ordenarPorAnio(autitos);
        System.out.println("\nVehiculos Ordenados por Anio");
        mostrarVehiculos(autitos);

        ordenarAlfabeticamente(autitos);
        System.out.println("\nVehiculos Ordenados por Marca");
        mostrarVehiculos(autitos);

    }
}