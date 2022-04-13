package edu.csu.leetcode.array;

public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zeros = 0;
        int res = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left++] == 0) {
                    zeros--;
                }
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
