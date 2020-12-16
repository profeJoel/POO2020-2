package JuegoSprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Personaje {
    private int x, y, ancho, alto, velocidad, impulso, contadorPasos, salud, margen, puntoIzquierda, puntoDerecha, puntoArriba, puntoAbajo;
    private int [] camino = new int [2];
    private int [] zonaImpacto = new int [4];
    private boolean haSaltado, vaIzquierda, vaDerecha, vaArriba, vaAbajo;
    private Image [] caminaIzquierda;
    private Image [] caminaDerecha;
    private Image quieto;
    private KeyCode l, r, u, d, jump, shot;

    public Personaje(int x, int y, String fuente, KeyCode l, KeyCode r, KeyCode u, KeyCode d, KeyCode jump, KeyCode shot){
        this.x = x;
        this.y = y;
        this.velocidad = 1;
        this.impulso = 10;
        this.contadorPasos = 0;
        this.haSaltado = false;
        this.vaIzquierda = false;
        this.vaDerecha = false;
        this.vaArriba = false;
        this.vaAbajo = false;
        this.salud = 10;
        this.margen = 10;

        this.l = l;
        this.r = r;
        this.u = u;
        this.d = d;
        this.jump = jump;
        this.shot = shot;

        int cantidadImagenes = 9;
        this.caminaIzquierda = new Image [cantidadImagenes];
        this.caminaDerecha = new Image [cantidadImagenes];
        for(int i = 0; i < cantidadImagenes; i++){
            this.caminaIzquierda[i] = new Image(getClass().getResourceAsStream("img/" + fuente + "/L" + (i+1) + ".png"));
            this.caminaDerecha[i] = new Image(getClass().getResourceAsStream("img/" + fuente + "/R" + (i+1) + ".png"));
        }
        this.quieto = new Image(getClass().getResourceAsStream("img/" + fuente + "/standing.png"));
        this.ancho = (int) this.quieto.getWidth();
        this.alto = (int) this.quieto.getHeight();

        this.setZonaImpacto();
    }

    private void setZonaImpacto(int x, int y, int ancho, int alto){
        this.zonaImpacto[0] = x + this.margen; 
        this.zonaImpacto[1] = y + this.margen; 
        this.zonaImpacto[2] = ancho - this.margen; 
        this.zonaImpacto[3] = alto - this.margen; 
    }    
    
    private void setZonaImpacto(){
        this.zonaImpacto[0] = this.x + this.margen; 
        this.zonaImpacto[1] = this.y + this.margen; 
        this.zonaImpacto[2] = this.ancho - this.margen; 
        this.zonaImpacto[3] = this.alto - this.margen; 
    }

    public void capturarMovimiento(KeyEvent e){
        if(e.getCode() == this.l){
            this.vaIzquierda = true;
            this.vaDerecha = false;
        }
        else if(e.getCode() == this.r){
            this.vaDerecha = true;
            this.vaIzquierda = false;
        }
        else if(e.getCode() == this.u){
            this.vaArriba = true;
            this.vaAbajo = false;
        }
        else if(e.getCode() == this.d){
            this.vaAbajo = true;
            this.vaArriba = false;
        }
        else{
            this.vaIzquierda = false;
            this.vaDerecha = false;
            this.vaArriba = false;
            this.vaAbajo = false;
        }
    }

    public void soltarMovimiento(KeyEvent e){
        if(e.getCode() == this.l)
            this.vaIzquierda = false;
        else if(e.getCode() == this.r)
            this.vaDerecha = false;
        else if(e.getCode() == this.u)
            this.vaArriba = false;
        else if(e.getCode() == this.d)
            this.vaAbajo = false;
    }

    public void mover(){
        if(this.vaIzquierda && this.x + this.velocidad > 0)
            this.x -= this.velocidad;
        else if(this.vaDerecha && this.x + this.ancho + this.velocidad < Juego.ANCHO)
            this.x += this.velocidad;
        else
            this.contadorPasos = 0;

        if(this.haSaltado){
            if(this.impulso >= -10){
                if(this.impulso < 0)
                    this.y = (int) ((int)(this.impulso * this.impulso) * 0.5 * -1);
                else
                    this.y = (int) ((int)(this.impulso * this.impulso) * 0.5);
                this.impulso--;
            }
            else{
                this.haSaltado = false;
                this.impulso = 10;
            }
        }
        else{
            if(this.vaArriba && this.y + this.velocidad > 0)
                this.y -= this.velocidad;
            if(this.vaAbajo && this.y + this.alto + this.velocidad < Juego.ALTO)
                this.y += this.velocidad;
            if(this.haSaltado){
                this.vaIzquierda = false;
                this.vaDerecha = false;
                this.contadorPasos = 0;
            }
        }
    }

    public void dibujar(GraphicsContext gc){
        if(this.contadorPasos + 1 > 90)
            this.contadorPasos = 0;

        if(this.vaIzquierda){
            gc.drawImage(this.caminaIzquierda[(int) this.contadorPasos/10], this.x, this.y, this.ancho, this.alto);
            this.contadorPasos++;
        }
        else if(this.vaDerecha){
            gc.drawImage(this.caminaDerecha[(int) this.contadorPasos/10], this.x, this.y, this.ancho, this.alto);
            this.contadorPasos++;
        }
        else
            gc.drawImage(this.quieto, this.x, this.y, this.ancho, this.alto);
        
        this.setZonaImpacto();
        this.dibujarBarraSalud(gc);
    }

    public void dibujarBarraSalud(GraphicsContext gc){
        gc.setFill(Color.rgb(255, 0, 0));
        gc.fillRect(this.x, this.y - 20, this.ancho, 10);
        
        gc.setFill(Color.rgb(0, 128, 0));
        gc.fillRect(this.x, this.y - 20, this.ancho - (5 * (10 - this.salud)), 10);
    }
    
}
