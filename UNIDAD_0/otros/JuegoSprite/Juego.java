package JuegoSprite;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
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
    public static double ANCHO = 1050, ALTO = 800;
    double puntaje = 0;

    Emoji e1 = new Emoji("e1.png", 50, 50, 100, 100, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.UP, KeyCode.DOWN);
    Emoji e2 = new Emoji("e2.png", 525 - 50,  400 - 50, 100, 100, KeyCode.A, KeyCode.D, KeyCode.W, KeyCode.S);

    Image fondo = new Image(getClass().getResourceAsStream("pizarra.jpg"));

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

        //Captura de evento de mouse
        lienzo.setOnMouseMoved(e -> e1.setXYCentrado(e.getX(), e.getY()));
        
        //Captura evento de teclado
        /*escena.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.LEFT)
                e1.disminuirX(5);
            if(e.getCode() == KeyCode.RIGHT)
                e1.aumentarX(5);
            if(e.getCode() == KeyCode.UP)
                e1.disminuirY(5);
            if(e.getCode() == KeyCode.DOWN)
                e1.aumentarY(5);
        });*/

        escena.setOnKeyPressed(e -> {
            e1.mover(e);
            //e2.mover(e);
        });

        ventana.setTitle("Ejemplo de Canvas");
        ventana.setScene(escena);
        ventana.show();
        reloj.play();
    }

    private void dibujar(GraphicsContext gc){
        /*
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 1050, 800);
        gc.setFill(Color.BLUE);
        gc.fillRect(x, y, 100, 100);
        */
        e2.moverSolo();

        gc.drawImage(fondo, 0, 0, ANCHO, ALTO);
        e1.dibujar(gc);
        e2.dibujar(gc);
        //gc.drawImage(e1.getImagen(), e1.getX(), e1.getY(), e1.getAncho(), e1.getAlto());
        //gc.drawImage(e2.getImagen(), e2.getX(), e2.getY(), e2.getAncho(), e2.getAlto());
        
        if(e1.colisionaCon(e2)){
            //System.out.println("\n\nColisiona");
            gc.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 48.0));
            gc.setFill(Color.RED);
            gc.fillText("COLISION", 10, 50);

            puntaje += 1;
            //System.out.println("e1 > " + e1.getPuntoIzquierda() + ", " + e1.getPuntoDerecha() + ", " + e1.getPuntoArriba() + ", " + e1.getPuntoAbajo());
            //System.out.println("e2 > " + e2.getPuntoIzquierda() + ", " + e2.getPuntoDerecha() + ", " + e2.getPuntoArriba() + ", " + e2.getPuntoAbajo());
        }
        
        gc.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 32.0));
        gc.setFill(Color.YELLOW);
        gc.fillText("PUNTAJE: " + (int) puntaje, 750, 50);
    }

}
