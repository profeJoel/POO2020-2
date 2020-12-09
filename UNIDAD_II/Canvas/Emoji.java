package Canvas;

import javafx.scene.image.Image;

import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Emoji {
    private String ruta;
    private Image imagen;
    private double x, y, ancho, alto;
    private KeyCode u, d, l, r;

    public Emoji(String ruta, double x, double y, double ancho, double alto, KeyCode izq, KeyCode der, KeyCode arr, KeyCode aba){
        this.ruta = ruta;
        this.imagen = new Image(getClass().getResourceAsStream(ruta));
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;

        this.l = izq;
        this.r = der;
        this.u = arr;
        this.d = aba;
    }

    public String getRuta(){
        return this.ruta;
    }
    public Image getImagen(){
        return this.imagen;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getAncho(){
        return this.ancho;
    }
    public double getAlto(){
        return this.alto;
    }

    public void setRuta(String ruta){
        this.ruta = ruta;
    }
    public void setImagen(String ruta){
        this.setRuta(ruta);
        this.imagen = new Image(getClass().getResourceAsStream(ruta));
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setXY(double x, double y){
        this.setX(x);
        this.setY(y);
    }

    public void setAncho(double ancho){
        this.ancho = ancho;
    }
    public void setAlto(double alto){
        this.alto = alto;
    }

    public void setXCentrado(double x){
        this.x = x - this.ancho / 2;
    }
    public void setYCentrado(double y){
        this.y = y - this.alto / 2;
    }
    public void setXYCentrado(double x, double y){
        this.setXCentrado(x);
        this.setYCentrado(y);
    }

    public void disminuirX(double x){
        if(this.x - x >= 0)
            this.x -= x;
    }

    public void aumentarX(double x){
        if(this.x + x + this.ancho <= Interactivo.ANCHO)
            this.x += x;
    }

    public void disminuirY(double y){
        if(this.y - y >= 0)
            this.y -= y;
    }
    public void aumentarY(double y){
        if(this.y + y + this.alto <= Interactivo.ALTO)
            this.y += y;
    }

    /*public void mover(Scene escena, KeyCode izq, KeyCode der, KeyCode arr, KeyCode aba){
        escena.setOnKeyPressed(e -> {
            if(e.getCode() == izq)
                this.disminuirX(5);
            if(e.getCode() == der)
                this.aumentarX(5);
            if(e.getCode() == arr)
                this.disminuirY(5);
            if(e.getCode() == aba)
                this.aumentarY(5);
        });
    }*/
    public void mover(KeyEvent e){
        if(e.getCode() == this.l)
            this.disminuirX(5);
        if(e.getCode() == this.r)
            this.aumentarX(5);
        if(e.getCode() == this.u)
            this.disminuirY(5);
        if(e.getCode() == this.d)
            this.aumentarY(5);
    }

    public void moverSolo(){
        Random aleatorio = new Random(System.currentTimeMillis());
        int opcion = aleatorio.nextInt(4);

        switch(opcion){
            case 0: 
                this.disminuirX(5);
                break;
            case 1: 
                this.aumentarX(5);
                break;
            case 2: 
                this.disminuirY(5);
                break;
            case 3: 
                this.aumentarY(5);
                break;
        }
    }
}
