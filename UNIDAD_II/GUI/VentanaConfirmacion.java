package GUI;

import javafx.stage.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class VentanaConfirmacion {
    static boolean respuesta;

    public static boolean mostrar(String titulo, String mensaje){
        Stage ventana = new Stage();

        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle(titulo);
        ventana.setMinWidth(250);
        Label texto = new Label(mensaje);

        Button confirmar = new Button("Confirmar");
        Button denegar = new Button("Denegar");

        confirmar.setOnAction(e ->{
            respuesta = true;
            ventana.close();
        });
        denegar.setOnAction(e ->{
            respuesta = false;
            ventana.close();
        });

        VBox capa = new VBox();
        capa.getChildren().addAll(texto, confirmar, denegar);
        capa.setAlignment(Pos.CENTER);

        Scene tema = new Scene(capa);
        ventana.setScene(tema);
        ventana.showAndWait();

        return respuesta;
    }
}