package edu.csu.DynamicPlanning;

import java.util.Arrays;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        String string = "a";
        int res = longestPalindromeSubseq(string);
        System.out.println(res);
    }
    public static int longestPalindromeSubseq(String s) {
        if(s.length()==0) return 0;
        int len = s.length();
        int[][] dp = new int[len][len];
        //泛着遍历得到结果
        for(int i = len - 1;i >= 0;i--){
            //只有一个字符时，回文子序列的长度为1;
            dp[i][i] = 1;
            for(int j = i+1;j < len;j++){
                if(s.charAt(i) == s.charAt(j)) dp[i][j]= dp[i+1][j-1]+2;
                else dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][len-1];
    }
}
