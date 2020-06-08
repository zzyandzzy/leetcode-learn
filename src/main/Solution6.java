package main;

/**
 * @author intent
 * @version 1.0
 * @date 2020/3/3 12:10 下午
 * @email zzy.main@gmail.com
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution6 {

    public static void main(String[] args) {
//        System.out.println(convert("LEETCODEISHIRING", 3));
        System.out.println(convert("LEETCODEISHIRING", 4));
//        System.out.println(convert("LEETCODEISHIRING", 5));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

    /**
     * 二维数组
     *
     * @param s
     * @param numRows
     * @return
     */
//    public static String convert(String s, int numRows) {
//        if (s == null) {
//            return "";
//        }
//        // 先求出二维数组的长度
//        int width = 0;
//        int base = numRows;
//        for (int i = 1; i <= s.length(); i++) {
//            if (i == base) {
//                if (s.length() > i) {
//                    width += numRows - 1;
//                } else {
//                    width += 1 + (s.length() - i);
//                }
//                base += 2 * numRows - 2;
//            }
//        }
//        int arr[][] = new int[width][numRows];
//        base = numRows - 1;
//        // 加入二维数组
//        for (int i = 0; i < s.length() / width; i++) {
//            for (int j = 0; j < numRows; j++) {
//                if (i * numRows + j < base) {
//                    System.out.println("i:" + i + ",j:" + j + ":" + base);
//                    arr[i][j] = s.charAt(i * numRows + j);
//                } else if (i * numRows + j == base) {
////                    System.out.println(i * numRows + j + ":" + base);
//                    arr[i][j] = s.charAt(i * numRows + j);
//                    base += 2 * numRows - 2;
////                    System.out.println(base);
//                }
//            }
//        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int i1 = 0; i1 < numRows; i1++) {
//                System.out.print((char) arr[i][i1]);
//            }
//            System.out.println();
//        }
//        return null;
//    }
}
