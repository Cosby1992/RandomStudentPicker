package cosby.dk.ungdomsskolen;

import cosby.dk.ungdomsskolen.model.Class;
import cosby.dk.ungdomsskolen.model.FileUtils;
import cosby.dk.ungdomsskolen.model.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("wheelOfStudents.fxml"));
        primaryStage.setTitle("Random Student Picker");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();


        Class shcoolClass = new Class();
        shcoolClass.setClass_id("TestKlasse1");

        shcoolClass.getStudentList().add(new Student("TestNavn3"));
        shcoolClass.getStudentList().add(new Student("TestNavn4"));

        FileUtils fileUtils = new FileUtils();

        fileUtils.writeToFile(shcoolClass);

        Class newClass = new Class();

        newClass.setStudentList(fileUtils.readArrayListFromFile());

        for (int i = 0; i < newClass.getStudentList().size(); i++) {
            System.out.println(newClass.getStudentList().get(i).getName());
        }


    }


    public static void main(String[] args) {
        launch(args);
    }
}
