package part01.deque;

public class Functions {
    public static boolean isPalindrome(String string) {
        if (string.length() < 2) {
            return true;
        }

        Deque<Character> deque = new Deque<>();

        for (int i = 0; i < string.length() / 2; i++) {
            deque.addFront(string.charAt(i));
            deque.addTail(string.charAt(string.length() - 1 - i));
        }

        while (deque.size() > 0) {
            if (deque.removeFront() != deque.removeTail()) {
                return false;
            }
        }

        return true;
    }
}
