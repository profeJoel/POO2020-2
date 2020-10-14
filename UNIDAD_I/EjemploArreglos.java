import java.util.Scanner;

public class EjemploArreglos{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        // en C : int a[4]; // declaracion y asignacion de memoria

        // en Java: int[] a;        //declaracion
        //        : a = new int[4]; // asignacion de memoria

        //Vector: int, float, String, char, double
        /*
        int[] a;
        a = new int[4];

        for(int x = 0; x < 4; x++)
        {
            System.out.println("Ingrese un valor entero: ");
            a[x] = input.nextInt();
        }

        for(int x: a)
            System.out.println("Valor: " + x);
        */

        //Matriz
        double[][] matriz;
        matriz = new double[3][3];
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                System.out.println("Ingrese el valor [" + i + "," + j + "]:");
                matriz[i][j] = input.nextDouble();
            }
        }

        /*
        for(int i = 0; i < 3; i++)
            for(double x: matriz[i])
                System.out.println("Valor: " + x);
        */

        //Forma de impresion de matriz
        for(int i = 0; i < 3; i++)
        {
            for(double x: matriz[i])
                System.out.print(" " + x);
            System.out.println(" ");
        }

        //Cubo: char[][][] cubo;
        //    : cubo = new char[2][2][2];
    }
}