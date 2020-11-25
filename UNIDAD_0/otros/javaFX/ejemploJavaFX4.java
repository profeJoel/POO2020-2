/**
 * compila javac javaFX/ejemploJavaFX4.java
 * ejecuta java javaFX.ejemploJavaFX4
 */
package javaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ejemploJavaFX4 extends Application{
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

        Label texto1 = new Label("Bienvenido a mi primer tema 1");
        Button boton1 = new Button("Cambia al tema 2");
        boton1.setOnAction(e -> ventana.setScene(tema2));

        //capa 1 - cada hijo es colocado en columna vertical
        VBox capa1 = new VBox(20);
        //StackPane capa1 = new StackPane();
        capa1.getChildren().addAll(texto1,boton1);
        tema1 = new Scene(capa1, 600, 300);

        //Boton 2
        Button boton2 = new Button("Ni ahí con este tema, vamos al tema 1");
        boton2.setOnAction(e -> ventana.setScene(tema1));

        //capa 2
        StackPane capa2 = new StackPane();
        capa2.getChildren().add(boton2);
        tema2 = new Scene(capa2, 600, 300);

        ventana.setScene(tema1);
        ventana.setTitle("EL medio titulo");
        ventana.show();

    }
}