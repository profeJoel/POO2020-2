package EjemploBanco;

public class Credito extends ProductoBancario{
    //Atributos
    protected double monto;
    protected int cantCuotasTotal;
    protected int cantCuotasPagadas;
    protected double tasaInteres;
    protected double montoAbonado;
    protected double saldo;

    //metodos
    public Credito(int id, Cliente titular, double monto, int cantCuotas, double tasa)
    {
        super(id, titular);
        this.monto = monto;
        this.cantCuotasTotal = cantCuotas;
        this.cantCuotasPagadas = 0;
        this.tasaInteres = tasa;
        this.montoAbonado = 0;
        this.saldo = monto;
    }
    public Credito(int id, double monto, int cantCuotas, double tasa)
    {
        super(id);
        this.monto = monto;
        this.cantCuotasTotal = cantCuotas;
        this.cantCuotasPagadas = 0;
        this.tasaInteres = tasa;
        this.montoAbonado = 0;
        this.saldo = monto;
    }

    public void pagarCuota()
    {
        if(this.cantCuotasPagadas < this.cantCuotasTotal)
        {
            double montoCuota = this.monto / this.cantCuotasTotal;
            this.montoAbonado += montoCuota;
            this.cantCuotasPagadas++;
        }
        else
            System.out.println("No existe deuda disponible...");
    }

}