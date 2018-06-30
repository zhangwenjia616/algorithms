package lintcode;

/**
 * A + B 问题
 * 给出两个整数a和b
 * 求他们的和
 * 但不能使用 +数学运算符
 * <p>
 *
 * 解题思路:
 * 把加法拆成两步:
 * 1. 忽略进位，对应各位数字相加 (对应的二进制操作是: 异或的操作)
 * 0＋0＝0，0＋1＝1，1＋0＝1，1＋1＝0
 *
 * 2. 只记录进位，而忽略位数相加 记录进位 (对应的二进制操作是: 按位& 并且<<1)
 *
 * 3. 第一步结果和第二步结果相加 得到最终的结果
 * <p>
 * 第3步用了加法 而题目不让用加法
 * 那么既然是两个数相加
 * 就可以重复1,2步骤 直到两个操作数的结果其中一个是0 意味着不用再相加了 返回另一个操作数即可 退出递归
 * <p>
 * 用递归做
 * 1. 基线条件是
 * 两个操作数 其中一个为0 则返回另一个操作数
 */
public class AplusB {

    public static void main(String args[]) {
        int result = solution(1, 2);
        System.out.println("result: " + result);
    }

    public static int solution(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        int x = a ^ b;
        int y = (a & b) << 1;

        return solution(x, y);
    }

    // 二进制的运算
    // 按位与
    // 按位或
    // 异或

    // 左移
    // 右移

}
