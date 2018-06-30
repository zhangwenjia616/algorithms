package lintcode;

/**
 * 反转一个只有3位数的整数。
 * 可以假设输入一定是一个只有三位数的整数，这个整数大于等于100，小于1000
 * <p>
 * 样例:
 * 123 反转之后是 321
 * 900 反转之后是 9
 */
public class Reverse3Digit {

    public static void main(String args[]) {
        int result = reverse(831, 100);
        System.out.println("result: " + result);
    }

    public static int reverse(int number, int dividend) {
        // 987 / 100 = 9...87
        // 87 / 10 = 8...7
        // 7 / 1 = 7...0

        int result = 0;
        int times = 1;
        while (dividend >= 1) {
            int quotient = number / dividend; // 商
            int remainder = number % dividend; // 余数

            result += quotient * times;

            dividend /= 10;
            times *= 10;
            number = remainder;
        }
        return result;
    }


}
