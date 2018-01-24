package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Guessing Game");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        Button restartGame = new Button("Restart Game");
    }


    public static void main(String[] args) {
        launch(args);
    }

}


