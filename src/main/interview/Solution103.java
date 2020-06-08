package main.interview;

/**
 * main.interview
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。
 * 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>
 * 示例1:
 * <p>
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * 示例2:
 * <p>
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 * 提示：
 * <p>
 * 字符串长度在[0, 500000]范围内。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/8 8:56 上午
 * @since 1.0
 */
public class Solution103 {
    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith    ", 13));
        System.out.println(replaceSpaces("               ", 5));
        System.out.println(replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27));
    }

    /**
     * 先确定下空格的长度就好办了
     * @param S
     * @param length
     * @return
     */
    public static String replaceSpaces(String S, int length) {
        int spaceLen = 0;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                spaceLen++;
            }
        }
        char[] data = new char[length - spaceLen + 3 * spaceLen];
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                data[j++] = '%';
                data[j++] = '2';
                data[j++] = '0';
            } else {
                data[j++] = S.charAt(i);
            }
        }
        return new String(data);
    }
}
