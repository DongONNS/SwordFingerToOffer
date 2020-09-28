package edu.csu.leetcode.DynamicPlanning.zeroonepackage;

/*
nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
 */

import java.util.Arrays;

public class CombinationSum4 {
    public int combinationSum(int[] nums,int target){
        // 非空判断
        if (nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[target + 1];

        dp[0] = 1;

        // 这里一定要保证是从小到大排序的 这样覆盖前面的是正常的情况
        Arrays.sort(nums);

        for(int i = 1;i <= target;i++){
            for(int num : nums){
                if(num <= i)
                    dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
