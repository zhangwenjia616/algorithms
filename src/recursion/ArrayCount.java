package recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 计算列表包含的元素数
 */
public class ArrayCount {

    public static void main(String args[]) {
        System.out.println("");
        System.out.println("******** ArrayCount 递归 数个数 *********");

        Integer[] list = {999, 0, 1, 2, 3};
        ArrayList<Integer> listArr = new ArrayList<>();
        listArr.addAll(Arrays.asList(list));

        int result = count(listArr);
        System.out.println("ArrayCount 递归 数个数的结果是: " + result);
    }

    /**
     * @param list
     * @return
     */
    public static int count(ArrayList<Integer> list) {
        // 退出递归的条件 (基线条件 base case)
        if (list == null || list.size() == 0) {
            return 0;
        }

        // 递归条件
        else {
            list.remove(0);
            ArrayList newList = new ArrayList<>();
            newList.addAll(list);
            return 1 + count(newList);
        }
    }

}
