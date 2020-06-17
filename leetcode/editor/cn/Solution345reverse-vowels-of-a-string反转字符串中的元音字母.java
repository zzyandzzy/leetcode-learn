// id: 345
// title: 反转字符串中的元音字母
// slug: reverse-vowels-of-a-string
//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 示例 1: 
//
// 输入: "hello"
//输出: "holle"
// 
//
// 示例 2: 
//
// 输入: "leetcode"
//输出: "leotcede" 
//
// 说明: 
//元音字母不包含字母"y"。 
// Related Topics 双指针 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int left = 0;
        int right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (left <= right) {
            if (checkVowel(arr[left])) {
                if (checkVowel(arr[right])) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                }
                right--;
            } else if (checkVowel(arr[right])) {
                if (checkVowel(arr[left])) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    right--;
                }
                left++;
            } else {
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    private static boolean checkVowel(char c) {
        return c == 'a' || c == 'A' ||
                c == 'e' || c == 'E' ||
                c == 'i' || c == 'I' ||
                c == 'o' || c == 'O' ||
                c == 'u' || c == 'U';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
