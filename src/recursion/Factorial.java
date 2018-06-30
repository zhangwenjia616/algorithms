package recursion;

/**
 * 递归
 * 计算阶乘
 */
public class Factorial {

    public static void main(String args[]) {
        System.out.println("");
        System.out.println("******** Factorial 递归 计算阶乘 *********");

        int result = fact(5);
        System.out.println("Factorial 递归 计算阶乘的结果是: " + result);
    }

    /**
     * 阶乘函数 5! = 5 x 4 x 3 x 2 x 1
     *
     * @param x
     * @return
     */
    public static int fact(int x) {
        if (x == 1) { // 退出条件
            return 1;
        } else { // 阶乘条件
            return x * fact(x - 1);
        }
    }

}
