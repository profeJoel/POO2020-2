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

public class Pong extends Application{
    Stage ventana;
    //valores de la ventana
    private static final int ANCHO = 800;
    private static final int ALTO = 600;

    //valores de las barras
    private static final int ALTOBARRA = 100;
    private static final int ANCHOBARRA = 15;
    private double barraIzqX = 0;
    private double barraIzqY = ALTO / 2;
    private double barraDerX = ANCHO - ANCHOBARRA;
    private double barraDerY = ALTO / 2;

    //Valores del balon
    private static final double RADIOBALON = 15;
    private int balonVelocidadX = 1;
    private int balonVelocidadY = 1;
    private double balonX = ANCHO / 2;
    private double balonY = ALTO / 2;

    //Variables del juego
    private boolean estaJugando;
    private int puntajeBarraIzq = 0;
    private int puntajeBarraDer = 0;

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
        lienzo.setOnMouseMoved(e -> barraIzqY = e.getY());

        Scene escena = new Scene(new StackPane(lienzo));

        escena.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.UP)
                barraIzqY -= 10;
            if(e.getCode() == KeyCode.DOWN)
                barraIzqY += 10; 
        });

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
            balonX += balonVelocidadX;
            balonY += balonVelocidadY;

            if(balonX < ANCHO - ANCHO/4){
                barraDerY = balonY - ALTOBARRA/2;
            }
            else{
                barraDerY = (balonY > barraDerY + ALTOBARRA/2)? barraDerY += 1 : barraDerY - 1;
            }
            gc.fillOval(balonX, balonY, RADIOBALON, RADIOBALON);
        }
        else{
            gc.setStroke(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("Clickear para comenzar", ANCHO/2, ALTO/2);

            balonX = ANCHO/2;
            balonY = ALTO/2;

            balonVelocidadX = (new Random().nextInt(2) == 0)? 1: -1;
            balonVelocidadY = (new Random().nextInt(2) == 0)? 1: -1;
        }

        if(balonY > ALTO || balonY < 0)
            balonVelocidadY *= -1;

        if(balonX < barraIzqX - ANCHOBARRA){
            puntajeBarraIzq++;
            estaJugando = false;
        }
        if(balonX > barraDerX + ANCHOBARRA){
            puntajeBarraDer++;
            estaJugando = false;
        }

        if(((balonX + RADIOBALON > barraDerX) && balonY >= barraDerY && balonY <= barraDerY + ALTOBARRA) ||
            ((balonX < barraIzqX + ANCHOBARRA) && balonY >= barraIzqY && balonY <= barraIzqY + ALTOBARRA)){
                balonVelocidadX += 1 * Math.signum(balonVelocidadX);
                balonVelocidadY += 1 * Math.signum(balonVelocidadY);
                balonVelocidadX *= -1;
                balonVelocidadY *= -1;
        }

        gc.fillRect(barraDerX, barraDerY, ANCHOBARRA, ALTOBARRA);
        gc.fillRect(barraIzqX, barraIzqY, ANCHOBARRA, ALTOBARRA);

        gc.fillText(puntajeBarraIzq + "\t\t\t\t\t\t\t\t\t" + puntajeBarraDer, ANCHO/2, 100);
    }
    
}
