package edu.csu.leetcode.DynamicPlanning.zeroonepackage;

/*
Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
 */
public class ChangeDP {
    public int change(int[] coins,int amount){
        // dp[i] 表示的是金额 i 的组成方式
        int[] dp = new int[amount + 1];

        // 金额为0时的组成方式为1 是为了便于那种只用一个硬币凑出金额的情况
        dp[0] = 1;

        // 外层控制的是行数
        for (int coin : coins){

            // 内层控制的是列数
            for (int i = coin;i <= amount;i++){
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
