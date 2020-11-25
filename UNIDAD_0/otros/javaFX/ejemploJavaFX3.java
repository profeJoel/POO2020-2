/**
 * compila javac javaFX/ejemploJavaFX3.java
 * ejecuta java javaFX.ejemploJavaFX3
 */
package javaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ejemploJavaFX3 extends Application{
    Button boton;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Title of the Window");
        boton = new Button();
        boton.setText("Pegame");

        //inner class
        //boton.setOnAction(e -> System.out.println("Me Pegaste!!! (desde una expresion lambda)"));
        boton.setOnAction(e -> {
            System.out.println("Me Pegaste!!! (desde una expresion lambda)");
            System.out.println("Venganza!");
        });
        
        StackPane lienzo = new StackPane();
        lienzo.getChildren().add(boton);

        Scene escena = new Scene(lienzo, 600, 400);
        primaryStage.setScene(escena);
        primaryStage.show();
    }
}