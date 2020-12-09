package Fig;

import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Fig2 extends Application{
    Stage ventana;
    double ANCHO = 800, ALTO = 600;
    //double x = ANCHO / 2, y = ALTO / 2, imgAncho = 100, imgAlto = 100;

    Emoji e1 = new Emoji("emoji.png", ANCHO / 2, ALTO / 2, 100, 100);

    
    //carga de imagenes
    Image fondo = new Image(getClass().getResourceAsStream("2472727.jpg"));
    //Image img = new Image(getClass().getResourceAsStream("emoji.png"));

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Canvas lienzo = new Canvas(ANCHO, ALTO);
        Group grupo = new Group(lienzo);

        GraphicsContext muro = lienzo.getGraphicsContext2D();

		//JavaFX Timeline = free form animation defined by KeyFrames and their duration 
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> dibujar(muro)));
		//number of cycles in animation INDEFINITE = repeat indefinitely
		tl.setCycleCount(Timeline.INDEFINITE);

        //configuracion de la ventana
        ventana = primaryStage;
        Scene escena = new Scene(grupo);
        
        lienzo.setOnMouseMoved(e ->  {
            e1.setX(e.getX() - e1.getAncho() / 2);
            e1.setY(e.getY() - e1.getAlto() / 2);
        });
        
        escena.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.UP)
                e1.setY( e1.getY() - 5);
			if(e.getCode() == KeyCode.DOWN)
                e1.setY( e1.getY() + 5);
			if(e.getCode() == KeyCode.LEFT)
                e1.setX( e1.getX() - 5);
			if(e.getCode() == KeyCode.RIGHT)
                e1.setX( e1.getX() + 5);
		});


        ventana.setTitle("Ejemplo de Canvas");
        ventana.setScene(escena);
        ventana.show();
        tl.play();
    }

    private void dibujar(GraphicsContext muro) {
        //montaje de imagenes en canvas (muro)
        muro.drawImage(fondo, 0, 0, ANCHO, ALTO); // monta imagen con posicion x,y con tamaño ancho, alto
        //muro.drawImage(img, x, y, imgAncho, imgAlto); // monta imagen con posicion x,y con tamaño ancho, alto
        muro.drawImage(e1.getImagen(), e1.getX(), e1.getY(), e1.getAncho(), e1.getAlto()); // monta imagen con posicion x,y con tamaño ancho, alto


    }

}
