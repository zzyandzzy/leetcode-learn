package main.simple.string;

/**
 * main.simple.string
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/18 11:06 上午
 * @since 1.0
 */
public class Solution434 {
    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
        System.out.println(countSegments("           "));
        System.out.println(countSegments("      a   "));
        System.out.println(countSegments("      ,     "));
    }

    /**
     * 这里想直接用split切割，再判断数组里面有没有单词，但是，一个逗号都算单词？？？
     * <p>
     * info
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:37.3 MB,击败了14.29% 的Java用户
     *
     * @param s
     * @return
     */
    public static int countSegments(String s) {
        String[] arr = s.split(" ");
        int count = 0;
        for (String s1 : arr) {
            for (int i = 0; i < s1.length(); i++) {
                int c = s1.charAt(i);
                if (c != ' ') {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
