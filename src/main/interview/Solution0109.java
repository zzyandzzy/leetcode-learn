package main.interview;

/**
 * main.interview
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成
 * （比如，waterbottle是erbottlewat旋转后的字符串）。
 * <p>
 * 示例1:
 * <p>
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"
 * 输出：True
 * 示例2:
 * <p>
 * 输入：s1 = "aa", s2 = "aba"
 * 输出：False
 * 提示：
 * <p>
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 * <p>
 * 你能只调用一次检查子串的方法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-rotation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/17 7:43 下午
 * @since 1.0
 */
public class Solution0109 {
    public static void main(String[] args) {
        System.out.println(isFlipedString("waterbottle", "erbottlewat"));
        System.out.println(isFlipedString("aa", "aba"));
        System.out.println(isFlipedString("a", "a"));
        System.out.println(isFlipedString("a", "b"));
        System.out.println(isFlipedString("zzy", "zyz"));
    }

    /**
     * info
     * 解答成功:
     * 执行耗时:246 ms,击败了5.02% 的Java用户
     * 内存消耗:40.6 MB,击败了100.00% 的Java用户
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }
        char[] arr = s1.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            char temp = arr[0];
            System.arraycopy(arr, 1, arr, 0, arr.length - 1);
            arr[arr.length - 1] = temp;
            if (s2.equals(new String(arr))) {
                return true;
            }
        }
        return false;
    }
}
