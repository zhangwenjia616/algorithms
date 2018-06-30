public class BitOperation {


    public static void main(String args[]) {
        System.out.println("");
        System.out.println("******** 位运算 *********");

        int n = 27;
        System.out.println("二进制:" + Integer.toBinaryString(n));
        System.out.println("八进制:" + Integer.toOctalString(n));
        System.out.println("十六进制:" + Integer.toHexString(n));

        bitwiseAND(n);

        // 左移1位相当与乘2  右移动1位相当与除2

        // 5<<2=20; //左移2位  5*2*2=20
        // 5>>1=2; //右移1位  5/2=2

        // 位操作取余应该只是适用：求一个数 除以 2的N次冥

    }

    public static void bitwiseAND(int number) {
        System.out.println("******** 按位&运算 *********");

        // 用于整数的奇偶性判断
        // 一个整数a, a&1 这个表达式可以用来判断a的奇偶性。
        // 二进制的末位为0表示偶数，最末位为1表示奇数。
        // 使用 a%2 来判断奇偶性和 a&1 是一样的作用，但是a&1要快好多。
        // 结果是0 or 1
        // 1是奇数
        // 2是偶数
        System.out.println("******** 整数的奇偶性判断 *********");
        System.out.println((number & 1));


    }
}
