package edu.csu.leetcode.DynamicPlanning;

public class NumDecodings {
    public static int numDecodings(String s) {
        return getAns(s,0);
    }
    public static int getAns(String s,int start){
        //划分到了最后 返回1
        if (start == s.length()) return 1;
        //如果开头是0 0不对应任何的字母 直接返回0
        if (s.charAt(start) == '0') return 0;
        //得到第一种的划分的解码方式
        int ans1 = getAns(s,start+1);
        int ans2 = 0;
        if (start  < s.length() - 1){
            int ten =  (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26)
                ans2 = getAns(s,start + 2);
        }
        return ans1 + ans2;
    }

    public static void main(String[] args) {
        String s = "0";
        int res = numDecodings(s);
        System.out.println(res);
    }
}
