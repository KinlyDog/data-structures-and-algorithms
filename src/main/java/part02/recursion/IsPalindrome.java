package part02.recursion;

public class IsPalindrome {
    public static boolean isPalindrome(String string) {
        if (string.length() < 2) {
            return true;
        }

        if (string.charAt(0) != string.charAt(string.length() - 1)) {
            return false;
        }

        return isPalindrome(string.substring(1, string.length() - 1));
    }
}
