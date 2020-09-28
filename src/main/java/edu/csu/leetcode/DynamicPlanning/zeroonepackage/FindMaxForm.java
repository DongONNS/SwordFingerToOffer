package edu.csu.leetcode.DynamicPlanning.zeroonepackage;

/*
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: There are totally 4 strings can be formed
by the using of 5 0s and 3 1s, which are "10","0001","1","0".
 */

/*
    这是一个多维费用的 0-1 背包问题，有两个背包大小，0 的数量和 1 的数量。
 */

public class FindMaxForm {
    public int findMaxForm(String[] strs,int m,int n){
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for(int i = 1;i <= len;i++){
            int[] cnt = countZeroAndOne(strs[i]);
            for(int j = 0;j <= m;j++){
                for(int k = 0;k <= n;k++){
                    //先把上一行抄下来
                    dp[i][j][k] = dp[i - 1][j][k];
                    int zeros = cnt[0];
                    int ones  = cnt[1];
                    if (j >= zeros && k >= ones)
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],dp[i - 1][j - zeros][k - ones]);
                }
            }
        }
        return dp[len][m][n];
    }
    private int[] countZeroAndOne(String string){
        int[] cnt = new int[2];
        for(char c : string.toCharArray()){
            cnt[c - '0']++;
        }
        return cnt;
    }
}
