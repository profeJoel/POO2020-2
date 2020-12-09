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

public class Fig extends Application{
    Stage ventana;
    double ANCHO = 800, ALTO = 600;
    double x = ANCHO / 2, y = ALTO / 2, imgAncho = 100, imgAlto = 100;

    
    //carga de imagenes
    Image fondo = new Image(getClass().getResourceAsStream("2472727.jpg"));
    Image img = new Image(getClass().getResourceAsStream("emoji.png"));

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
            x = e.getX() - imgAncho / 2;
            y = e.getY() - imgAlto / 2;
        });
        
        escena.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.UP)
                y -= 5;
			if(e.getCode() == KeyCode.DOWN)
				y += 5;
			if(e.getCode() == KeyCode.LEFT)
				x -= 5;
			if(e.getCode() == KeyCode.RIGHT)
				x += 5;
		});


        ventana.setTitle("Ejemplo de Canvas");
        ventana.setScene(escena);
        ventana.show();
        tl.play();
    }

    private void dibujar(GraphicsContext muro) {
        //montaje de imagenes en canvas (muro)
        muro.drawImage(fondo, 0, 0, ANCHO, ALTO); // monta imagen con posicion x,y con tamaño ancho, alto
        muro.drawImage(img, x, y, imgAncho, imgAlto); // monta imagen con posicion x,y con tamaño ancho, alto


    }

}
