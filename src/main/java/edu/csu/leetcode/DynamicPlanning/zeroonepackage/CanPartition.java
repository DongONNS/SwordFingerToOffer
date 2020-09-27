package edu.csu.leetcode.DynamicPlanning.zeroonepackage;

public class CanPartition {
    public boolean canPartition(int[] nums){
        int len = nums.length;
        if (len == 0) return false;

        // 计算nums数组的总和
        int sum = 0;
        for (int num:nums){
            sum += num;
        }

        // 如果总和为一个奇数，那么直接返回false
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;

        // 定义动态规划数组dp dp[i]表示背包中的数字i能否有nums数组中的数字组成
        // 初始化dp dp[0]，不放入数字背包是成立的。
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        if (nums[0] <= target)
            dp[nums[0]] = true;

        for (int i = 1;i < len;i++){
            for (int j = target;nums[i] <= target;j--){
                if (dp[target])
                    return true;
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
