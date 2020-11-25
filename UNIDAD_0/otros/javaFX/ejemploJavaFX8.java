/**
 * compila javac javaFX/ejemploJavaFX4.java
 * ejecuta java javaFX.ejemploJavaFX4
 */
package javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ejemploJavaFX8 extends Application{
    Stage ventana;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ventana = primaryStage;
        ventana.setTitle("EL medio titulo");
        
        HBox menuSuperior = new HBox();
        Button botonA = new Button("Archivo");
        Button botonB = new Button("Editar");
        Button botonC = new Button("Ver");
        menuSuperior.getChildren().addAll(botonA, botonB, botonC);
        
        VBox menuIzquierdo = new VBox();
        Button botonD = new Button("D");
        Button botonE = new Button("E");
        Button botonF = new Button("F");
        menuSuperior.getChildren().addAll(botonD, botonE, botonF);
        
        BorderPane panel = new BorderPane();
        panel.setTop(menuSuperior);
        panel.setLeft(menuIzquierdo);

        Scene tema = new Scene(panel, 300, 250);

        ventana.setScene(tema);
        ventana.show();

    }
}