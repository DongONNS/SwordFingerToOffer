package edu.csu.leetcode.DynamicPlanning.zeroonepackage;

/*
Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.
 */

/*
解题思路:
因为硬币可以重复使用，因此这是一个完全背包问题。
完全背包只需要将 0-1 背包的逆序遍历 dp 数组改为正序遍历即可
*/

public class CoinChangeDP {
    public int coinChange(int[] coins,int amount){
        // dp[j] 表示金额为j时的最小组合数量
        int[] dp = new int[amount + 1];

        for(int coin : coins){
            for (int i = coin ; i <= amount;i++){
                // 如果这个硬币刚好为金额的大小，那么就直接放入背包中
                if (i == coin)
                    dp[i] = 1;
                // 如果这个金额还没有凑出来的方式，并且金额 - 硬币面额可以放入
                // 那么金额i的组成为dp[i - coin] + 1;
                else if (dp[i] == 0 && dp[i - coin] != 0)
                    dp[i] = dp[i - coin] + 1;
                // 这个情况是金额有凑出来的形式，我们需要比较两种凑法哪种更加合适
                else if (dp[i - coin] != 0){
                    dp[i] = Math.min(dp[i],dp[i - coin] + 1 );
                }
            }
        }

        return dp[amount];
    }
}
