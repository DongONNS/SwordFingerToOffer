package edu.csu.leetcode.DynamicPlanning.gupiao;

/*

 */

// 只允许交易两次的股票交易
public class maxProfitThatKIsTwo {
    public int maxProfit(int[] prices){
        int n = prices.length;
        if(n == 0) return 0;

        int maxK = 2;

        int[][][] dp = new int[n][maxK + 1][2];

        // 还没开始交易的时候的处理方式
        for(int i = 0;i <= maxK;i++){
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1;i < n;i++){
            for(int j = maxK;j >= 1;j--){
                dp[i][j][0] = Math.max(dp[i - 1][j][0],dp[i - 1][j][1] + prices[i]);

                dp[i][j][1] = Math.max(dp[i - 1][j][1],dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][maxK][0];
    }
}
