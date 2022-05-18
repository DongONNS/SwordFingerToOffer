package edu.csu.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dongcheng_2018@163.com
 * @Date 2022/5/19 0:04
 */
public class LongestConsecutive {
    public int longestConsecutive(final int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currLen = 1;
                int currNum = num;
                while (set.contains(currNum + 1)) {
                    currLen++;
                    currNum++;
                }
                res = Math.max(currLen, res);
            }
        }
        return res;
    }
}
