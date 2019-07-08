package cosby.dk.ungdomsskolen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class WheelOfStudentsController {

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

    public WheelOfStudentsController() {



    }

    public void spinWheel(ActionEvent actionEvent) {

        System.out.println("Spinning Wheel");

    }



    public void addNewClass(ActionEvent actionEvent) {

        System.out.println("adding new class");
    }

    public void addStudentToClass(ActionEvent actionEvent) {
        System.out.println("adding new student to class");
    }

    public void removeStudentFromClass(ActionEvent actionEvent) {

        System.out.println("remove student from class");
    }
}
