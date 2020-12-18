package JuegoSprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Proyectil {
    private int x, y, radio, direccion, velocidad, margen, puntoArriba, puntoAbajo, puntoIzquierda, puntoDerecha;
    private int [] zonaImpacto = new int [4];
    private Color color;

    public Proyectil(int x, int y, int radio, Color color, int direccion){
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.color = color;
        this.direccion = direccion;
        this.velocidad = 5 * direccion;
        this.margen = 1;
        this.setZonaImpacto();
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getVelocidad(){
        return this.velocidad;
    }

    public void moverX(){
        this.x += this.velocidad;
    }

    private void setZonaImpacto(){
        this.zonaImpacto[0] = this.x + this.margen;
        this.zonaImpacto[1] = this.y + this.margen;
        this.zonaImpacto[2] = this.radio * 2 - this.margen;
        this.zonaImpacto[3] = this.radio * 2 - this.margen;
        this.setPuntos();
    }

    private void setPuntos(){
        this.puntoAbajo = this.zonaImpacto[1] + this.zonaImpacto[3];
        this.puntoArriba = this.zonaImpacto[1];
        this.puntoDerecha = this.zonaImpacto[0] + this.zonaImpacto[2];
        this.puntoIzquierda = this.zonaImpacto[0];
    }
    
    public boolean impactaA(Personaje alguien){
        return (this.puntoDerecha > alguien.getPuntoIzquierda() && this.puntoIzquierda < alguien.getPuntoDerecha() &&
                this.puntoArriba < alguien.getPuntoAbajo() && this.puntoAbajo > alguien.getPuntoArriba());
    }

    public void dibujar(GraphicsContext gc){
        gc.setFill(this.color);
        gc.fillOval(this.x, this.y, this.radio * 2, this.radio * 2);
        this.setZonaImpacto();
    }
}
