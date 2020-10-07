public class EjemploMatematicas{
    public static void main(String[] args){
        int x = 5, y = 18;
        int mayor, menor;

        /*
        if(x >= y)
            mayor = x;
        else
            mayor = y;
        */
        mayor = Math.max(x,y);
        System.out.println("El mayor es: " + mayor);
        menor = Math.min(x,y);
        System.out.println("El menor es: " + menor);

        double raiz = Math.sqrt(4);
        System.out.println("La raiz de 4 es: " + raiz);

        double azar = Math.random();
        System.out.println("Numero Random: " + azar);
        
        int azarEntero = (int) (Math.random() * 100 + 1); // 0 a 100
        System.out.println("Numero Random entre 0 y 100: " + azarEntero);

    }
}