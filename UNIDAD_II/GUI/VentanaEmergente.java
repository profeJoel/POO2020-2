package GUI;

import javafx.stage.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class VentanaEmergente {
    
    public static void mostrar(String titulo, String mensaje){
        Stage ventana = new Stage();

        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle(titulo);
        ventana.setMinWidth(250);

        Label texto = new Label(mensaje);
        Button botonCierre = new Button("Cerrar");
        botonCierre.setOnAction(e -> ventana.close());

        VBox capa = new VBox();
        capa.getChildren().addAll(texto,botonCierre);
        capa.setAlignment(Pos.CENTER);

        Scene tema = new Scene(capa);
        ventana.setScene(tema);
        ventana.showAndWait();
    }
}