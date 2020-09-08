package edu.csu.leetcode.DynamicPlanning.gupiao;

/*

 */

// 允许任意次的股票交易
public class maxProfitThatKIsAnyInt {
    public int maxProfit(int[] prices,int k){
        int n = prices.length;
        if(n == 0) return 0;

        if(k > n/2)
            return maxProfit_k_inf(prices);

        int[][][] dp = new int[n][k + 1][2];

        // 还没开始交易的时候的处理方式
        for(int i = 0;i <= k;i++){
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1;i < n;i++){
            for(int j = k;j >= 1;j--){
                dp[i][j][0] = Math.max(dp[i - 1][j][0],dp[i - 1][j][1] + prices[i]);

                dp[i][j][1] = Math.max(dp[i - 1][j][1],dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    // 可以有无限次交易次数的股票交易
    private int maxProfit_k_inf(int[] prices){
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;

        for(int i = 0;i < prices.length;i++) {
            int temp = dp_i_0;

            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1,temp - prices[i]);
        }
        return dp_i_0;
    }
}
