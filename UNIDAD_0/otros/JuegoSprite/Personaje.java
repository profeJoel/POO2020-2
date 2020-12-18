package JuegoSprite;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Personaje {
    private int x, y, ancho, alto, velocidad, impulso, contadorPasos, salud, margen, puntoAbajo, puntoArriba, puntoIzquierdo, puntoDerecho;
    private int [] camino = new int[2];
    private int [] zonaImpacto = new int[4];
    private boolean haSaltado, vaIzquierda, vaDerecha, vaAbajo, vaArriba;
    private Image [] caminaIzquierda;
    private Image [] caminaDerecha;
    private Image quieto;
    private KeyCode l, r, u, d, jump, shot;

    public Personaje(int x, int y, String fuente, KeyCode l, KeyCode r, KeyCode u, KeyCode d, KeyCode jump, KeyCode shot, int limite){
        this.x = x;
        this.y = y;
        this.velocidad = 2;
        this.impulso = 10;
        this.contadorPasos = 0;
        this.haSaltado = false;
        this.vaIzquierda = false;
        this.vaDerecha = false;
        this.vaAbajo = false;
        this.vaArriba = false;
        this.salud = 10;
        this.setCamino(limite);

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
        this.l = l;
        this.r = r;
        this.u = u;
        this.d = d;
        this.jump = jump;
        this.shot = shot;
        System.out.println("Listo: " + fuente);
    }

    public int getSalud(){
        return this.salud;
    }

    public void disminuirSalud(){
        this.salud--;
    }

    private void setCamino(int limite){
        this.camino[0] = this.x;
        this.camino[1] = limite;
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
        this.setPuntos();
    }

    public void dibujar(GraphicsContext gc){
        if(this.contadorPasos + 1 > 27)
            this.contadorPasos = 0;

        if(this.vaIzquierda){
            gc.drawImage(this.caminaIzquierda[(int) this.contadorPasos/3], this.x, this.y, this.ancho, this.ancho);
            this.contadorPasos++;
        }
        else if(this.vaDerecha){
            gc.drawImage(this.caminaDerecha[(int) this.contadorPasos/3], this.x, this.y, this.ancho, this.ancho);
            this.contadorPasos++;
        }
        else
            gc.drawImage(this.quieto, this.x, this.y, this.ancho, this.ancho);
        
        this.setZonaImpacto();   
        this.dibujarSalud(gc); 
    }

    private void dibujarSalud(GraphicsContext gc){
        gc.setFill(Color.rgb(255, 0, 0));
        gc.fillRect(this.x, this.y - 20, this.ancho, 10);

        gc.setFill(Color.rgb(0, 128, 0));
        gc.fillRect(this.x, this.y - 20, this.ancho - (5 * (10 - this.salud)), 10);
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
        else if(e.getCode() == this.u && this.y > this.velocidad)
            this.y -= this.velocidad;
        else if(e.getCode() == this.d && this.y + this.alto + this.velocidad < Juego.ALTO)
            this.y += this.velocidad;
        else if(e.getCode() == this.jump){
            this.haSaltado = true;
            //this.vaIzquierda = false;
            //this.vaDerecha = false;
            this.contadorPasos = 0;
        }
        else{
            this.vaIzquierda = false;
            this.vaDerecha = false;
            this.contadorPasos = 0;
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
        if(this.vaIzquierda && this.x > this.velocidad){
            this.x -= this.velocidad;
            this.vaIzquierda = true;
            this.vaDerecha = false;
        }
        else if(this.vaDerecha && this.x + this.ancho + this.velocidad < Juego.ANCHO){
            this.x += this.velocidad;
            this.vaDerecha = true;
            this.vaIzquierda = false;
        }
        else{
            this.vaIzquierda = false;
            this.vaDerecha = false;
            this.contadorPasos = 0;
        }

        if(this.haSaltado){
            if(this.impulso >= -10){
                if(this.impulso < 0)
                    this.y -= (int) ((int) (this.impulso * this.impulso) * 0.5 * -1);
                else
                    this.y -= (int) ((int) (this.impulso * this.impulso) * 0.5);
                this.impulso -= 1;
            }
            else{
                this.haSaltado = false;
                this.impulso = 10;
            }
        }
        else{
            if(this.vaArriba && this.y > this.velocidad)
                this.y -= this.velocidad;
            if(this.haSaltado && this.y + this.alto + this.velocidad < Juego.ALTO)
                this.y += this.velocidad;
            if(this.haSaltado){
                this.haSaltado = true;
                this.vaIzquierda = false;
                this.vaDerecha = false;
                this.contadorPasos = 0;
            }
        }
    }

    public void seMueveSolo(int nivel){
        if(this.velocidad > 0){
            if(this.x + this.velocidad < this.camino[1]){
                this.x += this.velocidad * nivel;
                this.vaDerecha = true;
                this.vaIzquierda = false;
            }
            else{
                this.velocidad *= -1;
                this.contadorPasos = 0;
            }
        }
        else{
            if(this.x - this.velocidad > this.camino[0]){
                this.x += this.velocidad * nivel;
                this.vaIzquierda = true;
                this.vaDerecha = false;
            }
            else{
                this.velocidad *= -1;
                this.contadorPasos = 0;
            }
        }
    }

    public double getPuntoIzquierdo(){
        return this.puntoIzquierdo;
    }
    public double getPuntoDerecho(){
        return this.puntoDerecho;
    }

    public double getPuntoArriba(){
        return this.puntoArriba;
    }
    public double getPuntoAbajo(){
        return this.puntoAbajo;
    }

    private void setPuntos(){
        this.puntoAbajo = this.zonaImpacto[1] + this.zonaImpacto[3];
        this.puntoArriba = this.zonaImpacto[1];
        this.puntoIzquierdo = this.zonaImpacto[0];
        this.puntoDerecho = this.zonaImpacto[0] + this.zonaImpacto[2];
    }

    public boolean colisionaCon(Personaje p){
        return (this.puntoDerecho > p.getPuntoIzquierdo() && this.puntoIzquierdo < p.getPuntoDerecho() &&
                    this.puntoArriba < p.getPuntoAbajo() && this.puntoAbajo > p.getPuntoArriba());
    }

    public void esGolpeado(){
        this.haSaltado = false;
        this.impulso = 10;
        this.x = (int) Juego.ANCHO / 2;
        this.y = (int) Juego.ALTO - 100;
        this.contadorPasos = 0;
        this.salud -= 5;
        //ver como pausar el reloj
    }

}
