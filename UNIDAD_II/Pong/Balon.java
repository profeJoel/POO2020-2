package Pong;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class Balon {

    private double x, y, radio;
    private int velocidadX, velocidadY;
    private Color color;

    public Balon(double x, double y, double radio, Color color){
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.color = color;

        this.velocidadX = 1;
        this.velocidadY = 1;
    }

    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getRadio(){
        return this.radio;
    }
    public int getVelocidadX(){
        return this.velocidadX;
    }
    public int getVelocidadY(){
        return this.velocidadY;
    }
    public Color getColor(){
        return this.color;
    }

    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setRadio(double radio){
        this.radio = radio;
    }
    public void setVelocidadX(int velocidad){
        this.velocidadX = velocidad;
    }
    public void setVelocidadY(int velocidad){
        this.velocidadY = velocidad;
    }
    public void setColor(Color color){
        this.color = color;
    }

    public void inicializarMovimiento(double x, double y){
        this.setX(x);
        this.setY(y);
        this.setVelocidadX((new Random().nextInt(2) == 0)? 1: -1);
        this.setVelocidadY((new Random().nextInt(2) == 0)? 1: -1);
    }

    public void mover(){
        this.x += this.velocidadX;
        this.y += this.velocidadY;

        if(this.y > PongClase.ALTO || this.y < 0)
            this.velocidadY *= -1;
    }

    public void aumentarVelocidad(){
        this.velocidadX += 1 * Math.signum(this.velocidadX);
        this.velocidadY += 1 * Math.signum(this.velocidadY);
    }
    public void rebotar(){
        this.velocidadX *= -1;
    }

    public void dibujar(GraphicsContext gc){
        Random randomGenerator = new Random();
        int red = randomGenerator.nextInt(256);
        int green = randomGenerator.nextInt(256);
        int blue = randomGenerator.nextInt(256);
        gc.setFill(Color.rgb(red, green, blue));
        gc.fillOval(this.x, this.y, this.radio, this.radio);
    }

}
