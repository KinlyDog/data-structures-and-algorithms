package part02.recursion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static part02.recursion.SearchAllFilesInDir.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchAllFilesInDirTest {

    @TempDir
    Path tempDir;

    @Test
    void testEmptyDirectory() {
        ArrayList<File> result = searchAllFilesInDir(new File(tempDir.toString()));
        assertEquals(0, result.size());
    }

    @Test
    void testDirectoryWithFilesOnly() throws IOException {
        Path file1 = Files.createFile(tempDir.resolve("file1.txt"));
        Path file2 = Files.createFile(tempDir.resolve("file2.txt"));

        List<Path> expectedFiles = List.of(file1, file2);

        ArrayList<File> result = searchAllFilesInDir(new File(tempDir.toString()));

        assertEquals(expectedFiles.size(), result.size());
        for (Path expectedFile : expectedFiles) {
            assertTrue(result.contains(expectedFile.toFile()));
        }
    }

    @Test
    void testDirectoryWithSubdirectoriesAndFiles() throws IOException {
        Path subDir1 = Files.createDirectory(tempDir.resolve("subDir1"));
        Path subDir2 = Files.createDirectory(tempDir.resolve("subDir2"));
        Path file1 = Files.createFile(tempDir.resolve("file1.txt"));
        Path file2 = Files.createFile(subDir1.resolve("file2.txt"));
        Path file3 = Files.createFile(subDir2.resolve("file3.txt"));

        List<Path> expectedFiles = List.of(file1, file2, file3);

        ArrayList<File> result = searchAllFilesInDir(new File(tempDir.toString()));

        assertEquals(expectedFiles.size(), result.size());
        for (Path expectedFile : expectedFiles) {
            assertTrue(result.contains(expectedFile.toFile()));
        }
    }

    @Test
    void testEmptySubdirectories() throws IOException {
        Files.createDirectory(tempDir.resolve("subDir1"));
        Files.createDirectory(tempDir.resolve("subDir2"));

        ArrayList<File> result = searchAllFilesInDir(new File(tempDir.toString()));

        assertEquals(0, result.size());
    }
}
