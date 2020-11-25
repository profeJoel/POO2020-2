package javaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ejemploJavaFX1 extends Application implements EventHandler<ActionEvent>{/**nuevo */
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
        
        boton.setOnAction(this);/** */

        StackPane lienzo = new StackPane();
        lienzo.getChildren().add(boton);

        Scene escena = new Scene(lienzo, 600, 400);
        primaryStage.setScene(escena);
        primaryStage.show();
    }

    /**Nuevo */
    @Override
    public void handle(ActionEvent event)
    {
        if(event.getSource() == boton)
        {
            System.out.println("Me pegaste!!!!");
        }
    }
}