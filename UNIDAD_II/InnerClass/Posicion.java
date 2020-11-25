package InnerClass;

public class Posicion{ // Outer Class
    public String descripcion;

    class Coordenada{ // Inner Class
        public int x;
        public int y;

        public Coordenada(int a, int b)
        {
            this.x = a;
            this.y = b;
        }
    }

    public Posicion(String s)
    {
        this.descripcion = s;
    }
}