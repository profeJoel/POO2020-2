package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrimerGUI11 extends Application{
    Stage ventana;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ventana = primaryStage;
        primaryStage.setTitle("Restorant La ULA");

        Label titulo = new Label("Menu de Tocomples");

        ChoiceBox<String> tipoProteina = new ChoiceBox<>();
        tipoProteina.getItems().addAll(
            "Vienesa Normal",
            "Vienesa Artesanal",
            "Vienesa Vegana",
            "Ass Carne",
            "Ass Pollo"
        );
        tipoProteina.setValue("Vienesa Normal"); // debe estar en la lista

        Label agregados = new Label("Agregados:");
        CheckBox agregado1 = new CheckBox("Tomate");
        agregado1.setSelected(true);
        CheckBox agregado2 = new CheckBox("Palta");
        CheckBox agregado3 = new CheckBox("Chuckrut");
        CheckBox agregado4 = new CheckBox("Queso");

        Label aderezos = new Label("Aderezos:");
        CheckBox aderezo1 = new CheckBox("Mayonesa");
        aderezo1.setSelected(true);
        CheckBox aderezo2 = new CheckBox("Ketchup");
        CheckBox aderezo3 = new CheckBox("Mostaza");
        CheckBox aderezo4 = new CheckBox("Salsa Americana");
        CheckBox aderezo5 = new CheckBox("Salsa Queso");

        Label orden = new Label();

        Button boton = new Button("Hacer Pedido!");
        boton.setOnAction(e -> manejarOpciones(tipoProteina, agregado1, agregado2, agregado3, agregado4,aderezo1, aderezo2, aderezo3, aderezo4, aderezo5, orden));

        VBox panel = new VBox(30);
        panel.setPadding(new Insets(20,20,20,20));
        panel.getChildren().addAll(titulo, tipoProteina, agregados, agregado1, agregado2, agregado3, agregado4, aderezos, aderezo1, aderezo2, aderezo3, aderezo4, aderezo5, boton, orden);

        Scene tema = new Scene(panel, 600, 900);
        
        ventana.setScene(tema);
        primaryStage.show();
    }

    private void manejarOpciones(ChoiceBox<String> tp, CheckBox a1, CheckBox a2, CheckBox a3, CheckBox a4, CheckBox s1, CheckBox s2, CheckBox s3, CheckBox s4, CheckBox s5, Label textoSalida)
    {
        String mensaje = "El cliente ordena un Tocomple <";
        mensaje += tp.getValue();

        mensaje += "> con Agregados: ";
        if(a1.isSelected()) mensaje += "\n - " + a1.getText();
        if(a2.isSelected()) mensaje += "\n - " + a2.getText();
        if(a3.isSelected()) mensaje += "\n - " + a3.getText();
        if(a4.isSelected()) mensaje += "\n - " + a4.getText();

        mensaje += "\n con Aderezos: ";
        if(s1.isSelected()) mensaje += "\n - " + s1.getText();
        if(s2.isSelected()) mensaje += "\n - " + s2.getText();
        if(s3.isSelected()) mensaje += "\n - " + s3.getText();
        if(s4.isSelected()) mensaje += "\n - " + s4.getText();
        if(s5.isSelected()) mensaje += "\n - " + s5.getText();

        textoSalida.setText(mensaje);
    }
}