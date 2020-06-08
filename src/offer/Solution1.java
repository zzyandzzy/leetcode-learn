package offer;

/**
 * @author intent
 * @version 1.0
 * @date 2020/3/3 9:46 下午
 * @email zzy.main@gmail.com
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1 {
    public static void main(String[] args) {
//        merge(new int[]{}, 0, new int[]{}, 0);
//        merge(new int[]{1, 2, 3}, 3, new int[]{}, 0);
//        merge(new int[]{0, 0, 0, 0, 0, 0}, 0, new int[]{1, 2, 3}, 3);
//        merge(new int[]{7, 8, 9, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
//        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        merge(new int[]{-1, 0, 0, 3, 3, 3, 0, 0, 0}, 6, new int[]{1, 2, 2}, 3);
    }

    public static void merge(int[] A, int m, int[] B, int n) {
        int pa = m - 1, pb = n - 1;
        int tail = m + n - 1;
        int cur;
        while (pa >= 0 || pb >= 0) {
            if (pa == -1)
                cur = B[pb--];
            else if (pb == -1)
                cur = A[pa--];
            else if (A[pa] > B[pb])
                cur = A[pa--];
            else
                cur = B[pb--];
            A[tail--] = cur;
        }
        printArray(A);
    }

//    public static void merge(int[] A, int m, int[] B, int n) {
//        if (n == 0)
//            return;
//        // B肯定小于等于A
//        int l = 0, r = 0;
//        for (int i = 0; i < A.length; i++) {
//            if (r >= n)
//                break;
//            if (A[l] <= B[r]) {
//                if (A[l] == 0) {
//                    for (int j = l; j < A.length; j++) {
//                        A[j] = B[r++];
//                        if (r >= n)
//                            break;
//                    }
//                }
//                l++;
//            } else {
//                // B[r]放入A数组，A[i]后移一位
//                for (int j = A.length - 2; j >= l; j--) {
//                    A[j + 1] = A[j];
//                }
//                A[l] = B[r];
//                l++;
//                r++;
//            }
//        }
//        printArray(A);
//    }

    private static void printArray(int[] a) {
        for (int i : a) {
            System.out.println(i + " ");
        }
    }
}
