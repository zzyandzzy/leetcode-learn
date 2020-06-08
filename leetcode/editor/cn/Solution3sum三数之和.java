// id: ${question.frontendQuestionId}
// title: 三数之和
// slug: 3sum
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 如果 *nums[i]*大于 0，则三数之和必然无法等于 0，结束循环
            if (nums[i] > 0) {
                break;
            }
            // 如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 当 sum == 0 时，nums[l] == nums[l+1] 则会导致结果重复，应该跳过，l++
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    // 当 sum == 0 时，nums[r] == nums[r-1] 则会导致结果重复，应该跳过，r--
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                }

            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
