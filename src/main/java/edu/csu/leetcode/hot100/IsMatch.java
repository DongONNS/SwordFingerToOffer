package edu.csu.leetcode.hot100;

public class IsMatch {
    public static void main(String[] args) {
        IsMatch solution = new IsMatch();
        boolean res = solution.isMatch("", ".*");
        System.out.println(res);
    }

    public boolean isMatch(String text, String pattern) {
        if((text == null || text.length() == 0) && (pattern == null || pattern.length() == 0)) return true;
        if((text == null || text.length() == 0) || (pattern == null || pattern.length() == 0)) return false;

        int m = text.length(),n = pattern.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for(int i = 1;i <= n;i++){
            if(pattern.charAt(i - 1) == '*'){
                dp[0][i] = dp[0][i - 2];
            }
        }

        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                if(pattern.charAt(j - 1) == '*'){
                    if(dp[i][j - 2]) dp[i][j] = true;
                    else if(dp[i - 1][j] && (pattern.charAt(j - 2) == '.')) dp[i][j] = true;
                    else if(dp[i - 1][j] && (pattern.charAt(j - 2) == text.charAt(i - 1))) dp[i][j] = true;
                } else {
                    if(dp[i - 1][j - 1] && (pattern.charAt(j - 1) == '.')) dp[i][j] = true;
                    else if(dp[i - 1][j - 1] && (pattern.charAt(j - 1) == text.charAt(i - 1))) dp[i][j] = true;
                }
            }
        }
        return dp[m][n];
    }
}
