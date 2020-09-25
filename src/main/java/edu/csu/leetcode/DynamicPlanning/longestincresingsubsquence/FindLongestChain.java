package edu.csu.leetcode.DynamicPlanning.longestincresingsubsquence;

import java.util.Arrays;

public class FindLongestChain {
    public int findLongestChain(int[][] pairs){
        if (pairs == null || pairs.length == 0)
            return 0;

        Arrays.sort(pairs,(a,b) -> (a[0] - b[0]));

        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        // dp[i]，以pairs[i]结尾能够长的最长链
        for (int i = 1;i < n;i++){
            for (int j = 0;j < i;j++){
                if (pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }

        // 统计最长的子序列长度
        int ret = 0;
        for (int count : dp){
            ret = Math.max(ret,count);
        }
        return ret;
    }
}
