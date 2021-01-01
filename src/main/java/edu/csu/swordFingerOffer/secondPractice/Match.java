package edu.csu.swordFingerOffer.secondPractice;

public class Match {
    public boolean match(char[] str, char[] pattern) {

        int m = str.length, n = pattern.length;
        // dp[i][j]表示长度为i的字符串能否由长度为j的pattern组成
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                // 如果str[i - 1] 与 pattern[j - 1]匹配上了，那么由前面的结果决定
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                // 当前符号为*时候
                else if (pattern[j - 1] == '*')
                    //如果能由上一个字符串匹配上
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] |= dp[i][j - 1]; // a* counts as single a
                        dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
                        dp[i][j] |= dp[i][j - 2]; // a* counts as empty
                    } else
                        dp[i][j] = dp[i][j - 2];   // a* only counts as empty

        return dp[m][n];
    }
}
