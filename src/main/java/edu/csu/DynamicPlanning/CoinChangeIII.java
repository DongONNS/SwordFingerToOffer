package edu.csu.DynamicPlanning;

public class CoinChangeIII {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        //如果币种为0，并且目标值为0，那么返回1，否则返回0；
        if(len == 0){
            if(amount == 0) return 1;
            return 0;
        }
        //dp数组的含义为到第i中硬币时，达到总金额为j的组合数量
        int[][] dp = new int[len][amount + 1];
        dp[0][0] = 1;

        //填写第一行,也即只有第一种硬币时可以凑出的总金额类型，可知所有coins[0]的倍数都可以实现
        for(int i = coins[0];i <= amount;i += coins[0])
            dp[0][i] = 1;

        for(int i = 1;i < len;i++){
            for(int j = 0;j <= amount;j++){
                for(int k = 0;j - k * coins[i] >= 0;k++){
                    dp[i][j] += dp[i - 1][j - k * coins[i]];
                }
            }
        }
        return dp[len - 1][amount];
    }
}
