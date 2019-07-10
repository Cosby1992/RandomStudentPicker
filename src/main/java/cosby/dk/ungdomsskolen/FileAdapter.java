package cosby.dk.ungdomsskolen;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * FileAdapter retrieves files from directory and adds their names to a list
 */
public class FileAdapter {

    //instance variable
    private List<String> fileList;

    /**
     * no arg constructor
     * obtains files and adds them to a list
     */
    public FileAdapter() {


        fileList = new ArrayList<>();

        //retrieving files
        File folder = new File("classes");

        if(folder.listFiles() != null) {
            for (File f : folder.listFiles()) {
                fileList.add(f.getName().replace(".txt", ""));
            }
        }

    }

    ///////////////////////////////////////////////// GETTERS AND SETTERS //////////////////////////////////////////////

    public List<String> getFileList() {
        return fileList;
    }

    public void setFileList(List<String> fileList) {
        this.fileList = fileList;
    }
}
