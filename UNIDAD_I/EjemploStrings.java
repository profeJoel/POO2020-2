public class EjemploStrings{
    public static void main(String[] args){
        String texto = "este es un \"ejemplo\" para este ejercicio de POO";
        /** 
         * \n para salto de linea
         * \r para retorno de carril (sobreescribe)
         * \t para tabulacion (sangria)
         * \b para retroceso (sobreescribe un espacio)
         * \f Form feed (salto de linea y queda en la misma posicion de la siguiente linea)
        */
        
        /*
        System.out.println("El texto es: " + texto);

        System.out.println("El largo del texto es: " + texto.length());
        // los metodos en Java se escriben asi: ejemploFuncionDeString() -> indexOf()
        System.out.println("El caracter 'a' esta en la posicion " + texto.indexOf("a") + " del texto");
        System.out.println("La palabra 'para' esta en la posicion " + texto.indexOf("para") + " del texto");
        System.out.println("La palabra 'este' esta en la posicion " + texto.indexOf("este") + " del texto");

        String textoAdicional = "para el dia Miercoles -> \" \' \\";
        //String textoCompleto = texto + " " + textoAdicional;
        String textoCompleto = texto.concat(" " + textoAdicional);
        //System.out.println("El texto completo es: " + texto + " " + textoAdicional);
        System.out.println("El texto completo es: " + textoCompleto);
        */

        //int x = 10, y = 20;
        //int z = x + y; // da 30

        //String x = "10", y = "20";
        //String z = x + y; // da "1020"

        
        String x = "10";
        int y = 20;
        String z = x + y; // da "1020"
        System.out.println("El resultado : " + z);

        

    }
}