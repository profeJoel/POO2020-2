public class EjemploControl{
    public static void main(String[] args){
        //Arreglos
        int a = 1, b = 20, c = 12;
        int[] v = {5,3,7,5,8};
        String[] autos = {"Toyota","Rayo McQueen","Tesla","Mitsubishi","Mercedes"};

        // If -Else
        /*if(a > b && a > c)
            System.out.println("El mayor es " + a);
        else
        {
            if(b > a && b > c)
                System.out.println("El mayor es " + b);
            else
                System.out.println("El mayor es " + c);
        }

        // Switch
        switch(a) {
            case 1:
                System.out.println("Es Lunes");
                System.out.println("Es Lunes");
                System.out.println("Es Lunes");
                System.out.println("Es Lunes");
                System.out.println("Es Lunes");
                break;

            case 2:
                System.out.println("Es Martes");
                break;
        
            case 3:
                System.out.println("Es Miercoles");
                break;
        
            case 4:
                System.out.println("Es Jueves");
                break;
    
            case 5:
                System.out.println("Es Viernes");
                break;
        
            case 6:
                System.out.println("Es Sabado");
                break;
        
            case 7:
                System.out.println("Es Domingo");
                break;

            default:
                System.out.println("Fuera de rango, no existe dia");
                break;
        }*/
        // While - Do-While
        /*while(c > 0)
        {
            System.out.println("Estoy dentro del Ciclo");
            c--;
        }
        c = -5;
        do{
            System.out.println("Estoy dentro del DoWhile");
            c += 1;
        }while(c < 0);
        */
        // For - Foreach

        /*for(int i = 0; i < 5; i++)
            System.out.println("El valor de v["+i+"] es: " + v[i]);
        */
        //for (tipoDato nombreVariable : VariableIterable)
        /*for(int x : v)
            System.out.println("El siguiente valor de v es: " + x);*/

        for (String auto : autos)
            System.out.println("El siguiente auto es: " + auto);

    }
}