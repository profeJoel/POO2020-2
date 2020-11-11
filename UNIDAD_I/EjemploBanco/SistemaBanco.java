package EjemploBanco;

import java.util.Scanner;
import java.time.LocalDate;

public class SistemaBanco{
    private String nombre;

    //static permite que un atributo/metodo pueda usarse sin necesidad de crear un objeto de la clase
    public static void ingresarCliente(Cliente[] lista, int indice)
    {
        Scanner leer = new Scanner(System.in);
        int id, yy, mm, dd;
        String nombre;
        LocalDate fecha1, fecha2;
        Cliente nuevoCliente;

        System.out.println("\n\nIngrese los valores del Cliente: ");
        System.out.println("id: ");
        id = leer.nextInt();
        System.out.println("nombre: ");
        nombre = leer.next();
        System.out.println("\nFecha Nacimiento: ");
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
        }while(yy < 1850 || yy > LocalDate.now().getYear());
        fecha1 = LocalDate.of(yy, mm, dd);
        System.out.println("\nFecha Incorporacion: ");
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
        }while(yy < 1850 || yy > LocalDate.now().getYear());
        fecha2 = LocalDate.of(yy, mm, dd);

        nuevoCliente = new Cliente(id, nombre, fecha1, fecha2);
        
        lista[indice] = nuevoCliente;
    }

    public static void ingresarTodosClientes(Cliente[] lista, int N)
    {
        for(int i=0; i<N; i++)
            ingresarCliente(lista, i);
    }

    public static void imprimirTodoClientes(Cliente[] lista)
    {
        for(Cliente actual: lista)
            actual.mostrar();
    }

    public SistemaBanco(String nombre)
    {   
        this.nombre = nombre;
    }
    public void holaMundo()
    {
        System.out.println("Hola Mundo, Bienvenido a banco " + this.nombre);
    }

    public static void main(String[] args)
    {
        SistemaBanco ULagos = new SistemaBanco("ULagos");
        ULagos.holaMundo();
        /*if(Persona.mayor(5,3))
            System.out.println("Es mayor");
        else
            System.out.println("Es menor");
        */

        int numeroClientes = 1;
        Cliente[] listaClientes = new Cliente[numeroClientes];

        ingresarTodosClientes(listaClientes, numeroClientes);
        imprimirTodoClientes(listaClientes);

        listaClientes[0].ingresarProductoBancario();
        listaClientes[0].ingresarProductoBancario();
        listaClientes[0].ingresarProductoBancario();
        listaClientes[0].ingresarProductoBancario();
        listaClientes[0].getProducto(0).mostrar();
        listaClientes[0].getProducto(1).mostrar();
        listaClientes[0].getProducto(2).mostrar();
        listaClientes[0].getProducto(3).mostrar();
    }
}