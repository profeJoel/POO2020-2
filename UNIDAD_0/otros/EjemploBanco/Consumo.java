package EjemploBanco;

public class Consumo extends Credito{
    private int cantCuotasGracia;
    private int cantCuotasDesface;

    public Consumo(int id, Cliente titular, double monto, int cantCuotas, double tasa, int cuotasGracia, int cuotasDesface)
    {
        super(id, titular, monto, cantCuotas, tasa);
        this.cantCuotasDesface = cuotasDesface;
        this.cantCuotasGracia = cuotasGracia;
    }
    
    public Consumo(int id, double monto, int cantCuotas, double tasa, int cuotasGracia, int cuotasDesface)
    {
        super(id, monto, cantCuotas, tasa);
        this.cantCuotasDesface = cuotasDesface;
        this.cantCuotasGracia = cuotasGracia;
    }
}