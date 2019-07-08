package cosby.dk.ungdomsskolen.model;

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
