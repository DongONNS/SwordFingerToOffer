package edu.csu.DynamicPlanning;

public class FindMaxFormII {
    public int findMaxForm(String[] strs,int m,int n){
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(String str : strs){
            int[] cnt = countZeroAndOne(str);

            int zeros = cnt[0];
            int ones  = cnt[1];

            for(int i = m;i >= zeros;i--){
                for (int j = n;j >= ones;j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    //计算0 1的数量
    private int[] countZeroAndOne(String string){
        int[] cnt = new int[2];
        for(char c : string.toCharArray())
            cnt[c - '0']++;
        return cnt;
    }

}
