package cosby.dk.ungdomsskolen;

import cosby.dk.ungdomsskolen.model.Student;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

import java.util.ArrayList;
import java.util.List;

/**
 * This class generates arcs based on the number of students and then
 * groups them together to complete a "jepardy wheel"
 */
public class ArcGenerator {

    //instance variables
    private List<Arc> wheel;
    private List<Label> labels;
    private int numOfStudents;
    private float degrees = 360.0f;
    private ArrayList<Student> students = new ArrayList<>();

    //for color control
    private int colorNumber = 0;


    /**
     * no arg constructor // you have to manually generate wheel if you choose this option
     */
    public ArcGenerator() {

    }

    /**
     *  Constructor that instantly generates the the "jepardy wheel"
     * @param students arrayList of Student
     * @param center center of "jepardy wheel"
     */
    public ArcGenerator(ArrayList<Student> students, Point2D center){
        generateWheel(students, center);
    }


    /**
     * This method generates a new "jepardy wheel"
     *
     * @param students arrayList of Student
     * @param center center of "jepardy wheel"
     */
    public void generateWheel(ArrayList<Student> students, Point2D center){
        //assign number of students if possible from arraylist of students
        //assign local student list
        if(!students.isEmpty() || students != null) {
            this.students = students;
            numOfStudents = students.size();

            System.out.println("Number of students = " + numOfStudents);

        } else {
            //if arraylist is empty or is null
            numOfStudents = 1;

            System.out.println("Number of students = " + numOfStudents);

        }

        //defines relationship between degrees and number of students
        degrees = 360f / numOfStudents;

        System.out.println("Degrees set to " + degrees);

        wheel = new ArrayList<>();
        labels = new ArrayList<>();

        //generate an arc for each student to complete a circle
        for (int i = 0; i < numOfStudents; i++) {

            //creating arc at centerpoint from argument
            Arc arc = new Arc();
            Label label = new Label();

            label.setText(students.get(i).getName());

            System.out.println("x translation on label = " + i + "  " + (center.getX() + (100 * Math.cos(i * degrees + (degrees/2f)))));
            System.out.println("y translation on label = " + i + "  " + (center.getY() + (100 * Math.sin(i * degrees + (degrees/2f)))));

            label.translateXProperty().setValue(center.getX() + (100 * Math.cos(i * degrees)));
            label.translateYProperty().setValue(center.getY() + (100 * Math.sin(i * degrees)));


            label.rotateProperty().setValue(i * degrees + (degrees/2f));

            labels.add(label);

            arc.setCenterX(center.getX());
            arc.setCenterY(center.getY());

            //setting arch size
            arc.setRadiusX(150);
            arc.setRadiusY(150);

            // setting where each arc should start,
            // to complete a circle
            arc.setStartAngle(i*degrees);
            arc.setLength(degrees);

            //setting arc type,
            //to form a circle
            arc.setType(ArcType.ROUND);

            //Setting arc color
            arc.setFill(generateNext());

            //adding to arc list
            wheel.add(arc);
        }
    }


    /**
     * This method generates a Group (Node) from the list of arcs
     * @return the group containing the "jepardy wheel"
     */
    public Group getGroup(){
        Group group = new Group();

        for (int i = 0; i < wheel.size(); i++) {
            group.getChildren().add(wheel.get(i));
        }

        return group;
    }

    public Group getLabelNames(){
        Group group = new Group();

        for (int i = 0; i < labels.size(); i++) {
            labels.get(i).toFront();
            group.getChildren().add(labels.get(i));
        }

        return group;
    }

    //method used to generate colors for the "jepardy wheel"
    private Color generateNext(){

        Color col = Color.WHEAT;

        switch (colorNumber){
            case 0: colorNumber++; col = Color.YELLOW; break;
            case 1: colorNumber++; col = Color.ORANGERED; break;
            case 2: colorNumber++; col = Color.BLUE; break;
            case 3: colorNumber++; col = Color.GREEN; break;
            case 4: colorNumber++; col = Color.BEIGE; break;
            case 5: colorNumber++; col = Color.LAVENDER; break;
            case 6: colorNumber++; col = Color.LIGHTGREEN; break;
            case 7: colorNumber++; col = Color.INDIGO; break;
            case 8: colorNumber++; col = Color.ORANGE; break;
            case 9: colorNumber++; col = Color.PALETURQUOISE; break;
            case 10: colorNumber++; col = Color.ROSYBROWN; break;
            case 11: colorNumber++; col = Color.GREENYELLOW; break;
            case 12: colorNumber++; col = Color.CRIMSON; break;
            case 13: colorNumber++; col = Color.VIOLET; break;
            case 14: colorNumber++; col = Color.SALMON; break;
            case 15: colorNumber++; col = Color.AQUA; break;
            case 16: colorNumber++; col = Color.BISQUE; break;
            case 17: colorNumber++; col = Color.GAINSBORO; break;
            case 18: colorNumber = 0; col = Color.LAWNGREEN; break;
        }

        return col;

    }

}
