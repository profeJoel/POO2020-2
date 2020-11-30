package GUI;

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

public class PrimerGUI10 extends Application{
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

        Label titulo = new Label("Es mayor de edad?");
        GridPane.setConstraints(titulo, 0, 0);

        //Elementos para datos de usuario
        Label textoEdad = new Label("Edad Usuario: ");
        GridPane.setConstraints(textoEdad, 0, 1);
        TextField entrada = new TextField();
        entrada.setPromptText("Edad Usuario");
        GridPane.setConstraints(entrada, 1, 1);
        
        Label resultado = new Label("Resultado");
        GridPane.setConstraints(resultado, 0, 3);

        Button boton = new Button("Verificar Edad");
        boton.setOnAction(e -> {
            if(esEntero(entrada.getText()))
            {
                resultado.setText("Edad es: " + entrada.getText());
                int edad = Integer.parseInt(entrada.getText());
                if(edad >= 0)
                {
                    if(edad >= 18)
                        resultado.setText("Es Mayor de Edad");
                    else
                        resultado.setText("Es Menor de Edad");
                }
                else
                    resultado.setText("Error, edad menor que 0!");
            }
            else
                resultado.setText("Error, No es Numero");
        });
        GridPane.setConstraints(boton, 1, 2);


        panel.getChildren().addAll(titulo, textoEdad, entrada, boton, resultado);

        Scene tema = new Scene(panel, 400, 300);
        
        ventana.setScene(tema);
        primaryStage.show();
    }

    private boolean esEntero(String mensaje){
        try{
            //toda la rutina a probar
            int edad = Integer.parseInt(mensaje);
            //System.out.println("La edad del usuario es: " + edad);
            return true;
        }catch(NumberFormatException e){
            //hacer una rutina de manejo de error
            //System.out.println("Error: " + mensaje + "No es un numero entero");
            return false;
        }
    }
}