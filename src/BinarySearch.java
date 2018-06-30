/**
 * 二分查找 折半查找 循环方式
 * 时间复杂度是 O(logN)
 * <p>
 * 接收一个有序数组 和 一个元素
 * 如果指定的元素包含在数组中 这个函数将返回其位置
 */
public class BinarySearch {

    public static void main(String args[]) {
        System.out.println("");
        System.out.println("******** BinarySearch 二分查找 折半查找 *********");

        // 被测试数组
        int[] list = {-1, 3, 4, 10, 17, 20, 60, 81, 150, 300, 1000};

        // 查找边界
        int[] list1 = {0, 300};
        int resultIndex = binarySearch(list, 0);

        if (resultIndex == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到了 resultIndex is: " + resultIndex);
        }
    }

    /**
     * 二分查找
     *
     * @param list 有序数组
     * @param item 被查找的元素
     * @return 如果在list中找到了 则返回位置, 如果没找到 返回-1
     */
    public static int binarySearch(int[] list, int item) {
        if (list.length == 0) {
            return -1;
        }

        // 有两个指针 分别指向集合的最低和最高处
        // 通过不断的移动指针的位置 缩小查找范围 每次缩小一半距离
        int low = 0; // 最低指针的初始值
        int high = list.length - 1; // 最高指针的初始值

        // 确定被查找的元素是在待查找数组的范围内
        if (list[low] > item) {
            return -1;
        } else if (list[high] < item) {
            return -1;
        }

        // 高低两个指针 可以重合
        // 重合的意思是 范围缩小到只包含一个元素
        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];
            if (guess == item) {
                return mid; // 找到了 返回索引值
            } else if (guess < item) {
                low = mid + 1; // 移动最低的指针位置
            } else if (guess > item) {
                high = mid - 1; // 移动最高的指针位置
            }
        }

        return -1;
    }
}
