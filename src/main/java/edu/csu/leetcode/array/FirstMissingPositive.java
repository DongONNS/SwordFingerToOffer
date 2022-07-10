package edu.csu.leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] src = {1, 2, 0};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int res = firstMissingPositive.firstMissingPositive(src);
        System.out.println(res);
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int max = 0;
        for (int j : nums) {
            max = Math.max(j, max);
        }
        if (max == 0) {
            return 1;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        for (int i = 1; i <= max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return max + 1;
    }
}
