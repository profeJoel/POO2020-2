package Canvas;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
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

public class Ejemplo extends Application{
    Stage ventana;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Canvas lienzo = new Canvas(1050, 800);
        Group grupo = new Group(lienzo);

        GraphicsContext muro = lienzo.getGraphicsContext2D();

        //rectangulos
        muro.fillRect(40, 30, 100, 100);
        muro.strokeRect(150, 30, 100, 100);

        //texto Hola Mundo
        muro.fillText("Hola Mundo desde Canvas", 40, 20);

        //configuracion de tipo de letra y tamaño
        muro.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.ITALIC, 32.0));

        //texto con bordes
        muro.setStroke(Color.BLUE);
        muro.strokeText("Este es otro tipo de texto con bordes", 40, 160);

        //texto con relleno
        muro.setFill(Color.MAGENTA);
        muro.fillText("Este es un ejemplo de texto relleno", 40, 200);


        //triangulo / poligono
        muro.beginPath(); // marca inicio de la forma
        muro.moveTo(40, 260); //marca el punto de inicio
        muro.lineTo(400, 260);
        muro.lineTo(400, 210);
        muro.lineTo(40, 260);
        muro.stroke();

        //circulo con bordes y relleno
        muro.strokeOval(260, 30, 100, 100); // con bordes
        muro.fillOval(370, 30, 100, 100); // con relleno

        //carga de imagenes
        Image img = new Image(getClass().getResourceAsStream("8pu1.png"));
        //montaje de imagenes en canvas (muro)
        muro.drawImage(img, 40, 270); // monta imagen en posicion x,y con tamaño original
        muro.drawImage(img, 500, 270, 225, 225); // monta imagen con posicion x,y con tamaño ancho, alto
        muro.drawImage(img, 50, 10, 225, 225, 500, 500, 225, 225); // monta imagen recortada en la posicion x1,y1,ancho1,alto1 montada en la posicion x,y con tamaño ancho, alto.

        //Dibujo SVG
        muro.setStroke(Color.YELLOW);
        muro.setLineWidth(5.0);

        //solo con borde
        muro.beginPath();
        muro.appendSVGPath("M 876 29 L 846 138 L 732 136 L 827 199 L 789 307 L 879 236 L 970 305 L 930 198 L 1023 133 L 909 138 L 876 29 z");
        muro.closePath();
        muro.stroke();

        //con relleno
        muro.setFill(Color.YELLOW);
        muro.beginPath();
        muro.appendSVGPath("M 876 279 L 846 388 L 732 386 L 827 449 L 789 557 L 879 486 L 970 555 L 930 448 L 1023 383 L 909 388 L 876 279 z");
        muro.closePath();
        muro.fill();

        //Color con degradé - Rectangulo
        Stop[] stops1 = new Stop[] { 
            new Stop(0.2, Color.BLACK),
            new Stop(0.5, Color.RED), 
            new Stop(0.8, Color.BLACK)
        };
        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops1);
        muro.setFill(lg1);
        muro.fillRect(500, 30, 100, 100);

        
        //Color con degradé - Circulo
        Stop[] stops2 = new Stop[] { 
            new Stop(0, Color.RED),
            new Stop(1, Color.BLACK)
        };
        RadialGradient rg1 = new RadialGradient(0, 0, 0.5, 0.5, 0.8, true, CycleMethod.NO_CYCLE, stops2);
        muro.setFill(rg1);
        muro.fillOval(620, 30, 100, 100);

        //Transparencia
        for (int i = 1; i <= 20; i++) {

            float alpha = i * 0.05f;

            muro.setFill(Color.FORESTGREEN);
            muro.setGlobalAlpha(alpha);
            muro.fillRect(48 * i, 730, 48, 48);
        }

        //configuracion de la ventana
        ventana = primaryStage;
        Scene escena = new Scene(grupo);
        ventana.setTitle("Ejemplo de Canvas");
        ventana.setScene(escena);
        ventana.show();
    }

}
