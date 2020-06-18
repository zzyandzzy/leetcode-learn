package main.simple.string;

/**
 * main.simple.string
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * <p>
 *  
 * <p>
 * 注意：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/18 9:46 上午
 * @since 1.0
 */
public class Solution383 {
    public static void main(String[] args) {
        System.out.println(canConstruct2("", "a"));
        System.out.println(canConstruct2("b", ""));
        System.out.println(canConstruct2("a", "b"));
        System.out.println(canConstruct2("aa", "ab"));
        System.out.println(canConstruct2("aa", "aab"));
        System.out.println(canConstruct2("aa", "aba"));
        System.out.println(canConstruct2("aa", "bcdaefgdhskhjk"));
    }

    /**
     * 注意到题目中说，字符只能是小写字母，那么我们可以使用int[]来代替散列表的功能，以c - 'a'为数组索引，值依然为该字母出现的次数。
     * 逻辑结构与方法2一样，不够这样节约了散列函数计算的时间，也节约了散列冲突的处理时间，所以会快很多。
     * 时间复杂度为O(m + n)O(m+n)。空间复杂度为O(1)O(1)（数组长度是常数）
     * <p>
     * 作者：ustcyyw
     * 链接：https://leetcode-cn.com/problems/ransom-note/solution/383java-shuang-zhi-zhen-ha-xi-biao-shu-zu-dai-ti-h/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * info
     * 解答成功:
     * 执行耗时:3 ms,击败了79.50% 的Java用户
     * 内存消耗:40.3 MB,击败了8.33% 的Java用户
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] countR = new int[26];
        int[] countM = new int[26];
        for (char c : ransomNote.toCharArray())
            countR[c - 'a'] += 1;
        for (char c : magazine.toCharArray())
            countM[c - 'a'] += 1;
        for (int i = 0; i < 26; i++) {
            if (countR[i] > countM[i])
                return false;
        }
        return true;
    }

    /**
     * 这是题目我是真的懵逼
     * <p>
     * 把ransomNote转换为数组，循环magazine.length，
     * 遇到ransomNote中的字符就去除一个，直到ransomNote为空
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }
        if (ransomNote.length() == magazine.length() && ransomNote.length() == 0) {
            return true;
        } else if (ransomNote.length() == 0 || magazine.length() == 0) {
            return false;
        }
        int j = 0;
        for (int i = 0; i < magazine.length(); i++) {
            if (magazine.charAt(i) == ransomNote.charAt(j)) {
                ransomNote = ransomNote.substring(1);
                if (ransomNote.length() == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
