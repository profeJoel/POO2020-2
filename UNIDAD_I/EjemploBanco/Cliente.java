package EjemploBanco;
import java.util.Scanner;
import java.time.LocalDate;

public class Cliente extends Persona{
    //atributos
    private ProductoBancario[] productos;
    private int indiceProducto;
    private LocalDate fechaIncorporacion;
    private boolean estado;

    //metodos
    public Cliente(int id, String nombre, LocalDate fecha, LocalDate fecha2)
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
            int id, opcion, saldoInicial, idTarjeta, montoInicial,cantCuotas, cuotasGracia, cuotasDesface;
            double monto, tasa, tasacion, prima;
            String descripcion;
            ProductoBancario nuevoProducto = null;
            do{
                System.out.println("Ingrese la opcion a contratar:\n 1.- CuentaJoven\n 2.- Cuenta Todopoderosa\n 3.- Credito Hipotecario\n 4.- Credito Consumo");
                opcion = leer.nextInt();
            }while(opcion < 1 || opcion > 4);
            switch(opcion)
            {
                case 1:
                        System.out.println("Número de serie del producto");
                        id = leer.nextInt();
                        System.out.println("Saldo Inicial: ");
                        saldoInicial = leer.nextInt();
                        CuentaJoven nuevoProductoCuentaJoven = new CuentaJoven(id, this, saldoInicial);
                        nuevoProducto = nuevoProductoCuentaJoven;
                        break;
                case 2:
                        System.out.println("Número de serie del producto");
                        id = leer.nextInt();
                        System.out.println("Saldo Inicial: ");
                        saldoInicial = leer.nextInt();
                        System.out.println("Numero tarjeta credito: ");
                        idTarjeta = leer.nextInt();
                        System.out.println("Monto Credito Inicial: ");
                        montoInicial = leer.nextInt();
                        CuentaTodopoderosa nuevoProductoCuentaTodopoderosa = new CuentaTodopoderosa(id, this, saldoInicial, idTarjeta, montoInicial);
                        nuevoProducto = nuevoProductoCuentaTodopoderosa;
                        break;
                case 3:
                        System.out.println("Número de serie del producto");
                        id = leer.nextInt();
                        System.out.println("Monto Deuda: ");
                        monto = leer.nextDouble();
                        System.out.println("Cant Cuotas: ");
                        cantCuotas = leer.nextInt();
                        System.out.println("Tasa Interes: ");
                        tasa = leer.nextDouble();
                        System.out.println("Descripcion vivienda: ");
                        descripcion = leer.next();
                        System.out.println("Tasacion vivienda: ");
                        tasacion = leer.nextDouble();
                        System.out.println("Prima Incial: ");
                        prima = leer.nextDouble();
                        Hipotecario nuevoProductoHipotecario = new Hipotecario(id, this, monto, cantCuotas, tasa, descripcion, tasacion,prima);
                        nuevoProducto = nuevoProductoHipotecario;
                        break;
                case 4:
                        System.out.println("Número de serie del producto");
                        id = leer.nextInt();
                        System.out.println("Monto Deuda: ");
                        monto = leer.nextDouble();
                        System.out.println("Cant Cuotas: ");
                        cantCuotas = leer.nextInt();
                        System.out.println("Tasa Interes: ");
                        tasa = leer.nextDouble();
                        System.out.println("Cant Cuotas de Gracia: ");
                        cuotasGracia = leer.nextInt();
                        System.out.println("Cant Cuotas de Desface: ");
                        cuotasDesface = leer.nextInt();
                        Consumo nuevoProductoConsumo = new Consumo(id, this, monto, cantCuotas, tasa, cuotasGracia, cuotasDesface);
                        nuevoProducto = nuevoProductoConsumo;
                        break;
            }

            this.productos[this.indiceProducto] = nuevoProducto;
            this.indiceProducto++;
        }
    }

    public void ingresarTodosProductosBancarios()
    {
        int N = 10 - this.indiceProducto;
        for(int i = 0; i< N; i++)
            this.ingresarProductoBancario();
    }

    public ProductoBancario getProducto(int indice)
    {
        if(indice < 0 || indice >= 10)
        {
            System.out.println("Hay un error, indice esta fuera del arreglo de productos");
            return null;
        }
        else
            return this.productos[indice];
    }

}