package main.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * main.offer
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 * <p>
 *  
 * <p>
 * 注意：本题与主站 65 题相同：https://leetcode-cn.com/problems/valid-number/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/7/15 9:38 下午
 * @since 1.0
 */
public class Solution20 {
    public static void main(String[] args) {
        System.out.println(isNumber("+++++"));
    }

    /**
     * 有限状态机
     *
     * 9种状态
     * 0. 开始的空格
     * 1. 幂符号前的正负号
     * 2. 小数点前的数字
     * 3. 小数点、小数点后的数字
     * 4. 当小数点前为空格时，小数点、小数点后的数字
     * 5. 幂符号
     * 6. 幂符号后的正负号
     * 7. 幂符号后的数字
     * 8. 结尾的空格
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/mian-shi-ti-20-biao-shi-shu-zhi-de-zi-fu-chuan-y-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 执行用时：
     * 8 ms
     * , 在所有 Java 提交中击败了
     * 22.70%
     * 的用户
     * 内存消耗：
     * 39.8 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param s
     * @return
     */
    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Map[] states = {
                new HashMap<Character,Integer>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap<Character,Integer>() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap<Character,Integer>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap<Character,Integer>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap<Character,Integer>() {{ put('d', 3); }},                                        // 4.
                new HashMap<Character,Integer>() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap<Character,Integer>() {{ put('d', 7); }},                                        // 6.
                new HashMap<Character,Integer>() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap<Character,Integer>() {{ put(' ', 8); }}                                         // 8.
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == '.' || c == 'e' || c == 'E' || c == ' ') t = c;
            else t = '?';
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
