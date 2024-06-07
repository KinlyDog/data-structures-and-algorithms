package part02.recursion;

import java.util.ArrayList;

public class SecondMaximum {
    public static int secondMaximum(ArrayList<Integer> list) {
        sortDesc(list, true);

        return list.get(1);
    }

    private static void sortDesc(ArrayList<Integer> list, boolean isSorted) {
        if (!isSorted) {
            return;
        }

        isSorted = false;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) > list.get(i)) {
                list.add( i + 1, list.remove(i));

                isSorted = true;
            }
        }

        sortDesc(list, isSorted);
    }
}
