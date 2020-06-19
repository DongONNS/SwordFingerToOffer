package edu.csu.leetcode.DynamicPlanning;

import java.util.Arrays;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp =new int[nums.length];
        Arrays.fill(dp,1);
        //完成对动态规划数组的记录
        for(int i = 0;i < nums.length;i++){
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i],dp[j] + 1);
            }
        }
        //得到最长上升子序列的最大值
        int res = 1;
        for(int i= 0; i < dp.length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
