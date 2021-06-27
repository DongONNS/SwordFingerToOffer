package edu.csu.leetcode.hot100.string;

public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        int res = solution.longestValidParentheses("())");
        System.out.println(res);
    }

    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int maxLen = 0;

        for(int i = 1;i < s.length();i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if ((i - dp[i - 1] - 1 >= 0) && (s.charAt(i - dp[i - 1] - 1) == '(')){
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}
