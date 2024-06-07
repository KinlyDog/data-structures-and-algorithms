package part02.recursion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static part02.recursion.PrintingEvenIndex.*;

class PrintingEvenIndexTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void test0() {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        printingEvenIndex(list);

        StringBuilder expectedOutput = new StringBuilder();
        for (int i = 0; i < 20; i += 2) {
            expectedOutput.append(i).append(System.lineSeparator());
        }

        assertEquals(expectedOutput.toString(), outContent.toString());
    }

    @Test
    void test1() {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 20; i < 113; i++) {
            list.add(i);
        }

        printingEvenIndex(list);

        StringBuilder expectedOutput = new StringBuilder();
        for (int i = 20; i < 113; i += 2) {
            expectedOutput.append(i).append(System.lineSeparator());
        }

        assertEquals(expectedOutput.toString(), outContent.toString());
    }
}