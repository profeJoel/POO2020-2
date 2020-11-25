package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PrimerGUI3 extends Application{
    Button boton1;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("MI primera ventana en Java");
        boton1 = new Button();
        boton1.setText("Pegame");

        //inner class
        boton1.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    System.out.println("Le pegaste al Boton 1!!!");
                }
            }
        );

        StackPane lienzo = new StackPane();
        lienzo.getChildren().add(boton1);

        Scene ventana = new Scene(lienzo, 600,400);
        primaryStage.setScene(ventana);
        primaryStage.show();
    }
}