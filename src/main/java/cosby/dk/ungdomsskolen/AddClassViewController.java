package cosby.dk.ungdomsskolen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddClassViewController {

    @FXML
    TextArea ta_classStudentList;
    @FXML
    TextField tf_studentName;
    @FXML
    Button btn_goBack;
    @FXML
    TextField tf_className;




    public void toMainScreen(ActionEvent actionEvent) {

        try {
            Parent mainRoot = FXMLLoader.load(getClass().getClassLoader().getResource("main_screen.fxml"));
            Main.getPrimaryStage().setScene(new Scene(mainRoot, 600, 400));

        } catch (IOException e) {
            System.out.println("Failed to load classRoot");
            e.printStackTrace();
        }


    }

    public void changeClassName(ActionEvent actionEvent) {

        System.out.println("Set class name to " + tf_className.getText());

    }

    public void addStudent(ActionEvent actionEvent) {

        System.out.println("add student with the name of " + tf_studentName.getText());

    }

    public void saveClass(ActionEvent actionEvent) {

        System.out.println("save class");

    }
}
