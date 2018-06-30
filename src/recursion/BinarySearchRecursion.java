package recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 二分查找 折半查找 递归方式
 * 时间复杂度是 O(logN)
 * <p>
 * 接收一个有序数组 和 一个元素
 */
public class BinarySearchRecursion {

    public static void main(String args[]) {
        System.out.println("");
        System.out.println("******** BinarySearch 二分查找 折半查找 *********");

        // 被测试数组
        Integer[] list = {-1, 3, 4, 10, 17, 20, 60, 81, 150, 300, 1000};
        ArrayList<Integer> listArr = new ArrayList<>();
        listArr.addAll(Arrays.asList(list));


//        subList 的返回值是新list 但是原始list不变
//        listArr.subList(0, 3); // 0,1,2
//        listArr.subList(3, list.length); // 3,4,...list.length-1
//        System.out.println(listArr);

        boolean result = binarySearch(listArr, 20);

        if (result) {
            System.out.println("找到了");
        } else {
            System.out.println("没有找到");
        }
    }

    /**
     * 二分查找
     * <p>
     * 基线条件 数组只包含一个元素 如果要查找的值与这个元素相同 就找到了 否则 就说明它不在数组中
     * 递归条件 把数组分成两半 将其中一半丢弃 并对另一半执行二分查找
     *
     * @param list 有序数组
     * @param item 被查找的元素
     * @return 如果在list中找到了 返回true, 如果没找到 返回false
     */
    public static boolean binarySearch(ArrayList<Integer> list, int item) {
        if (list.size() == 0) { // 基线条件 && 异常判断
            return false;
        } else if (list.size() == 1) { // 基线条件 退出条件
            if (list.get(0) == item) {
                return true;
            } else {
                return false;
            }
        } else { // 递归条件
            ArrayList<Integer> newlist = new ArrayList<>();
            int mid = (list.size() - 1) / 2;
            if (list.get(mid) > item) { // 去掉 中间到最大的
                newlist.addAll(list.subList(0, mid));
            } else if (list.get(mid) == item) {
                return true; // 退出条件
            } else {
                newlist.addAll(list.subList(mid + 1, list.size()));
            }

            return binarySearch(newlist, item);
        }
    }
}
