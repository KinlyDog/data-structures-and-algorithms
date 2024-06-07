package part02.recursion;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class SearchAllFilesInDir {
    public static ArrayList<File> searchAllFilesInDir(String path) {
        File dir = new File(path);

        ArrayList<File> expand = new ArrayList<>(Arrays.asList(Objects.requireNonNull(dir.listFiles())));
        ArrayList<File> files = new ArrayList<>();

        return searchAllFilesInDirRec(expand, files);
    }

    private static ArrayList<File> searchAllFilesInDirRec(ArrayList<File> expand, ArrayList<File> files) {
        if (expand.isEmpty()) {
            return files;
        }

        File[] expandCopy = expand.toArray(new File[0]);
        expand.clear();

        for (File file : expandCopy) {
            if (file.isDirectory()) {
                expand.addAll(Arrays.asList(Objects.requireNonNull(file.listFiles())));
            } else {
                files.add(file);
            }
        }

        return searchAllFilesInDirRec(expand, files);
    }
}
