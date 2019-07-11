package cosby.dk.ungdomsskolen.view.controller;

import com.sun.org.apache.xerces.internal.dom.ChildNode;
import cosby.dk.ungdomsskolen.ArcGenerator;
import cosby.dk.ungdomsskolen.FileAdapter;
import cosby.dk.ungdomsskolen.Main;
import cosby.dk.ungdomsskolen.model.Class;
import javafx.animation.RotateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;


/**
 * Controller for main_screen.fxml
 * Handles inputs from user, modulates model classes and updates UI accordingly
 */
public class MainScreenController {


    //Variables (gui objects) from fxml layout file
    @FXML
    AnchorPane ap_anchorPane;
    @FXML
    Button button_spinTheWheel;
    @FXML
    ChoiceBox choiceBox_selectClass;
    @FXML
    CheckBox checkBox_removeIfPicked;
    @FXML
    MenuBar menuBar_menu;

    private ArcGenerator arcGenerator;
    private Class currentClass;
    private String filenameSelected;
    private FileAdapter fileAdapter;


    @SuppressWarnings("unchecked")
    public void initialize(){

        //filling choisebox with options (filenames)
        fileAdapter = new FileAdapter();

        ObservableList<String> list = FXCollections.observableArrayList(fileAdapter.getFileList());
        choiceBox_selectClass.setItems(list);
        choiceBox_selectClass.getSelectionModel().selectFirst();



        //generating the student wheel from the selected item in the choise box
        filenameSelected = fileAdapter.getFileList().get(0);

        arcGenerator = new ArcGenerator();
        currentClass = new Class();

        currentClass.setClass_id(filenameSelected.replace(".txt", ""));
        currentClass.readArrayListFromFile();

        arcGenerator.generateWheel(currentClass.getStudentList(), new Point2D(400,200));
        ap_anchorPane.getChildren().add(4, arcGenerator.getGroup());
        ap_anchorPane.getChildren().add(5, arcGenerator.getLabelNames());
        ap_anchorPane.getChildren().get(5).toFront();


        choiceBox_selectClass.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                filenameSelected = fileAdapter.getFileList().get(newValue.intValue());
                currentClass.setClass_id(filenameSelected.replace(".txt", ""));
                currentClass.readArrayListFromFile();

                arcGenerator.generateWheel(currentClass.getStudentList(), new Point2D(400,200));
                ap_anchorPane.getChildren().remove(5);
                ap_anchorPane.getChildren().remove(4);
                ap_anchorPane.getChildren().add(4, arcGenerator.getGroup());
                ap_anchorPane.getChildren().add(5, arcGenerator.getLabelNames());
                ap_anchorPane.getChildren().get(5).toFront();
            }
        });


    }

    private long timerForSpin = System.currentTimeMillis()-7000;
    public void spinWheel(ActionEvent actionEvent) {

        long newTime = System.currentTimeMillis();

        if(newTime > timerForSpin+7000) {
            timerForSpin = newTime;
            RotateTransition wheelTransition = new RotateTransition();

            wheelTransition.setDuration(Duration.seconds(7));
            wheelTransition.setNode(ap_anchorPane.getChildren().get(4));

            int rotation = (int) (Math.random() * 1080) + 4000;
            System.out.println("Spinning wheel rotation angle set to " + rotation);
            wheelTransition.setByAngle(rotation);

            //Setting the cycle count for the transition
            wheelTransition.setCycleCount(1);

            //Setting auto reverse value to false
            wheelTransition.setAutoReverse(false);

            RotateTransition labelTransition = new RotateTransition();

            labelTransition.setDuration(Duration.seconds(7));
            labelTransition.setNode(ap_anchorPane.getChildren().get(5));

            System.out.println("Spinning wheel rotation angle set to " + rotation);
            labelTransition.setByAngle(rotation);

            //Setting the cycle count for the transition
            labelTransition.setCycleCount(1);

            //Setting auto reverse value to false
            labelTransition.setAutoReverse(false);

            //Playing the animation
            labelTransition.play();

            //Playing the animation
            wheelTransition.play();
        }

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
