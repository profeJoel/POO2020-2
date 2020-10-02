import java.util.Scanner;

public class EjemploEntrada{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese su edad");
        int edad = input.nextInt();
        
        System.out.println("Ingrese su edad");
        String nombre = input.next();

        System.out.println("Edad : " + edad);
        System.out.println("Nombre : " + nombre);

        input.close();
    }
}