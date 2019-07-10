package cosby.dk.ungdomsskolen.view.controller;

import cosby.dk.ungdomsskolen.FileAdapter;
import cosby.dk.ungdomsskolen.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;


/**
 * Controller for main_screen.fxml
 * Handles inputs from user, modulates model classes and updates UI accordingly
 */
public class MainScreenController {

    //Variables (gui objects) from fxml layout file
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


    @SuppressWarnings("unchecked")
    public void initialize(){

        //filling choisebox with options (filenames)
        FileAdapter fileAdapter = new FileAdapter();

        ObservableList<String> list = FXCollections.observableArrayList(fileAdapter.getFileList());
        choiceBox_selectClass.setItems(list);
        choiceBox_selectClass.getSelectionModel().selectFirst();

    }


    public void spinWheel(ActionEvent actionEvent) {

        System.out.println("Spinning Wheel");

    }


    /**
     * Sends user to add_class_view.fxml view
     * Runs when user presses menu options "add class"
     */
    public void addNewClass(ActionEvent actionEvent) {

        //updates UI
        try {
            Parent classRoot = FXMLLoader.load(getClass().getClassLoader().getResource("add_class_view.fxml"));
            Main.getPrimaryStage().setScene(new Scene(classRoot, 600, 400));

        } catch (IOException e) {
            //if resource fails to load
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
