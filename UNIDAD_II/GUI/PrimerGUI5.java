package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrimerGUI5 extends Application{
    Stage ventana;
    Scene tema1, tema2;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ventana = primaryStage;
        primaryStage.setTitle("MI primera ventana en Java");

        Label texto1 = new Label("Bienvenido al primer tema");
        Button boton1 = new Button("Pasar al Tema 2");
        //Expresion Lambda
        boton1.setOnAction(e -> ventana.setScene(tema2));

        //capa que coloca todos los elementos hijos de forma vertical
        VBox capa1 = new VBox();
        capa1.getChildren().addAll(texto1, boton1);
        tema1 = new Scene(capa1, 600, 300);

        //accion del boton 2
        Button boton2 = new Button("Volver al primer tema");
        boton2.setOnAction(e -> ventana.setScene(tema1));

        StackPane capa2 = new StackPane();
        capa2.getChildren().add(boton2);
        tema2 = new Scene(capa2, 600, 300);
        
        ventana.setScene(tema1);
        primaryStage.show();
    }
}