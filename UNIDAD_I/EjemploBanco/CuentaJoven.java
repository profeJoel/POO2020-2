package EjemploBanco;

public class CuentaJoven extends Cuenta{
    //atributos
    private double porcentajeGanancia;

    //metodos
    public CuentaJoven(int id, Cliente titular, double saldo)
    {
        super(id,titular,saldo);
    }
    public CuentaJoven(int id, double saldo)
    {
        super(id,saldo);
    }
    public CuentaJoven(int id)
    {
        super(id);
    }

    /**
     * esTitularValido
     * true - si titular es mayor de edad y menor que 25 años
     * false - sino
     */
    public boolean esTitularValido()
    {
        int edad = this.titular.getAge();
        return (edad >= 18 && edad <= 25);
    }

    @Override
    public void retiro(double monto)
    {
        if(monto < 0)
            System.out.println("El monto solicitado debe ser positivo...");
        else
        {
            if(this.esTitularValido())
            {
                if(this.saldo >= monto)
                {
                    this.saldo -= monto;
                    System.out.println("Retiro aceptado por: " + monto + ", Nuevo Saldo: " + this.saldo);
                }
                else
                    System.out.println("El monto solicitado debe existir en el fondo del cliente...");
            }
            else
                System.out.println("El titular no es valido, consulte con un ejecutivo...");
        }
    }

    @Override
    public void mostrar()
    {
        System.out.println("Producto CuentaJoven > id: " + this.id + " Titular: " + this.titular.getNombre() + " Saldo: " + this.saldo);
    }

}