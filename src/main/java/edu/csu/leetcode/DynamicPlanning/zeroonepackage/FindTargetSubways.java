package edu.csu.leetcode.DynamicPlanning.zeroonepackage;

/*
Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
 */
/*
解题思路：
 p代表的是正数，n代表的是负数
 sum(p) - sum(n) = target
 sum(p) + sum(n) + sum(p) - sum(n) = target + sum(n) + sum(p);
 2sum(p) = target + sum
 */
public class FindTargetSubways {

    public int findTargetSumWays(int[] nums, int S) {
        // 非空判断
        int len = nums.length;
        if(len == 0) return 0;

        //计算nums数组的总和
        int sum = computeArraySum(nums);

        //如果nums数组总和小于目标值或者为奇数，那么不存在可用的p子集
        if(sum < S || (sum + S) % 2 == 1) return 0;

        //sum(p) = (sum + S) / 2
        int target = (sum + S) / 2;

        //dp[i]代表目标值为i时的子集数量
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for(int num : nums){
            for(int i = target; num <= i;i--)
                //dp[i]的值为将i假如子集或者不加入子集数值之和
                dp[i] = dp[i] + dp[i - num];
        }
        return dp[target];
    }

    // 计算数组元素总和
    private int computeArraySum(int[] nums){
        int res = 0;
        for (int num : nums){
            res += num;
        }
        return res;
    }
}

