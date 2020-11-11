package EjemploBanco;

public class Cuenta extends ProductoBancario{
    //atributos
    protected double saldo;

    //metodos
    public Cuenta(int id, Cliente titular, double saldo)
    {
        super(id,titular);
        if(saldo < 0)
            System.out.println("Saldo debe ser mayor que 0...");
        else
            this.saldo = saldo;
    }

    public Cuenta(int id, double saldo)
    {
        super(id);
        if(saldo < 0)
            System.out.println("Saldo debe ser mayor que 0...");
        else
            this.saldo = saldo;
    }

    public Cuenta(int id)
    {
        super(id);
        this.saldo = 0;
    }

    public void ingreso(double monto)
    {
        if(monto < 0)
            System.out.println("El monto ingresado debe ser positivo...");
        else
            this.saldo += monto;
            //this.saldo = this.saldo + monto;
    }

    public void retiro(double monto)
    {
        if(monto < 0)
            System.out.println("El monto solicitado debe ser positivo...");
        else
        {
            if(this.saldo >= monto)
            {
                this.saldo -= monto;
                System.out.println("Retiro aceptado por: " + monto + ", Nuevo Saldo: " + this.saldo);
            }
            else
                System.out.println("El monto solicitado debe existir en el fondo del cliente...");
        }
    }

}