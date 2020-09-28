package edu.csu.leetcode.DynamicPlanning.zeroonepackage;

/*
Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
 */


public class CanPartition {
    public boolean canPartition(int[] nums){
        int len = nums.length;
        if (len == 0) return false;

        // 计算nums数组的总和
        int sum = computeArraySum(nums);

        // 如果总和为一个奇数，那么直接返回false
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;

        // 定义动态规划数组dp
        // dp[i]表示背包的容量(数字i)能否由nums数组中的数字组成
        // 初始化dp dp[0]，不放入数字背包是成立的。
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        // 讲下标索引为0的元素放入到dp数组中
        if (nums[0] <= target)
            dp[nums[0]] = true;

        // i代表物品的索引号
        for (int i = 1;i < len;i++){
            // j代表背包的容量
            for (int j = target;nums[i] <= target;j--){
                if (dp[target])
                    return true;
                // 背包容量为j能否被填满可以是将物品i放进背包或者不放进背包中两种方式进行判断
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    // 计算数组元素的总和
    private int computeArraySum(int[] array){
        int sum = 0;
        for (int num : array){
            sum += num;
        }
        return sum;
    }
}
