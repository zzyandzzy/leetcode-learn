// id: 面试题 01.03
// title: URL化
// slug: string-to-url-lcci
//URL化。编写一种方法，将字符串中的空格全部替换为%20。
// 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
// （注：用Java实现的话，
//请使用字符数组实现，以便直接在数组上操作。） 
//
// 示例1: 
//
//  输入："Mr John Smith    ", 13
// 输出："Mr%20John%20Smith"
// 
//
// 示例2: 
//
//  输入："               ", 5
// 输出："%20%20%20%20%20"
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 500000]范围内。 
// 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpaces(String S, int length) {
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
//leetcode submit region end(Prohibit modification and deletion)
