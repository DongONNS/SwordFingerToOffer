package edu.csu.leetcode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {
    public int eraseOverlapInterval(int[][] intervals){
        if (intervals.length == 0) return 0;

        //将数组按照右边界从小到大排序
        Arrays.sort(intervals, Comparator.comparing(o -> o[1]));
        int cnt = 1;
        int end = intervals[0][1];

        //遍历数组，如果该数组的左边界大于上一区间的左边界，将无重叠区间数量+1；
        for (int i = 1;i < intervals.length;i++){

            //如果重叠了，直接跳过
            if (intervals[i][0] < end) continue;
            end = intervals[i][1];
            cnt++;
        }
        //总的区间数 - 无重叠区间数 即为需删除的区间数量
        return intervals.length - cnt;
    }
}
