package cosby.dk.ungdomsskolen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Handles application startup and loads main layout
 */
public class Main extends Application {

    //Static stage used to update UI from other views
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Update UI
        setPrimaryStage(primaryStage);
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main_screen.fxml"));
        primaryStage.setTitle("Random Student Picker");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

    /////////////////////////////////// GETTERS AND SETTERS /////////////////////////////////////////////

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Main.primaryStage = primaryStage;
    }

}
