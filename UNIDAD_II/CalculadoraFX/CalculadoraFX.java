package CalculadoraFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculadoraFX extends Application{
    Stage ventana;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ventana = primaryStage;
        primaryStage.setTitle("MI primera ventana en Java");

        GridPane panel = new GridPane();
        panel.setPadding(new Insets(10, 10, 10, 10));
        panel.setVgap(4);
        panel.setHgap(2);
        
        //entrada valor A
        TextField entradaA = new TextField();
        entradaA.setPromptText("Ingrese el valor de A");
        GridPane.setConstraints(entradaA, 0, 0);

        //entrada valor B
        TextField entradaB = new TextField();
        entradaB.setPromptText("Ingrese el valor de B");
        GridPane.setConstraints(entradaB, 0, 1);

        //salida resultado
        TextField salidaResultado = new TextField();
        salidaResultado.setPromptText("Resultado");
        GridPane.setConstraints(salidaResultado, 0, 3);

        //boton suma
        Button botonSuma = new Button("+");
        botonSuma.setOnAction(e -> realizarOperacion(entradaA, entradaB, salidaResultado, '+'));
        GridPane.setConstraints(botonSuma, 1, 0);

        //boton resta
        Button botonResta = new Button("-");
        botonResta.setOnAction(e -> realizarOperacion(entradaA, entradaB, salidaResultado, '-'));
        GridPane.setConstraints(botonResta, 1, 1);
        
        //boton multiplicacion
        Button botonMulti = new Button("*");
        botonMulti.setOnAction(e -> realizarOperacion(entradaA, entradaB, salidaResultado, '*'));
        GridPane.setConstraints(botonMulti, 1, 2);
        
        //boton division
        Button botonDivi = new Button("/");
        botonDivi.setOnAction(e -> realizarOperacion(entradaA, entradaB, salidaResultado, '/'));
        GridPane.setConstraints(botonDivi, 1, 3);
        

        panel.getChildren().addAll(entradaA, entradaB, salidaResultado, botonSuma, botonResta, botonMulti, botonDivi);

        Scene tema = new Scene(panel, 400, 300);
        
        ventana.setScene(tema);
        primaryStage.show();
    }

    private void realizarOperacion(TextField textoA, TextField textoB, TextField textoResultado, char operacion)
    {
        if(esEntero(textoA.getText()) && esEntero(textoB.getText()))
        {
            double a = Double.parseDouble(textoA.getText());
            double b = Double.parseDouble(textoB.getText());
            double resultado = 0;
            String texto;
            try{
                if(operacion == '+') resultado = a + b;
                if(operacion == '-') resultado = a - b;
                if(operacion == '*') resultado = a * b;
                if(operacion == '/') resultado = (double) a / b;
                texto = String.valueOf(resultado);
            }catch(Exception e){
                texto = "Error en el calculo";
            }
            textoResultado.setText(texto);
        }
        else    
            textoResultado.setText("No se puede realizar la operacion");
    }

    private boolean esEntero(String mensaje){
        try{
            int valor = Integer.parseInt(mensaje);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}