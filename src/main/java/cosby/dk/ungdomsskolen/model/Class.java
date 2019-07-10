package cosby.dk.ungdomsskolen.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class contains a list of students and a class ID (name)
 */
public class Class {

    //declaring instance variables
    private String class_id;
    private ArrayList<Student> studentList;

    /**
     * no arg constructor
     * initializing instance variables
     */
    public Class() {
        //initializing instance variables
        class_id = "No class ID yet";
        studentList = new ArrayList<>();
    }

    /**
     * Constructor that takes class ID (name) argument as String
     * @param class_id assigns value to instance variable
     */
    public Class(String class_id) {
        this.class_id = class_id;
        studentList = new ArrayList<>();
    }


    /**
     * Write Class object to a file in defaultlocation/classes as txt file.
     */
    public void writeToFile(){

        try {
            //write each student name to file and separate line
            FileWriter writer = new FileWriter("classes/" + class_id + ".txt");

            for (int i = 0; i < studentList.size(); i++) {
                writer.write(studentList.get(i).getName() + System.lineSeparator());
            }

            //close FileWriter
            writer.close();

        } catch (IOException e) {
            //if writing fails
            System.out.println("failed to save class " + class_id);
            e.printStackTrace();
        }

    }

    /**
     * Reads a Class object from file and assign values to instance variables
     */
    public void readArrayListFromFile(){

        //initialising temporary arraylist used in loop
        ArrayList<Student> studentsFromFile = new ArrayList<>();

        try {
            //reading file assigning Student objects to list
            BufferedReader reader = new BufferedReader(new FileReader("classes/" + class_id + ".txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                studentsFromFile.add(new Student(line));
            }

            //closing FileReader
            reader.close();

        } catch (IOException e) {
            //if reading fails
            e.printStackTrace();
        }

        //assign temp list to instance variable list
        studentList = studentsFromFile;

    }

    /**
     * method that assigns a student to class by name
     * @param studentName name to assign to student list
     */
    public void addStudentToClass (String studentName){
        if (!studentName.isEmpty()) {
            studentList.add(new Student(studentName));
        }
    }


    /////////////////////////////////////// GETTERS AND SETTERS /////////////////////////////////////////////

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
}
