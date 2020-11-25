/**
 * compila javac javaFX/ejemploJavaFX4.java
 * ejecuta java javaFX.ejemploJavaFX4
 */
package javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ejemploJavaFX7 extends Application{
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
        ventana.setTitle("EL medio titulo");
        //ventana.setOnCloseRequest(e -> cerrarPrograma());
        ventana.setOnCloseRequest(e -> {
            e.consume();
            cerrarPrograma();
        });

        boton = new Button("Clikeame");
        boton.setOnAction(e -> cerrarPrograma());
        
        StackPane capa = new StackPane();
        capa.getChildren().add(boton);
        Scene tema = new Scene(capa, 300, 250);

        ventana.setScene(tema);
        ventana.show();

    }

    private void cerrarPrograma()
    {
        //System.out.println("Archivo Guardado...");
        //ventana.close();
        Boolean respuesta = ConfirmBox6.display("Archivo", "Seguro de salir?");
        if(respuesta)
            ventana.close();
    }
}