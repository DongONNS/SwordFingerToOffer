package edu.csu.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Insert {

  public static void main(String[] args) {
    int[][] interval = {{1,2},{3,5},{6,7},{8,10},{12,16}};
    int[] newInterval = {4,8};
    int[][] res = insert(interval, newInterval);
    System.out.println(res);
  }

  public static int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> res = new ArrayList();
    int len = intervals.length;
    int currIndex = 0;
    while(currIndex < len && intervals[currIndex][1] < newInterval[0]){
      res.add(intervals[currIndex]);
      currIndex++;
    }

    // 此处根据插入数组的右边界跟数组有交叠
    while(currIndex < len && intervals[currIndex][0] <= newInterval[1]){
      newInterval[0] = Math.min(intervals[currIndex][0], newInterval[0]);
      newInterval[1] = Math.max(intervals[currIndex][1], newInterval[1]);
      currIndex++;
    }
    res.add(newInterval);

    while(currIndex < len && intervals[currIndex][0] > newInterval[1]){
      res.add(intervals[currIndex]);
      currIndex++;
    }
    return res.toArray(new int[0][]);
  }
}
