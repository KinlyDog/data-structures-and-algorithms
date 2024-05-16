package part01.stack;

public class Function {
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
}
