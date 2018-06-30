package recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 递归
 * 求一个数组的和 用递归的方式写
 * <p>
 * 递归写法:
 * 1. 先确定基线条件 就是递归的退出条件
 * 再写 递归条件
 * <p>
 * 2. 确定如何缩小问题的规律 使其符合基线条件
 * 找到规律 - 找到递归函数 (自己编的)
 * <p>
 * 递归是堆栈的调用
 * <p>
 * 思考:
 * 什么问题才能用递归解决?
 *
 * 我认为从前有个山 山里有个庙 不是递归
 * 因为没有 退出条件
 * 也没有目的性的缩小范围使符合基线条件
 *
 * 只是调用栈有点类似吧
 */
public class SumArray {

    public static void main(String args[]) {
        System.out.println("");
        System.out.println("******** SumArray 递归相加 *********");

        Integer[] list = {999, 0, 1, 2, 3};
        ArrayList<Integer> listArr = new ArrayList<>();
        listArr.addAll(Arrays.asList(list));

        int result = sum(listArr);
        System.out.println("SumArray 递归相加的结果是: " + result);
    }

    /**
     * @param list
     * @return
     */
    public static int sum(ArrayList<Integer> list) {
        // 退出递归的条件 (基线条件 base case)
        if (list == null || list.size() == 0) {
            return 0;
        }

        // 递归条件
        else {
            int first = list.remove(0);
            ArrayList newList = new ArrayList<>();
            newList.addAll(list);
            return first + sum(newList);
        }
    }

}
