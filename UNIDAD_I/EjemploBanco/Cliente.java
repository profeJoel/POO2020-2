package EjemploBanco;
import java.util.Scanner;

public class Cliente extends Persona{
    //atributos
    private ProductoBancario[] productos;
    private int indiceProducto;
    private SimpleDate fechaIncorporacion;
    private boolean estado;

    //metodos
    public Cliente(int id, String nombre, SimpleDate fecha, SimpleDate fecha2)
    {
        super(id, nombre, fecha);
        this.productos = new ProductoBancario[10];
        this.indiceProducto = 0;
        this.fechaIncorporacion = fecha2;
        this.estado = true; // true habilitado, false deshabilitado
    }

    public void ingresarProductoBancario()
    {
        if(this.indiceProducto >= 10)
            System.out.println("No se puede ingresar mas productos, Consulte con una ejecutiva...");
        else
        {
            Scanner leer = new Scanner(System.in);
            int id;
            System.out.println("Número de serie del producto");
            id = leer.nextInt();
            ProductoBancario nuevoProducto = new ProductoBancario(id);

            this.productos[this.indiceProducto] = nuevoProducto;
            this.indiceProducto++;
        }
    }

    public void ingresarTodosProductosBancarios()
    {
        N = 10 - this.indiceProducto;
        for(int i = 0; i< N; i++)
            this.ingresarProductoBancario();
    }

    public ProductoBancario getProducto(int indice)
    {
        if(indice < 0 || indice >= 10)
            System.out.println("Hay un error, indice esta fuera del arreglo de productos");
        else
            return this.productos[indice];
    }

}