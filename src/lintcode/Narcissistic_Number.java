package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 水仙花数的定义是，这个数等于他每一位上数的幂次之和 见维基百科的定义
 * <p>
 * 比如一个3位的十进制整数153就是一个水仙花数。因为 153 = 1^3 + 5^3 + 3^3。
 * 而一个4位的十进制数1634也是一个水仙花数，因为 1634 = 1^4 + 6^4 + 3^4 + 4^4。
 * <p>
 * 给出n，找到所有的n位十进制水仙花数。
 * 你可以认为n小于8。
 * <p>
 * 样例:
 * 比如 n = 1, 所有水仙花数为：[0,1,2,3,4,5,6,7,8,9]。
 * 而对于 n = 2, 则没有2位的水仙花数，返回 []。
 */
public class Narcissistic_Number {

    public static void main(String args[]) {
        int n = 1;
        System.out.println(n + " 位的自然数中 所有的水仙花是: " + narcissistic(n));
    }

    public static List<Integer> narcissistic(int n) {
        // n = 1 (0 - 9)
        // n = 2 (10 - 99) start是 10的一次方 10
        // n = 3 (100 - 999) start是 10的二次方 100
        // n = 4 (1000 - 9999) start是 10的三次方 1000
        // n = 5 (10000 - 99999) start是 10的四次方 10000

        int start = 1;
        int end;
        int digit = n;
        while (--digit != 0) {
            start *= 10;
        }
        end = start * 10 - 1;

        System.out.println("start: " + start + ", end: " + end);

        // 用来存放给定位数下 的所有水仙花数
        List<Integer> numbersResult = new ArrayList<>();
        if (n == 1) {
            numbersResult.add(0);
        }

        // 遍历每一个数字
        for (int i = start; i <= end; i++) {
            int dividend = start;
            // 自然数是i 把i按位拆了 存放的列表
            List<Integer> numbers = new ArrayList<>();
            int remainder = i;
            while (dividend >= 1) {
                int quotient = remainder / dividend; // 商
                remainder = remainder % dividend; // 余数

                numbers.add(quotient);
                dividend /= 10;
            }

            System.out.println("拆分数字为: " + numbers);

            // 看numbers的数 表示每位上的数 能否幂加之后 等于这个自然数
            int result = 0;
            for (int number : numbers) {
                // 求number的n次方
                int m = n;
                int temp = 1;
                while (m != 0) {
                    temp *= number;
                    m--;
                }
                result += temp;
            }

            if (result == i) {
                numbersResult.add(i);
            }
        }
        return numbersResult;
    }

}
