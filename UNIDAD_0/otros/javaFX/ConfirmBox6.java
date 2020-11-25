package javaFX;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox6{
    
    static boolean respuesta;

    public static boolean display(String titulo, String mensaje){
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle(titulo);
        ventana.setMinWidth(250);
        Label texto = new Label();
        texto.setText(mensaje);

        //crear dos botones
        Button botonSi = new Button("Si");
        Button botonNo = new Button("No");

        botonSi.setOnAction(e -> {
            respuesta = true;
            ventana.close();
        });
        botonNo.setOnAction(e -> {
            respuesta = false;
            ventana.close();
        });
        

        VBox capa = new VBox(10);
        capa.getChildren().addAll(texto, botonSi, botonNo);
        capa.setAlignment(Pos.CENTER);

        Scene tema = new Scene(capa);
        ventana.setScene(tema);
        ventana.showAndWait();

        return respuesta;
    }
}