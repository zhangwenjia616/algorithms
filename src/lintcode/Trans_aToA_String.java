package lintcode;

/**
 * 描述:
 * 将一个字符串中的小写字母转换为大写字母。忽略其他不是字母的字符。
 * <p>
 * 样例:
 * 给出 "abc" 返回 "ABC"
 * 给出 "aBc" 返回 "ABC"
 * 给出 "abC12" 返回 "ABC12"
 */
public class Trans_aToA_String {

    public static void main(String args[]) {
        System.out.println("转换后是: " + transString("aBc12"));
    }

    public static String transString(String str) {
        char[] chars = str.toCharArray();
        String transResult = "";
        for (char character : chars) {
            if (character >= 'a' && character <= 'z') {
                transResult += (char) (character - 32);
            } else {
                transResult += character;
            }
        }

        return transResult;
    }
}
