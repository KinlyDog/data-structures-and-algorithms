package part01.stack;

public class Functions {
    public static boolean isBalanced(String string) {
        Stack<Integer> stack = new Stack<>();

        if (string.isEmpty()) {
            return false;
        }

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (ch == ')' && stack.size() == 0) {
                return false;
            }

            if (ch == '(') {
                stack.push(1);
            } else {
                stack.pop();
            }
        }

        return stack.size() == 0;
    }

    public static int postfixCalc(String string) {
        Stack<Character> source = characterStack(string);
        Stack<Integer> integers = new Stack<>();

        while (source.size() > 0) {
            Character ch = source.pop();

            if (Character.isDigit(ch)) {
                integers.push(Character.digit(ch, 10));
                continue;
            }

            if (ch.equals('+')) {
                int sum = integers.pop() + integers.pop();

                integers.push(sum);
            }

            if (ch.equals('*')) {
                int mult = integers.pop() * integers.pop();

                integers.push(mult);
            }
        }

        return integers.peek();
    }

    private static Stack<Character> characterStack(String string) {
        Stack<Character> characters = new Stack<>();

        for (int i = string.length() - 1; i >= 0; i -= 2) {
            characters.push(string.charAt(i));
        }

        return characters;
    }
}
