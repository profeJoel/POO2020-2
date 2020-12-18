package JuegoSprites;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import java.util.Random;

public class Juego extends Application{
    Stage ventana;
    //valores de la ventana
    public static final int ANCHO = 850;
    public static final int ALTO = 480;

    private int nivel = 1, puntaje = 0, direccion, cantBalas = 0;

    Image fondo = new Image(getClass().getResourceAsStream("img/bg.jpg"));

    //valores del Personaje
    Personaje heroe = new Personaje(ANCHO/2, ALTO - 100, "heroe", KeyCode.LEFT, KeyCode.RIGHT, KeyCode.UP, KeyCode.DOWN, KeyCode.SPACE, KeyCode.X, ANCHO - 10);
    Personaje villano = new Personaje(0, ALTO - 100, "villano", KeyCode.A, KeyCode.D, KeyCode.W, KeyCode.S, KeyCode.Z, KeyCode.Q, ANCHO - 10);

    Proyectil bala;

    //Variables del juego
    private boolean estaJugando, detectaColision = false, hasPerdido = false, hasGanado = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        ventana = primaryStage;
        ventana.setTitle("PONG");

        Canvas lienzo = new Canvas(ANCHO, ALTO);
        GraphicsContext gc = lienzo.getGraphicsContext2D();

        Timeline reloj = new Timeline(new KeyFrame(Duration.millis(10), e -> dibujar(gc)));
        reloj.setCycleCount(Timeline.INDEFINITE);

        Scene escena = new Scene(new StackPane(lienzo));

        escena.setOnKeyPressed(e -> {
            heroe.capturarMovimiento(e);
            villano.capturarMovimiento(e);
        });
        escena.setOnKeyReleased(e -> {
            heroe.soltarMovimiento(e);
            villano.soltarMovimiento(e);
        });

        ventana.setScene(escena);
        ventana.show();
        reloj.play();
    }

    private void dibujar(GraphicsContext gc){
        gc.drawImage(fondo, 0, 0, ANCHO, ALTO);
        heroe.mover();
        villano.seMueveSolo(nivel);
        heroe.dibujar(gc);
        villano.dibujar(gc);

        if(detectaColision){
            try{
                Thread.sleep(1000);
            }catch(Exception e){
            }
            detectaColision = false;
        }

        if(heroe.colisionaCon(villano)){
            detectaColision = true;
            gc.setFill(Color.RED);
            gc.setFont(Font.font("Console", FontWeight.NORMAL, FontPosture.REGULAR, 28.0));
            gc.fillText("Golpeado!!!", ANCHO - 200, 100);
            heroe.esGolpeado();
        }

        if(heroe.getHaDisparado() && cantBalas == 0){
            if(heroe.getVaIzquierda())
                direccion = -1;
            else if(heroe.getVaDerecha())
                direccion = 1;
            else 
                direccion = 1;
            
            bala = new Proyectil((int) (heroe.getX() + heroe.getAncho() / 2), (int) (heroe.getY() + heroe.getAlto() / 2), 6, Color.BROWN, direccion);
            cantBalas++;
            heroe.setHaDisparado(false);
        }


        if(cantBalas > 0){
            if(bala.getX() < ANCHO && bala.getX() > 0){
                bala.moverX();
                bala.dibujar(gc);
            }
            else{
                bala = null;
                cantBalas--;
            }

            if(bala.impactaA(villano)){
                puntaje++;
                if(villano.getSalud() > 0){
                    villano.disminuirSalud();
                    bala = null;
                    cantBalas--;
                }
            }
        }











        /*________________________________________________________________________________________*/


        if(hasPerdido){
            try{
                Thread.sleep(3000);
            }catch(Exception e){
            }
            hasPerdido = false;
            ventana.close();
            System.exit(0);
        }
        if(heroe.getSalud() <= 0){
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, ANCHO, ALTO);
            gc.setFill(Color.RED);
            gc.setFont(Font.font("Console", FontWeight.NORMAL, FontPosture.REGULAR, 42.0));
            gc.fillText("PERDISTE!!!", ANCHO / 2 - 100, ALTO / 2);
            hasPerdido = true;
        }

        if(hasGanado){
            try{
                Thread.sleep(3000);
            }catch(Exception e){
            }
            hasGanado = false;
            ventana.close();
            System.exit(0);
        }
        if(villano.getSalud() <= 0){
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, ANCHO, ALTO);
            gc.setFill(Color.RED);
            gc.setFont(Font.font("Console", FontWeight.NORMAL, FontPosture.REGULAR, 42.0));
            gc.fillText("GANASTE!!!", ANCHO / 2 - 100, ALTO / 2);
            hasGanado = true;
        }

    }
    
}
