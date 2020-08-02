package edu.csu.leetcode.DynamicPlanning;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        //进行交易的最多次数
        int max_k = 2;

        //n代表的是[0-i]天的状态，max_k代表最多交易的次数，2表示有两种状态
        int[][][] dp = new int[n][max_k + 1][2];
//        for(int i = 0;i <= max_k;i++){
//            dp[-1][i][0] = 0;
//            dp[-1][i][1] = Integer.MIN_VALUE;
//        }
//        for(int i = 0;i < n;i++){
//            dp[i][0][0] = 0;
//            dp[i][0][1] = Integer.MIN_VALUE;
//        }

        for(int i = 1;i < n;i++){
            for(int j = max_k;j >= 1;j--){
                //对i = 0的状态进行特殊处理
                //dp[0][~][0] = 0   dp[0][~][1] = infinity
                if(i == 0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                }

                dp[i][j][0] = Math.max(dp[i - 1][j][0],dp[i - 1][j][1] + prices[i]);

                dp[i][j][1] = Math.max(dp[i - 1][j][1],dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int ans = maxProfit(prices);
        System.out.println(ans);
    }
}
