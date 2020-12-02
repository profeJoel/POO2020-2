package javaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ejemploJavaFX11 extends Application{

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
        primaryStage.setTitle("Ejemplo CheckBox con Completos");
        TextField salida = new TextField();
        Label textoSalida = new Label();

        CheckBox cb1 = new CheckBox("Mayonesa");
        cb1.setSelected(true);
        CheckBox cb2 = new CheckBox("Ketchup");
        CheckBox cb3 = new CheckBox("Mostaza");

        boton = new Button("A completear");
        boton.setOnAction( e -> manejarOpciones(cb1, cb2, cb3,textoSalida));
        
        VBox panel = new VBox(10);
        panel.setPadding(new Insets(20,20,20,20));
        panel.getChildren().addAll(cb1, cb2, cb3, boton, textoSalida);

        Scene capa = new Scene(panel, 400, 300);
        ventana.setScene(capa);
        ventana.show();
    }

    //manejar las opciones de los checkbox
    private void manejarOpciones(CheckBox b1, CheckBox b2, CheckBox b3, Label tl)
    {
        String mensaje = "El usuario ordena un Tocomple con ";
        if(b1.isSelected()) mensaje += "\n - Mayo";
        if(b2.isSelected()) mensaje += "\n - Ketchup";
        if(b3.isSelected()) mensaje += "\n - Mostaza";

        tl.setText(mensaje);
    }
}