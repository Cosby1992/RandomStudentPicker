package cosby.dk.ungdomsskolen.view.controller;

import cosby.dk.ungdomsskolen.Main;
import cosby.dk.ungdomsskolen.model.Class;
import cosby.dk.ungdomsskolen.model.Student;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Controller for add_class_view.fxml
 * Handles inputs from user, modulates model classes and updates UI accordingly
 */
public class AddClassViewController {


    //Variables (gui objects) from fxml layout file
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

    //declaring Class object
    private Class currentClass;

    /**
     * Constructor
     * Is called before initialize
     */
    public AddClassViewController() {
        currentClass = new Class();
    }

    @FXML
    public void initialize() {
        //add a text change listener to class name textfield
        tf_className.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                currentClass.setClass_id(newValue);
                lbl_classNameTitle.setText(currentClass.getClass_id());
            }
        });
    }

    //runs when user presses enter in class name textfield
    //not used at the moment // replaced with listener
    public void changeClassName(ActionEvent actionEvent) {


//        currentClass.setClass_id(tf_className.getText());
//        lbl_classNameTitle.setText(currentClass.getClass_id());
//        updateTextArea();
//
//        System.out.println("Set class name to " + tf_className.getText());

    }

    /**
     * Adds student name to Class and updates ui
     * Runs when enter is pressed in student name textfield
     */
    public void addStudent(ActionEvent actionEvent) {

        //adds student to model class
        currentClass.addStudentToClass(tf_studentName.getText());

        //update textfield
        tf_studentName.setText("");
        //update textarea
        updateTextArea();

    }

    /**
     * writes Class to file and sends user to main screen
     * Runs when user presses save button
     */
    public void saveClass(ActionEvent actionEvent) {

        currentClass.writeToFile();
        System.out.println("saved class");

        toMainScreen(new ActionEvent());

    }


    //updates the textarea with values from Class's list of students
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

    /**
     * changes UI to show mainScreen
     * Runs when user presses on go back button
     */
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
