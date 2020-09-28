package edu.csu.leetcode.DynamicPlanning.zeroonepackage;

public class FindTargetSubwaysII {
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S);
    }

    private int findTargetSumWays(int[] nums, int start, int S) {
        if (start == nums.length) {
            return S == 0 ? 1 : 0;
        }

        // 对每一个数字都尝试进行加或者减操作
        return findTargetSumWays(nums, start + 1, S + nums[start])
               + findTargetSumWays(nums, start + 1, S - nums[start]);
    }
}
