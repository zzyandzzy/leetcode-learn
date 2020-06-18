package main.simple.string;

/**
 * main.simple.string
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/18 10:15 上午
 * @since 1.0
 */
public class Solution415 {
    public static void main(String[] args) {
        System.out.println(addStrings("", ""));
        System.out.println(addStrings("", "1"));
        System.out.println(addStrings("1", ""));
        System.out.println(addStrings2("123", "10"));
        System.out.println(addStrings2("123", "100"));
        System.out.println(addStrings2("123", "1000"));
        System.out.println(addStrings2("6913259244", "71103343"));
        System.out.println(addStrings2("9", "99"));
    }

    /**
     * 双指针两两直接相加，用一个int表示进位
     * <p>
     * info
     * 解答成功:
     * 执行耗时:3 ms,击败了80.92% 的Java用户
     * 内存消耗:39.7 MB,击败了8.33% 的Java用户
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings2(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }

    /**
     * 直接将num1，num2转换为int，再相加
     * 这样不行！！！因为字符串的长度小于5100，意思是测试用例肯定有5100的字符串！！！
     * 看来只能直接相加了
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        if (num1.length() == 0 && num2.length() == 0) {
            return "0";
        }
        // num1
        long a = 0;
        // num2
        long b = 0;
        // 这个是倍率
        int rate = 1;
        for (int i = num1.length() - 1; i >= 0; i--) {
            a = a + (num1.charAt(i) - 48) * rate;
            rate *= 10;
        }
        rate = 1;
        for (int i = num2.length() - 1; i >= 0; i--) {
            a = a + (num2.charAt(i) - 48) * rate;
            rate *= 10;
        }
        return String.valueOf(a + b);
    }
}
