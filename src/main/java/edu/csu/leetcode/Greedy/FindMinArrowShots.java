package edu.csu.leetcode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        //将数组按照右边界进行排序
        Arrays.sort(points, Comparator.comparing(o -> o[1]));

        int cnt = 1, end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            //如果我们的下一个区间与上一个区间重叠了，那么一箭就可以穿过这两只气球
            if (points[i][0] <= end)
                continue;
            //否则需要再射一箭并且修改判断区间重叠的边界
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }
}
