package EjemploBanco;

public class CuentaTodopoderosa extends Cuenta{
    //Atributos
    private int tarjetaCredito;
    private double montoCredito;
    private double saldoCredito;

    //metodos
    public CuentaTodopoderosa(int id, Cliente titular, double saldo, int idTarjeta, double montoCredito)
    {
        super(id,titular,saldo);
        this.tarjetaCredito = idTarjeta;
        this.montoCredito = montoCredito;
        this.saldoCredito = montoCredito;
    }
    public CuentaTodopoderosa(int id, double saldo, int idTarjeta, double montoCredito)
    {
        super(id,saldo);
        this.tarjetaCredito = idTarjeta;
        this.montoCredito = montoCredito;
        this.saldoCredito = montoCredito;
    }
    public CuentaTodopoderosa(int id, int idTarjeta, double montoCredito)
    {
        super(id);
        this.tarjetaCredito = idTarjeta;
        this.montoCredito = montoCredito;
        this.saldoCredito = montoCredito;
    }

    
    public void pagarTarjetaCredito(double monto)
    {
        if(monto < 0)
            System.out.println("El monto ingresado debe ser positivo...");
        else
        {
            if(monto > this.montoCredito || this.saldoCredito + monto > this.montoCredito)
                System.out.println("El monto excede el limite de deuda de la tarjeta de credito...");
            else
                this.saldoCredito += monto;
                //this.saldo = this.saldo + monto;
        }
    }

    public void comprarTarjetaCredito(double monto)
    {
        if(monto < 0)
            System.out.println("El monto solicitado debe ser positivo...");
        else
        {
            if(this.saldoCredito >= monto)
            {
                this.saldoCredito -= monto;
                System.out.println("Retiro aceptado por: " + monto + ", Nuevo Saldo de Tajeta de Credito: " + this.saldoCredito);
            }
            else
                System.out.println("El monto solicitado debe existir en el fondo del cliente...");
        }
    }

}