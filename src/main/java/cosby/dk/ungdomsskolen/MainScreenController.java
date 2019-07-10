package cosby.dk.ungdomsskolen;

import cosby.dk.ungdomsskolen.model.Class;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.List;


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

    private List<Class> classes;

    public MainScreenController() throws IOException {

    }

    @SuppressWarnings("unchecked")
    public void initialize(){

        FileAdapter fileAdapter = new FileAdapter();

        ObservableList<String> list = FXCollections.observableArrayList(fileAdapter.getFileList());
        choiceBox_selectClass.setItems(list);
        choiceBox_selectClass.getSelectionModel().selectFirst();

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
