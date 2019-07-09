package cosby.dk.ungdomsskolen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class MainScreenController {

    @FXML
    Button button_spinTheWheel;
    @FXML
    ListView listView_studentWheel;
    @FXML
    ChoiceBox choiceBox_selectClass;
    @FXML
    CheckBox checkBox_removeIfPicked;
    @FXML
    MenuBar menuBar_menu;

    public MainScreenController() throws IOException {




    }


    public void spinWheel(ActionEvent actionEvent) {

        System.out.println("Spinning Wheel");

    }



    public void addNewClass(ActionEvent actionEvent) {

        try {
            Parent classRoot = FXMLLoader.load(getClass().getClassLoader().getResource("add_class_view.fxml"));
           Main.getPrimaryStage().setScene(new Scene(classRoot, 600, 400));

        } catch (IOException e) {
            System.out.println("Failed to load classRoot");
            e.printStackTrace();
        }

    }

    public void addStudentToClass(ActionEvent actionEvent) {
        System.out.println("adding new student to class");
    }

    public void removeStudentFromClass(ActionEvent actionEvent) {

        System.out.println("remove student from class");
    }
}
