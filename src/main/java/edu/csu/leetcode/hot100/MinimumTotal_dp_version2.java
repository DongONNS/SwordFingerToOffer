package edu.csu.leetcode.hot100;

import java.util.List;

public class MinimumTotal_dp_version2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j]表示从点（i,j）到底边的最小路径和
        int[] dp = new int[n + 1];
        // 从最后一行开始
        for(int i = n - 1;i >= 0;i--){
            // 从前向后开始推进
            for(int j = 0;j <= i;j++){
                dp[j] = Math.min(dp[j],dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }
}
