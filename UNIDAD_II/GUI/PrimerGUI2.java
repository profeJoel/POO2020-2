package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PrimerGUI2 extends Application implements EventHandler<ActionEvent>{
    Button boton1,boton2;

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
        boton1.setOnAction(this);

        StackPane lienzo = new StackPane();
        lienzo.getChildren().add(boton1);

        Scene ventana = new Scene(lienzo, 600,400);
        primaryStage.setScene(ventana);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event)
    {
        if(event.getSource() == boton1)
            System.out.println("Le pegaste al Boton 1!!!");
    }
}