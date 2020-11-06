package EjemploBanco;

public class Hipotecario extends Credito{
    private String descripcionVivienda;
    private double tasacionVivienda;
    private double primaInicial;

    public Hipotecario(int id, Cliente titular, double monto, int cantCuotas, double tasa, String descVivienda, double tasacionVivienda, double prima)
    {
        super(id, titular, monto, cantCuotas, tasa);
        this.descripcionVivienda = descVivienda;
        this.tasacionVivienda = tasacionVivienda;
        this.primaInicial = prima;
    }

    public Hipotecario(int id, double monto, int cantCuotas, double tasa, String descVivienda, double tasacionVivienda, double prima)
    {
        super(id, titular, monto, cantCuotas, tasa);
        this.descripcionVivienda = descVivienda;
        this.tasacionVivienda = tasacionVivienda;
        this.primaInicial = prima;
    }
}