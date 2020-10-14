import java.util.Scanner;

public class EjemploMetodos{
    // metodos: tipoVisibilidad tipoDato nombreMetodo(tipoDato argumento1, ...)

    public static void mayor(int edad1, int edad2)
    {
        if(edad1 > edad2)
            System.out.println("Edad: " + edad1 + " es mayor que " + edad2);
        else
            if(edad1 < edad2)
                System.out.println("Edad: " + edad2 + " es mayor que " + edad1);
            else
                System.out.println("Las edades : " + edad1 + " y " + edad2 + " son iguales.");
    }

    public static void mayor(int edad1, int edad2, int edad3)
    {
        if(edad1 > edad2 && edad1 > edad3)
            System.out.println("Edad: " + edad1 + " es mayor que " + edad2 + " y " + edad3);
        else
            if(edad2 > edad1 && edad2 > edad3)
                System.out.println("Edad: " + edad2 + " es mayor que " + edad1 + " y " + edad3);
            else
                if(edad3 > edad1 && edad3 > edad2)
                    System.out.println("Edad: " + edad3 + " es mayor que " + edad1 + " y " + edad2);
                else
                    System.out.println("Las edades : " + edad1 + " , " + edad2 +  " y " + edad3 +" son iguales.");
    }

    public static void mayor(int[] edades)
    {
        int mayor = edades[0];
        for(int edad: edades)
        {
            if(edad > mayor)
                mayor = edad;
        }
        System.out.println("El mayor de todos es: " + mayor);
    }

    public static double promedioEdades(int[] edades)
    {
        double promedio;
        int suma = 0, contador = 0;
        for(int e: edades)
        {
            suma += e;
            contador++;
        }
        promedio = (double) suma / contador;
        return promedio;
    }

    public static void verificarEdad(int edad)
    {
        if(edad >= 18)
            System.out.println("Si es Mayor de Edad");
        else
            System.out.println("NO, es menor de edad");
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //System.out.println("Ingrese su edad");
        //int edad = input.nextInt();
        int[] edades;
        edades = new int[5];
        for(int i = 0; i<5; i++)
        {
            System.out.println("Ingrese la edad: ");
            edades[i] = input.nextInt();
        }

        //llamado al metodo
        //verificarEdad(edad);

        for(int e: edades)
        {
            System.out.print("Edad: " + e + " : ");
            verificarEdad(e);
        }

        System.out.println("El promedio de edades es: " + promedioEdades(edades));

        // Method Overloading -> Sobrecarga de Metodos
        mayor(edades[0], edades[1]); // con 2 parametros
        mayor(edades[0], edades[1], edades[2]); // con 3 parametros
        mayor(edades); // con 1 parametro (arreglo)

    }
}