// id: 面试题 01.04
// title: 回文排列
// slug: palindrome-permutation-lcci
//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。 
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 
//
// 回文串不一定是字典当中的单词。 
//
// 
//
// 示例1： 
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
// 
//
// 
// Related Topics 哈希表 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        // 把s字符串里面出现的次数记录在map里面
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int val = 1;
            Integer oldVal = map.get(c);
            if (oldVal != null) {
                val += oldVal;
            }
            map.put(c, val);
        }
        // 如果回文字符串是奇数
        // 只允许一个位置的元素是奇数
        if (s.length() % 2 != 0) {
            int sum = 0;
            for (Integer val : map.values()) {
                if (val % 2 != 0) {
                    sum++;
                    if (sum > 1){
                        return false;
                    }
                }
            }
        } else {
            // 如果是偶数回文字符串
            // map里面不能有一个奇数字符串v
            for (Integer val : map.values()) {
                if (val % 2 == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
