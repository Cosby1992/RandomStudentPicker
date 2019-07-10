package cosby.dk.ungdomsskolen.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Class {

    private String class_id;
    private ArrayList<Student> studentList;

    public Class() {
        class_id = "No class ID yet";
        studentList = new ArrayList<>();
    }

    public Class(String class_id) {
        this.class_id = class_id;
    }

    public void writeToFile(){

        try {
            FileWriter writer = new FileWriter("classes/" + class_id + ".txt");

            for (int i = 0; i < studentList.size(); i++) {

                writer.write(studentList.get(i).getName() + System.lineSeparator());

            }

            writer.close();

        } catch (IOException e) {
            System.out.println("failed to save class " + class_id);
            e.printStackTrace();
        }

    }

    public void readArrayListFromFile(){

        ArrayList<Student> studentsFromFile = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("classes/" + class_id + ".txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                studentsFromFile.add(new Student(line));
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        studentList = studentsFromFile;

    }


    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public void addStudentToClass (String studentName){
        if (!studentName.isEmpty()) {
            studentList.add(new Student(studentName));
        }
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
}
