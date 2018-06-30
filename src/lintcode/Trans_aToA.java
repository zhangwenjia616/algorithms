package lintcode;

/**
 * 将一个字符由小写字母转换为大写字母
 * <p>
 * 样例
 * a -> A
 * b -> B
 * <p>
 * 65	A
 * 66 B
 * <p>
 * 97 a
 * 98 b
 *
 * 1. 小写字母数值更大 和大写的对应字母相差32
 * 2. char类型可以用比较运算符 比大小'a' < 'b' 也可以用算数运算符 'a' + 'b'
 *
 */
public class Trans_aToA {

    public static void main(String args[]) {
        System.out.println("转换后是: " + trans('z'));
    }

    public static char trans(char character) {
        if (character >= 'a' && character <= 'z') {
            return (char) (character - 32);
        } else {
            return character;
        }
    }
}
