package javaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ejemploJavaFX9 extends Application{

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
        panel.setVgap(8);
        panel.setHgap(10);

        Label textoNombreUsuario = new Label("UserName:");
        GridPane.setConstraints(textoNombreUsuario, 0, 0);

        TextField textoEntrada = new TextField("Usuario");
        GridPane.setConstraints(textoEntrada, 1, 0);

        
        Label textoPassword = new Label("Password:");
        GridPane.setConstraints(textoPassword, 0, 1);

        PasswordField textoEntradaPassword = new PasswordField();
        textoEntradaPassword.setPromptText("password");
        GridPane.setConstraints(textoEntradaPassword, 1, 1);

        Button botonLogin = new Button("Entrar");
        botonLogin.setOnAction(e -> System.out.println("> Usuario:" + textoEntrada.getText() + " Password: " + textoEntradaPassword.getText()));
        GridPane.setConstraints(botonLogin, 1, 2);

        panel.getChildren().addAll(textoNombreUsuario, textoEntrada, textoPassword, textoEntradaPassword, botonLogin);

        Scene capa = new Scene(panel, 300, 200);
        ventana.setScene(capa);
        ventana.show();
    }
}