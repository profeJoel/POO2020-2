package Pong;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;

public class Barra {

    private double x, y;
    private int ancho, alto;
    private Color color;
    private String nombre;
    private int puntaje;

    public Barra(double x, double y, int ancho, int alto, Color color, String nombre){
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;    
        this.nombre = nombre;
        this.puntaje = 0;
    }

    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public int getAncho(){
        return this.ancho;
    }
    public int getAlto(){
        return this.alto;
    }
    public Color getColor(){
        return this.color;
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getPuntaje(){
        return this.puntaje;
    }

    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setAncho(int ancho){
        this.ancho = ancho;
    }
    public void setAlto(int alto){
        this.alto = alto;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }

    public void subir(double v){
        if(this.y - v >= 0)
            this.y -= v;
    }
    public void bajar(double v){
        if(this.y + this.alto + v <= PongClase.ALTO)
            this.y += v;
    }

    public void mover(KeyEvent e){
        if(e.getCode() == KeyCode.UP)
            this.subir(10);
        if(e.getCode() == KeyCode.DOWN)
            this.bajar(10); 
    }

    public void seguir(Balon balon){
        if(balon.getX() < PongClase.ANCHO - PongClase.ANCHO/4)
            this.setY(balon.getY() - this.getAlto()/2);
        else
            this.setY((balon.getY() > this.y + this.alto/2)? this.y + 5 : this.y - 5);
    }

    public void gana(){
        this.puntaje++;
    }

    public boolean pierdeHumano(Balon balon){
        return (balon.getX() < this.x - this.ancho);
    }
    public boolean pierdeMaquina(Balon balon){
        return (balon.getX() > this.x + this.ancho);
    }

    public boolean golpeaPorIzquierda(Balon balon){
        return (balon.getX() < this.x + this.ancho && balon.getY() >= this.y && balon.getY() <= this.y + this.alto);
    }

    public boolean golpeaPorDerecha(Balon balon){
        return (balon.getX() + balon.getRadio() > this.x && balon.getY() >= this.y && balon.getY() <= this.y + this.alto);
    }

    public void dibujar(GraphicsContext gc){
        gc.setFill(this.color);
        gc.fillRect(this.x, this.y, this.ancho, this.alto);
    }
}
