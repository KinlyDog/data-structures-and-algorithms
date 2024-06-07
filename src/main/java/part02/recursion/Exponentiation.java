package part02.recursion;

public class Exponentiation {
    public static int exponentiation(int number, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        if (exponent == 1) {
            return number;
        }

        return number * exponentiation(number, exponent - 1);
    }
}
