package JuegoSprite;

import javafx.application.Application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Juego extends Application{
    Stage ventana;
    public static double ANCHO = 850, ALTO = 480;
    int nivel = 1;
    double puntaje = 0;
    boolean detectaColision = false, hasGanado = false, hasPerdido = false;

    Image fondo = new Image(getClass().getResourceAsStream("img/bg.jpg"));
    public Personaje heroe = new Personaje((int) ANCHO/2, (int) ALTO - 100, "heroe", KeyCode.LEFT, KeyCode.RIGHT, KeyCode.UP, KeyCode.DOWN, KeyCode.SPACE, KeyCode.X, (int) ANCHO - 10);
    public Personaje villano = new Personaje(0, (int) ALTO - 100, "villano", KeyCode.A, KeyCode.D, KeyCode.W, KeyCode.S, KeyCode.Z, KeyCode.Q, (int) ANCHO - 10);

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Canvas lienzo = new Canvas(ANCHO, ALTO);
        Group grupo = new Group(lienzo);

        GraphicsContext muro = lienzo.getGraphicsContext2D(); 

        Timeline reloj = new Timeline(new KeyFrame(Duration.millis(10), e -> dibujar(muro)));
        reloj.setCycleCount(Timeline.INDEFINITE);

        //configuracion de la ventana
        ventana = primaryStage;
        Scene escena = new Scene(grupo);

        //lienzo.setOnMouseMoved(e -> );

        escena.setOnKeyPressed(e -> {
            heroe.capturarMovimiento(e);
            villano.capturarMovimiento(e);
        });
        escena.setOnKeyReleased(e -> {
            heroe.soltarMovimiento(e);
            villano.soltarMovimiento(e);
        });

        ventana.setTitle("Ejemplo con Sprites");
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
            try {
                Thread.sleep(1000);   // Delay thread
            } catch (Exception e) {
                // Do nothing with errors
            }
            detectaColision = false;
        }

        if(heroe.colisionaCon(villano)){
            detectaColision = true;
            puntaje -= 5;
            gc.setFill(Color.RED);
            gc.setFont(Font.font("Console", FontWeight.NORMAL, FontPosture.REGULAR, 28.0));
            gc.fillText("GOLPEADO!!!", ANCHO - 200, 100);
            heroe.esGolpeado();
        }

        








        if(hasGanado){
            try {
                Thread.sleep(5000);   // Delay thread
            } catch (Exception e) {
                // Do nothing with errors
            }
            hasGanado = false;
            ventana.close();
            System.exit(0);
        }
        if(villano.getSalud() <= 0){
            gc.setFill(Color.BLACK);
            gc.fillRect(0,0, ANCHO, ALTO);
            gc.setFill(Color.RED);
            gc.setFont(Font.font("Console", FontWeight.NORMAL, FontPosture.REGULAR, 42.0));
            gc.fillText("GANASTE!!!", ANCHO/2 - 100, ALTO/2);
            hasGanado = true;
        }

        
        if(hasPerdido){
            try {
                Thread.sleep(5000);   // Delay thread
            } catch (Exception e) {
                // Do nothing with errors
            }
            hasGanado = false;
            ventana.close();
            System.exit(0);
        }
        if(heroe.getSalud() <= 0){
            gc.setFill(Color.BLACK);
            gc.fillRect(0,0, ANCHO, ALTO);
            gc.setFill(Color.RED);
            gc.setFont(Font.font("Console", FontWeight.NORMAL, FontPosture.REGULAR, 42.0));
            gc.fillText("Perdiste!!!", ANCHO/2 - 100, ALTO/2);
            hasPerdido = true;
        }


    }

}
