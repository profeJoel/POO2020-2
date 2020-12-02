package CalculadoraFX;

import javax.management.OperationsException;

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
        primaryStage.setTitle("CalculadoraFX");

        GridPane panel = new GridPane();
        panel.setPadding(new Insets(10, 10, 10, 10));
        panel.setVgap(4);
        panel.setHgap(2);

        //A
        TextField entradaA = new TextField();
        entradaA.setPromptText("Ingrese valor A");
        GridPane.setConstraints(entradaA, 0, 0);

        //B
        TextField entradaB = new TextField();
        entradaB.setPromptText("Ingrese valor B");
        GridPane.setConstraints(entradaB, 0, 1);

        //Resultado
        TextField entradaR = new TextField();
        entradaR.setPromptText("Resultado");
        GridPane.setConstraints(entradaR, 0, 3);

        //+
        Button botonSuma = new Button("+");
        botonSuma.setOnAction(e -> {
            realizarOperacion(entradaA.getText(), entradaB.getText(), entradaR, '+');
        });
        GridPane.setConstraints(botonSuma, 1, 0);

        //-
        Button botonResta = new Button("-");
        botonResta.setOnAction(e -> {
            realizarOperacion(entradaA.getText(), entradaB.getText(), entradaR, '-');
        });
        GridPane.setConstraints(botonResta, 1, 1);

        //*
        Button botonMulti = new Button("*");
        botonMulti.setOnAction(e -> {
            realizarOperacion(entradaA.getText(), entradaB.getText(), entradaR, '*');
        });
        GridPane.setConstraints(botonMulti, 1, 2);

        ///
        Button botonDivi = new Button("/");
        botonDivi.setOnAction(e -> {
            realizarOperacion(entradaA.getText(), entradaB.getText(), entradaR, '/');
        });
        GridPane.setConstraints(botonDivi, 1, 3);



        panel.getChildren().addAll(entradaA, entradaB, entradaR, botonSuma, botonResta, botonMulti, botonDivi);

        Scene tema = new Scene(panel, 400, 300);
        
        ventana.setScene(tema);
        primaryStage.show();
    }

    private void realizarOperacion(String textoA, String textoB, TextField textoR, char operacion)
    {
        if(esEntero(textoA) && esEntero(textoB))
        {   
            int a = Integer.parseInt(textoA);
            int b = Integer.parseInt(textoB);
            double resultado = 0;
            String textoResultado;
            try{
                if(operacion == '+') resultado = a + b;
                if(operacion == '-') resultado = a - b;
                if(operacion == '*') resultado = a * b;
                if(operacion == '/') resultado = (double) a / b;

                textoResultado = String.valueOf(resultado);
            }catch(Exception e){
                textoResultado = "Error en el cálculo";
            }
            
            textoR.setText(textoResultado);
        }
        else
            textoR.setText("No es posible el cálculo");
    }

    private boolean esEntero(String mensaje){
        try{
            int edad = Integer.parseInt(mensaje);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}