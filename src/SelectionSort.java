import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 选择排序
 * 时间复杂度是 O(nXn)
 * n-1 + n-2 + n-3 + ... + 3 + 2 + 1 = n x (n - 1) / 2
 */
public class SelectionSort {

    public static void main(String args[]) {
        System.out.println("");
        System.out.println("******** SelectionSort 选择排序 *********");

        Integer[] list = {999, 100, 30, 4, 10, -17, 20, 60, 8, 150, -300, 110};
        ArrayList<Integer> listArr = new ArrayList<>();
        listArr.addAll(Arrays.asList(list));

        ArrayList<Integer> result = selectionSort(listArr);
        System.out.println("排序后的结果是: " + result);
    }

    /**
     * 列表从小到大 选择排序
     *
     * 输入一个无序数组
     * 返回一个从小到大排序好的数组
     *
     * @param list
     * @return
     */
    public static ArrayList<Integer> selectionSort(ArrayList<Integer> list) {
        ArrayList<Integer> newArray = new ArrayList<>();

        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            int smallestIndex = findSmallest(list);
            int smallest = list.remove(smallestIndex); // 从列表中 弹出最小的 列表数量减少1
            newArray.add(smallest); // 加入到新的数组中去
        }
        return newArray;
    }

    /**
     * 找出列表中最小的元素
     *
     * @param list
     * @return 返回最小的值的index
     */
    public static int findSmallest(List<Integer> list) {
        int smallestIndex = 0; // 默认 取出列表中第一个元素 认为是最小的
        int smallest = list.get(smallestIndex);

        // 从第二个数开始比较
        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            if (current < smallest) {
                smallestIndex = i;
                smallest = current;
            }
        }

        return smallestIndex;
    }
}
