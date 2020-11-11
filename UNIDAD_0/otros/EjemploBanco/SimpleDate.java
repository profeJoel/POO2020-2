package EjemploBanco;

public class SimpleDate{
    private int year;
    private int month;
    private int day;

    public SimpleDate(int yy, int mm, int dd)
    {
        this.year = yy;
        this.month = mm;
        this.day = dd;
    }

    public int getYear()
    {
        return this.year;
    }

    public String toString()
    {
        return this.day + "/" + this.month + "/" + this.year;
    }

    public int calculateAge(SimpleDate o)
    {
        if(this.year > o.getYear())
            return this.year - o.getYear();
        else
            return o.getYear() - this.year;
    }

}