package javaFX;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox6{

    public static void display(String titulo, String mensaje){
        Stage ventana = new Stage();

        //
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle(titulo);
        ventana.setMinWidth(250);

        Label texto = new Label();
        texto.setText(mensaje);
        Button botonCierre = new Button("Cerrar la Ventana");
        botonCierre.setOnAction(e -> ventana.close());

        VBox capa = new VBox(10);
        capa.getChildren().addAll(texto, botonCierre);
        capa.setAlignment(Pos.CENTER);

        Scene tema = new Scene(capa);
        ventana.setScene(tema);
        ventana.showAndWait();
    }
}