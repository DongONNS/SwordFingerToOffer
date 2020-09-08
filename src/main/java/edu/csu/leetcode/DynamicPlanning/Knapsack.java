package edu.csu.leetcode.DynamicPlanning;

public class Knapsack {
    public int knapsack(int N,int W,int[] weights,int[] values){
        // dp[j]表示总体积最大为j时的最大价值
        int[] dp = new int[W + 1];

        for(int i = 1;i <= N;i++){
            int w = weights[i - 1];
            int v = values[i - 1];

            for(int j = W;j >= 1;j--){
                // dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - w] + v);
                // 前i个物品的背包体积不大于j的时候最大价值分为两种
                // 1.不将物品放入背包中
                // 2.将物品放入背包中
                // 因为我们的dp[i][j]状态只跟dp[i - 1][j]有关，所以可以

                if(j >= w){
                    dp[j] = Math.max(dp[j] , dp[j - w] + v);
                }
            }
        }
        return dp[N];
    }
}
