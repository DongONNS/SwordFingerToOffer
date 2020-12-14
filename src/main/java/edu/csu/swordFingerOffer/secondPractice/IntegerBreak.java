package edu.csu.swordFingerOffer.secondPractice;

public class IntegerBreak {
    public int integerBreak(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2;i <= n;i++){
            for (int j = 1;j < i;j++){
                // 新增的两种组合方式
                dp[i] = Math.max(dp[i],Math.max(j * (i - j),dp[j]*(i - j)));
            }
        }
        return dp[n];
    }
}
