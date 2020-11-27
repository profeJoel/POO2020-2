package javaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ejemploJavaFX10 extends Application{

    Stage ventana;
    Button boton;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ventana = primaryStage;
        primaryStage.setTitle("MI primera ventana en Java");
        TextField entrada = new TextField();

        boton = new Button("Golpeame");
        boton.setOnAction( e -> esEntero(entrada.getText()));
        
        VBox panel = new VBox(10);
        panel.setPadding(new Insets(10,10,10,10));
        panel.getChildren().addAll(entrada, boton);

        Scene capa = new Scene(panel, 400, 300);
        ventana.setScene(capa);
        ventana.show();
    }

    private boolean esEntero(String mensaje){
        try{
            int edad = Integer.parseInt(mensaje);
            System.out.println("User tiene: " + edad);
            return true;
        }catch(NumberFormatException e){
            System.out.println("Error: " + mensaje + " no es un numero");
            return false;
        }
    }
}