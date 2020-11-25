//package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PrimerGUI extends Application{
    Button boton;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("MI primera ventana en Java");
        boton = new Button();
        boton.setText("Pegame");

        StackPane lienzo = new StackPane();
        lienzo.getChildren().add(boton);

        Scene ventana = new Scene(lienzo, 600,400);
        primaryStage.setScene(ventana);
        primaryStage.show();
    }
}