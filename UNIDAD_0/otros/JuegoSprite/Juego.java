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
    double puntaje = 0;

    Image fondo = new Image(getClass().getResourceAsStream("img/bg.jpg"));
    public Personaje heroe = new Personaje((int) ANCHO/2, (int) ALTO/2, "heroe", KeyCode.LEFT, KeyCode.RIGHT, KeyCode.UP, KeyCode.DOWN, KeyCode.SPACE, KeyCode.X);

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

        escena.setOnKeyPressed(e -> heroe.capturarMovimiento(e));

        ventana.setTitle("Ejemplo con Sprites");
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
