package edu.csu.leetcode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShotsII {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int cnt = 1, end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            //如果我们的下一个区间与上一个区间重叠了，那么一箭就可以穿过这两只气球
            if (points[i][0] > end) {
                cnt++;
                end = points[i][1];
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        int res = findMinArrowShots(points);
        System.out.println(res);
    }
}
