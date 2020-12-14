package Pong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import java.util.Random;

public class PongClase extends Application{
    Stage ventana;
    //valores de la ventana
    public static final int ANCHO = 800;
    public static final int ALTO = 600;

    //valores de las barras
    Barra izquierda = new Barra(0, ALTO/2, 15, 100, Color.YELLOW, "Humano");
    Barra derecha = new Barra(ANCHO - 15, ALTO/2, 15, 100, Color.RED, "Computador");

    //Valores del balon
    Balon pelota = new Balon(ANCHO/2, ALTO/2, 15, Color.WHITE);

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

        lienzo.setOnMouseClicked(e -> estaJugando = true);
        lienzo.setOnMouseMoved(e -> izquierda.setY(e.getY()));

        Scene escena = new Scene(new StackPane(lienzo));

        escena.setOnKeyPressed(e -> izquierda.mover(e));

        ventana.setScene(escena);
        ventana.show();
        reloj.play();
    }

    private void dibujar(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, ANCHO, ALTO);

        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(25));

        if(estaJugando){
            pelota.mover();
            derecha.seguir(pelota);
            pelota.dibujar(gc);
        }
        else{
            gc.setStroke(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("Clickear para comenzar", ANCHO/2, ALTO/2);

            pelota.inicializarMovimiento(ANCHO/2, ALTO/2);
        }

        if(izquierda.pierdeHumano(pelota)){
            derecha.gana();
            estaJugando = false;
        }
        if(derecha.pierdeMaquina(pelota)){
            izquierda.gana();
            estaJugando = false;
        }

        if(derecha.golpeaPorDerecha(pelota) || izquierda.golpeaPorIzquierda(pelota)){
                pelota.aumentarVelocidad();
                pelota.rebotar();
        }

        izquierda.dibujar(gc);
        derecha.dibujar(gc);

        gc.setFill(Color.WHITE);
        gc.fillText(izquierda.getPuntaje() + "\t\t\t\t\t\t\t\t\t" + derecha.getPuntaje(), ANCHO/2, 100);
    }
    
}
