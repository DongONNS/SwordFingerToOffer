package edu.csu.leetcode.DynamicPlanning;

import java.util.Arrays;
import java.util.Comparator;

public class IntervalSchedule {
    public int intervalSchedule(int[][] intvs){
        if (intvs.length == 0) return 0;
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //至少存在一个区间不相交
        int count = 1;
        //排序后，第一个区间就是x
        int x_end = intvs[0][1];
        for (int[] interval : intvs){
            int start = interval[0];
            if (start >= x_end){
                count ++;
                x_end = interval[1];
            }
        }
        return count;
    }
}
