package part02.recursion;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class SearchAllFilesInDir {
    public static ArrayList<File> searchAllFilesInDir(File dir) {
        ArrayList<File> files = new ArrayList<>();

        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.isDirectory()) {
                files.addAll(searchAllFilesInDir(file));
            } else {
                files.add(file);
            }
        }

        return files;
    }
}
