import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 * 1. 选择基准值
 * 2. 将数组分成两个子数组 小于基准值的元素和大于基准值的元素
 * 3. 对这两个子数组进行快速排序
 */
public class QuickSort {

    public static void main(String args[]) {
        System.out.println("");
        System.out.println("******** QuickSort 快速排序 使用递归*********");

        // 被测试数组
        Integer[] list = {300, 1000, 3, 4, 10, 17, 20, -60, 81, 150, 1, };
        ArrayList<Integer> listArr = new ArrayList<>();
        listArr.addAll(Arrays.asList(list));

        ArrayList<Integer> resultList = quickSort(listArr);

        System.out.println("" + resultList);
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> list) {

        if (list.size() < 2) {
            return list;
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        // 基准值
        // int base = list.get(0);

        // 想生成范围在[0,n]的整数
        // random.nextInt(n+1)
        Random r = new Random(); // 0 到 list.size()-1
        int base = r.nextInt(list.size());

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < base) { // 放在左边的分组
                leftList.add(list.get(i));
            } else { // 放在右边的分组
                rightList.add(list.get(i));
            }
        }

        resultList.addAll(quickSort(leftList));
        resultList.add(base);
        resultList.addAll(quickSort(rightList));

        return resultList;
    }
}
