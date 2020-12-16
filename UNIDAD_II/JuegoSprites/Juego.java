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

    Image fondo = new Image(getClass().getResourceAsStream("img/bg.jpg"));

    //valores del Personaje
    Personaje heroe = new Personaje(0, 0, "heroe", KeyCode.LEFT, KeyCode.RIGHT, KeyCode.UP, KeyCode.DOWN, KeyCode.SPACE, KeyCode.X);

    //Variables del juego
    private boolean estaJugando;

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

        escena.setOnKeyPressed(e -> heroe.capturarMovimiento(e));
        escena.setOnKeyReleased(e -> heroe.soltarMovimiento(e));

        ventana.setScene(escena);
        ventana.show();
        reloj.play();
    }

    private void dibujar(GraphicsContext gc){
        gc.drawImage(fondo, 0, 0, ANCHO, ALTO);
        heroe.mover();
        heroe.dibujar(gc);
    }
    
}
