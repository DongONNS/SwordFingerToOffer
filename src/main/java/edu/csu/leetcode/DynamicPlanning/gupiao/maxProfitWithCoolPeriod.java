package edu.csu.leetcode.DynamicPlanning.gupiao;
//
//dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
//dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
//解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。

public class maxProfitWithCoolPeriod {
    public int maxProfit(int[] prices){
        int n = prices.length;

        // 代表手上没有股票的时候
        int dp_i_0 = 0;

        // 代表还没开始交易时持有股票，这是不合理的
        int dp_i_1 = Integer.MIN_VALUE;

        // 代表dp[i - 2][0]
        int dp_pre_0 = 0;

        for(int i = 0;i < prices.length;i++){
            // 记录两天前的不持有股票的最大利益
            int temp = dp_i_0;

            dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);

            dp_i_1 = Math.max(dp_i_1,dp_pre_0 - prices[i]);

            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
}
