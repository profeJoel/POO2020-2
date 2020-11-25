package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PrimerGUI6 extends Application{
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

        boton = new Button("Abrir ventana emergente");
        boton.setOnAction(e -> VentanaEmergente.mostrar("Ventana Pop-op", "Esta es una ventana emergente"));

        StackPane capa = new StackPane();
        capa.getChildren().add(boton);
        Scene tema = new Scene(capa, 400, 300);
        
        ventana.setScene(tema);
        primaryStage.show();
    }
}