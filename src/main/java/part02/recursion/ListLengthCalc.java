package part02.recursion;

import java.util.ArrayList;

public class ListLengthCalc {
    public static int listLengthCalc(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }

        list.removeFirst();

        return 1 + listLengthCalc(list);
    }
}
