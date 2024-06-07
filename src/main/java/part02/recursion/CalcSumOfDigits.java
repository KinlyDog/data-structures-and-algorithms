package part02.recursion;

public class CalcSumOfDigits {
    public static int calcSumOfDigits(int number) {
        if (number / 10 == 0) {
            return number;
        }

        return number % 10 + calcSumOfDigits(number / 10);
    }
}
