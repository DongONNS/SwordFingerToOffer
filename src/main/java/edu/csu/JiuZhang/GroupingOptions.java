package edu.csu.JiuZhang;

public class GroupingOptions {
    public static void main(String[] args) {
        long res = groupingOptions(8, 4);
        System.out.println(res);
    }
    public static long groupingOptions(int n, int m) {
        if (m > n) return 0;
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) dp[i][i] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j < i; j++)
                for (int k = 1; k <= j; k++)
                    dp[i][j] += dp[i - j][k];
        return dp[n][m];
    }
}
