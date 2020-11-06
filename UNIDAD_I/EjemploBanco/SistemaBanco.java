package EjemploBanco;

import java.util.Scanner;

public class SistemaBanco{

    //static permite que un atributo/metodo pueda usarse sin necesidad de crear un objeto de la clase
    public static void ingresarCliente(Cliente[] lista, int indice)
    {
        Scanner leer = new Scanner(System.in);
        int id, yy, mm, dd;
        String nombre;
        SimpleDate fecha1, fecha2;
        Cliente nuevoCliente;

        System.out.println("Ingrese los valores del Cliente: ");
        System.out.println("id: ");
        id = leer.nextInt();
        System.out.println("nombre: ");
        nombre = leer.next();
        System.out.println("Fecha Nacimiento: ");
        System.out.println("Dia: ");
        dd = leer.nextInt();
        System.out.println("Mes: ");
        mm = leer.nextInt();
        System.out.println("Anio: ");
        yy = leer.nextInt();
        fecha1 = new SimpleDate(yy, mm, dd);
        System.out.println("Fecha Incorporacion: ");
        System.out.println("Dia: ");
        dd = leer.nextInt();
        System.out.println("Mes: ");
        mm = leer.nextInt();
        System.out.println("Anio: ");
        yy = leer.nextInt();
        fecha2 = new SimpleDate(yy, mm, dd);

        nuevoCliente = new Cliente(id, nombre, fecha1, fecha2);
        
        lista[indice] = nuevoCliente;
    }

    public static void ingresarTodosClientes(Cliente[] lista, int N)
    {
        for(int i=0; i<N; i++)
            ingresarCliente(lista, i);
    }

    public static void main(String[] args)
    {
        int numeroClientes = 5;
        Cliente[] listaClientes = new Cliente[numeroClientes];

        ingresarTodosClientes(listaClientes, numeroClientes);
    }
}