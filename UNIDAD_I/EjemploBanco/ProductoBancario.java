package EjemploBanco;

public class ProductoBancario{
    // atributos
    private int id;
    private Cliente titular;

    //metodos
    public ProductoBancario(int id, Cliente titular)
    {
        super();
        this.id = id;
        this.titular = titular;
    }

    public ProductoBancario(int id)
    {
        super();
        this.id = id;
        this.titular = null;
    }

    public void mostrar()
    {
        System.out.println("Producto > id: " + this.id + " Titular: " + this.titular.getNombre());
    }
}