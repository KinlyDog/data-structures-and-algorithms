package part02.recursion;

import java.util.ArrayList;

public class PrintingEvenValues {
    public static void printingEvenValues(ArrayList<Integer> list) {
        printingEvenValuesRec(list, 0);
    }

    private static void printingEvenValuesRec(ArrayList<Integer> list, int index) {
        if (index >= list.size()) {
            return;
        }

        int number = list.get(index);

        if (number % 2 == 0) {
            System.out.println(number);
        }

        printingEvenValuesRec(list, index + 1);
    }
}
