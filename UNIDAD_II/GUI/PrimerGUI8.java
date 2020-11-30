package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrimerGUI8 extends Application{
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

        HBox menuSuperior = new HBox();
        Button bA = new Button("A");
        Button bB = new Button("B");
        Button bC = new Button("C");
        menuSuperior.getChildren().addAll(bA,bB,bC);

        VBox menulateral = new VBox();
        Button bD = new Button("D");
        Button bE = new Button("E");
        Button bF = new Button("F");
        menulateral.getChildren().addAll(bD,bE,bF);

        BorderPane panel = new BorderPane();
        panel.setTop(menuSuperior);
        panel.setLeft(menulateral);

        Scene tema = new Scene(panel, 400, 300);
        
        ventana.setScene(tema);
        primaryStage.show();
    }
}