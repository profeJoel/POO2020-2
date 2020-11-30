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

public class PrimerGUI9 extends Application{
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

        Label titulo = new Label("Bienvenido a la Interfaz de Usuario");
        GridPane.setConstraints(titulo, 0, 0);

        //Elementos para datos de usuario
        Label textoUsuario = new Label("Nombre Usuario: ");
        GridPane.setConstraints(textoUsuario, 0, 1);
        TextField entradaUsuario = new TextField("Nombre Usuario");
        GridPane.setConstraints(entradaUsuario, 1, 1);

        Label textoPassword = new Label("Password Usuario: ");
        GridPane.setConstraints(textoPassword, 0, 2);
        PasswordField entradaPassword = new PasswordField();
        entradaPassword.setPromptText("password");
        GridPane.setConstraints(entradaPassword, 1, 2);

        Button botonLogin = new Button("Ingresar");
        botonLogin.setOnAction(e -> {
            System.out.println("> Usuario: " + entradaUsuario.getText() + " password: " + entradaPassword.getText());
        });
        GridPane.setConstraints(botonLogin, 1, 3);

        panel.getChildren().addAll(titulo, textoUsuario, entradaUsuario, textoPassword, entradaPassword, botonLogin);

        Scene tema = new Scene(panel, 400, 300);
        
        ventana.setScene(tema);
        primaryStage.show();
    }
}