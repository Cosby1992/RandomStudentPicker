package cosby.dk.ungdomsskolen.model;

import java.io.*;
import java.util.ArrayList;

public class FileUtils {

    private final String FILENAME = "classes.txt";


    public FileUtils() {
    }

    public void writeToFile(Class shcoolClass){

        String currentClass = "";

        try {
            FileWriter writer = new FileWriter(FILENAME);

            currentClass = shcoolClass.getClass_id();

            for (int i = 0; i < shcoolClass.getStudentList().size(); i++) {

                writer.write(shcoolClass.getStudentList().get(i).getName() + System.lineSeparator());

            }

            writer.close();

        } catch (IOException e) {
            System.out.println("failed to save class " + currentClass);
            e.printStackTrace();
        }

    }



    public ArrayList<Student> readArrayListFromFile(){

        ArrayList<Student> studentsFromFile = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(FILENAME));

        String line;

        while ((line = reader.readLine()) != null) {
            studentsFromFile.add(new Student(line));
        }

        reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentsFromFile;

    }







}
