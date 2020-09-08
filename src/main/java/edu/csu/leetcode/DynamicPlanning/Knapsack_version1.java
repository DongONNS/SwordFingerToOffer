package edu.csu.leetcode.DynamicPlanning;

public class Knapsack_version1 {
    public int knapsack(int N,int W,int[] weights,int[] values){
        // dp[i][j]表示前i件物品，总体积最大为j时的最大价值
        int[][] dp = new int[N + 1][W + 1];

        for(int i = 1;i <= N;i++){
            int w = weights[i - 1];
            int v = values[i - 1];

            for(int j = W;j >= 1;j--){
                // dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - w] + v);
                // 前i个物品的背包体积不大于j的时候最大价值分为两种
                // 1.不将物品放入背包中
                // 2.将物品放入背包中

                // 物品可以放入到背包中
                if(j >= w){
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i - 1][j - w] + v);
                }else {
                // 物品无法放入背包中
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }
}
