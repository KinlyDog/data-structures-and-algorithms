package part02.recursion;

import java.util.ArrayList;

public class PrintingEvenIndex {
    public static void printingEvenIndex(ArrayList<Integer> list) {
        printingEvenIndexRec(list, 0);
    }

    private static void printingEvenIndexRec(ArrayList<Integer> list, int index) {
        if (index >= list.size()) {
            return;
        }

        System.out.println(list.get(index));

        printingEvenIndexRec(list, index + 2);
    }
}
