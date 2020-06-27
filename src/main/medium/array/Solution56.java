package main.medium.array;

import main.util.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * main.simple.array
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/27 6:20 下午
 * @since 1.0
 */
public class Solution56 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        })));
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return list.toArray(new int[0][]);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            list.add(new int[]{left, right});
            i++;
        }
        return list.toArray(new int[0][]);
    }

}
