package javaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ejemploJavaFX0 extends Application{
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
        boton.setText("Pégame");
        
        StackPane lienzo = new StackPane();
        lienzo.getChildren().add(boton);

        Scene escena = new Scene(lienzo, 600, 400);
        primaryStage.setScene(escena);
        primaryStage.show();
    }
}