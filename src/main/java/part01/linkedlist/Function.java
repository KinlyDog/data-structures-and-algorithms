package part01.linkedlist;

public class Function {
    public static LinkedList sumOfLists(LinkedList first, LinkedList second) {
        LinkedList result = new LinkedList();

        if (first.count() != second.count()) {
            return result;
        }

        Node one = first.head;
        Node two = second.head;

        while (one != null) {
            Node sum = new Node(one.value + two.value);

            result.addInTail(sum);

            one = one.next;
            two = two.next;
        }

        return result;
    }
}
