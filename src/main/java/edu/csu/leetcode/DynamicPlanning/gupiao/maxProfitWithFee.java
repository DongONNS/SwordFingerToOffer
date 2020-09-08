package edu.csu.leetcode.DynamicPlanning.gupiao;

/*
dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
解释：相当于买入股票的价格升高了。
在第一个式子里减也是一样的，相当于卖出股票的价格减小了。
 */

public class maxProfitWithFee {
    public int maxProfit(int[] prices,int fee){
        // 还没开始交易并且手头没有股票
        int dp_i_0 = 0;

        // 还没开始交易手头却持有股票，这是不合理的
        int dp_i_1 = Integer.MIN_VALUE;

        for(int i = 0;i < prices.length;i++){
            // 暂存住前一天的不持有股票最大利益
            // 后面用于计算dp_i_1
            int temp = dp_i_0;

            dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1,temp - prices[i] - fee);
        }

        return dp_i_0;
    }
}
