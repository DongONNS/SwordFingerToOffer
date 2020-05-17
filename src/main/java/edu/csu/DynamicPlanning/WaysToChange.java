package edu.csu.DynamicPlanning;

//凑零钱的方式数量
public class WaysToChange {
    public int waysToChange(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        int[] coins = {1,5,10,25};
        for (int coin : coins){
            for (int i = coin;i <= n;i++){
                dp[i] = (dp[i] + dp[i-coin]);
            }
        }
        return dp[n];
    }
}
