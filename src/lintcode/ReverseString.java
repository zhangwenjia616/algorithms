package lintcode;

public class ReverseString {

    public static void main(String args[]) {
        System.out.println("转换后是: " + reverseString("zhangwenjia"));
    }

    public static String reverseString(String str) {
        String reverseResult = "";
        char[] chars = str.toCharArray();
        for (char c : chars) {
            reverseResult = c + reverseResult; // 前加
        }
        return reverseResult;
    }
}
