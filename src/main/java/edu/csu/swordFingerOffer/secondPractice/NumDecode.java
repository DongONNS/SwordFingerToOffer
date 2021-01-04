package edu.csu.swordFingerOffer.secondPractice;

// 类似于青蛙跳台阶
public class NumDecode {

    public int numDecode(String s) {
        if(s == null || s.length() == 0) return 0;

        int len = s.length();
        // dp[i]表示长度为i的字符串能够组成的数字的组合数
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2;i <= len;i++){
            int one = Integer.valueOf(s.substring(i-1,i));
            if(one != 0)
                dp[i] += dp[i - 1];

            if(s.charAt(i - 2) == '0')
                continue;

            int two = Integer.valueOf(s.substring(i-2,i));
            if(two <= 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
