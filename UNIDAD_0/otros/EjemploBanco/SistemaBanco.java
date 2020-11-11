package EjemploBanco;

import java.util.Scanner;
import java.time.LocalDate;

public class SistemaBanco{

    //static permite que un atributo/metodo pueda usarse sin necesidad de crear un objeto de la clase
    public static void ingresarCliente(Cliente[] lista, int indice)
    {
        Scanner leer = new Scanner(System.in);
        int id, yy, mm, dd;
        String nombre;
        LocalDate fecha1, fecha2;
        Cliente nuevoCliente;

        System.out.println("Ingrese los valores del Cliente: ");
        System.out.println("id: ");
        id = leer.nextInt();
        System.out.println("nombre: ");
        nombre = leer.next();
        System.out.println("Fecha Nacimiento: ");
        do{
            System.out.println("Dia: ");
            dd = leer.nextInt();
        }while(dd < 1 || dd > 31);
        do{
            System.out.println("Mes: ");
            mm = leer.nextInt();
        }while(mm < 1 || mm > 12);
        do{
            System.out.println("Anio: ");
            yy = leer.nextInt();
        }while(yy < 0 || yy > 2020);
        fecha1 = LocalDate.of(yy, mm, dd);
        System.out.println("Fecha Incorporacion: ");
        do{
            System.out.println("Dia: ");
            dd = leer.nextInt();
        }while(dd < 1 || dd > 31);
        do{
            System.out.println("Mes: ");
            mm = leer.nextInt();
        }while(mm < 1 || mm > 12);
        do{
            System.out.println("Anio: ");
            yy = leer.nextInt();
        }while(yy < 0 || yy > 2020);
        fecha2 = LocalDate.of(yy, mm, dd);

        nuevoCliente = new Cliente(id, nombre, fecha1, fecha2);
        
        lista[indice] = nuevoCliente;
    }

    public static void ingresarTodosClientes(Cliente[] lista, int N)
    {
        for(int i=0; i<N; i++)
            ingresarCliente(lista, i);
    }

    public static void imprimirTodosClientes(Cliente[] lista)
    {
        for(Cliente actual: lista)
            actual.mostrar();
    }

    public static void main(String[] args)
    {
        int numeroClientes = 2;
        Cliente[] listaClientes = new Cliente[numeroClientes];

        ingresarTodosClientes(listaClientes, numeroClientes);
        imprimirTodosClientes(listaClientes);

        for(Cliente actual: listaClientes)
        {
            actual.ingresarProductoBancario();
            actual.mostrar();
            actual.getProducto(0).mostrar();
        }
    }
}