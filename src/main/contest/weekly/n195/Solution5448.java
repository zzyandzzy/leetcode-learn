package main.contest.weekly.n195;

import java.util.*;

/**
 * main.contest.weekly.n195
 * <p>
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 * <p>
 * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 * <p>
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：path = "NES"
 * 输出：false
 * 解释：该路径没有在任何位置相交。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：path = "NESWW"
 * 输出：true
 * 解释：该路径经过原点两次。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= path.length <= 10^4
 * path 仅由 {'N', 'S', 'E', 'W} 中的字符组成
 *
 * @author intent zzy.main@gmail.com
 * @date 2020/6/28 10:29 上午
 * @since 1.0
 */
public class Solution5448 {
    public static void main(String[] args) {
        System.out.println(isPathCrossing("NES"));
        System.out.println(isPathCrossing("NESWW"));
        System.out.println(isPathCrossing("WW"));
        System.out.println(isPathCrossing("S"));
        System.out.println(isPathCrossing("WSSESEEE"));
        System.out.println(isPathCrossing("NNSWWEWSSESSWENNW"));
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x &&
                    y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static boolean isPathCrossing(String path) {
        List<Pos> list = new ArrayList<>();
        int x = 0;
        int y = 0;
        list.add(new Pos(x, y));
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') {
                y++;
            } else if (path.charAt(i) == 'S') {
                y--;
            } else if (path.charAt(i) == 'E') {
                x++;
            } else {
                x--;
            }
            Pos pos = new Pos(x, y);
            if (list.contains(pos)) {
                return true;
            }
            list.add(pos);
        }
        return false;
    }
}
