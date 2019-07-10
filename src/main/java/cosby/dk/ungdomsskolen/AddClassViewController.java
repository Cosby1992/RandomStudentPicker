package cosby.dk.ungdomsskolen;

import cosby.dk.ungdomsskolen.model.Class;
import cosby.dk.ungdomsskolen.model.Student;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddClassViewController {


    @FXML
    Label lbl_classNameTitle;
    @FXML
    TextArea ta_classStudentList;
    @FXML
    TextField tf_studentName;
    @FXML
    TextField tf_className;
    @FXML
    Button btn_goBack, btn_saveClass;

    private Class currentClass;

    public AddClassViewController() {
        currentClass = new Class();
    }

    @FXML
    public void initialize() {
        tf_className.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                currentClass.setClass_id(newValue);
                lbl_classNameTitle.setText(currentClass.getClass_id());
            }
        });
    }

    public void changeClassName(ActionEvent actionEvent) {


//        currentClass.setClass_id(tf_className.getText());
//        lbl_classNameTitle.setText(currentClass.getClass_id());
//        updateTextArea();
//
//        System.out.println("Set class name to " + tf_className.getText());

    }

    public void addStudent(ActionEvent actionEvent) {

        currentClass.addStudentToClass(tf_studentName.getText());
        tf_studentName.setText("");

        updateTextArea();

        System.out.println("add student with the name of " + tf_studentName.getText());

    }

    public void saveClass(ActionEvent actionEvent) {

        currentClass.writeToFile();
        System.out.println("save class");

    }

    private void updateTextArea(){

        if(!currentClass.getStudentList().isEmpty()) {

            StringBuilder output = new StringBuilder();

            for (Student s : currentClass.getStudentList()) {
                output.append(s.getName() + System.lineSeparator());
            }

            ta_classStudentList.setText(output.toString());

            System.out.println(currentClass.getStudentList().size());
        }

    }

    public void toMainScreen(ActionEvent actionEvent) {

        try {
            Parent mainRoot = FXMLLoader.load(getClass().getClassLoader().getResource("main_screen.fxml"));
            Main.getPrimaryStage().setScene(new Scene(mainRoot, 600, 400));

        } catch (IOException e) {
            System.out.println("Failed to load classRoot");
            e.printStackTrace();
        }
    }

}
