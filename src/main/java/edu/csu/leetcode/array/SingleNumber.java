package edu.csu.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
  public int singleNumber(int[] nums) {
    Map<Integer,Integer> map = new HashMap();
    for (int value : nums) {
      map.put(value, map.getOrDefault(value, 0));
    }
    Set<Integer> set = map.keySet();
    for (int num : set) {
      if (map.get(num) == 1) {
        return num;
      }
    }
    return -1;
  }
}
