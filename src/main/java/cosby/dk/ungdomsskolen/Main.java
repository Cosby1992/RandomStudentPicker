package cosby.dk.ungdomsskolen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        setPrimaryStage(primaryStage);
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main_screen.fxml"));
        primaryStage.setTitle("Random Student Picker");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Main.primaryStage = primaryStage;
    }

}
