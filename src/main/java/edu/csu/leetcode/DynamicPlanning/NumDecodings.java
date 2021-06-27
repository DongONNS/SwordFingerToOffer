package edu.csu.leetcode.DynamicPlanning;

public class NumDecodings {
//    public static int numDecodings(String s) {
//        return getAns(s,0);
//    }
//    public static int getAns(String s,int start){
//        //划分到了最后 返回1
//        if (start == s.length()) return 1;
//        //如果开头是0 0不对应任何的字母 直接返回0
//        if (s.charAt(start) == '0') return 0;
//        //得到第一种的划分的解码方式
//        int ans1 = getAns(s,start+1);
//        int ans2 = 0;
//        if (start  < s.length() - 1){
//            int ten =  (s.charAt(start) - '0') * 10;
//            int one = s.charAt(start + 1) - '0';
//            if (ten + one <= 26)
//                ans2 = getAns(s,start + 2);
//        }
//        return ans1 + ans2;
//    }

    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2;i < s.length();i++){
            int one = Integer.valueOf(s.substring(i - 1,i));
            if(one != 0){
                dp[i] += dp[i - 1];
            }

            if(s.charAt(i - 2) == '0') continue;

            int two = Integer.valueOf(s.substring(i - 2,i));
            if(two <= 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumDecodings solution = new NumDecodings();
        String s = "12";
        int res = solution.numDecodings(s);
        System.out.println(res);
    }
}
