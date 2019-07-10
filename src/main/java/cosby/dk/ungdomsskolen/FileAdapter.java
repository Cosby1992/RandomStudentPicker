package cosby.dk.ungdomsskolen;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileAdapter {

    private List<String> fileList;

    public FileAdapter() {

        fileList = new ArrayList<>();

        File folder = new File("classes");

        if(folder.listFiles() != null) {
            for (File f : folder.listFiles()) {
                fileList.add(f.getName().replace(".txt", ""));
            }
        }

    }

    public List<String> getFileList() {
        return fileList;
    }

    public void setFileList(List<String> fileList) {
        this.fileList = fileList;
    }
}
