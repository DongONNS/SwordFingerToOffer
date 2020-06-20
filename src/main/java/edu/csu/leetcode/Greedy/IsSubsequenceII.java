package edu.csu.leetcode.Greedy;

public class IsSubsequenceII {
    public static boolean isSubsequence(String s,String t){
        //对t进行预处理
        t = " " + t;
        int n = t.length();

        //记录每个位置的下一个ch的位置
        int[][] dp = new int[n][26];
        for (char ch = 0;ch < 26;ch++){
            int p = -1;

            //从后往前记录dp
            for (int i = n -1;i >= 0;i--){
                dp[i][ch] = p;
                if (t.charAt(i) == ch + 'a')
                    p = i;
            }
        }

        //进行字符与s的匹配
        int i = 0;
        for (char ch : s.toCharArray()){
            i = dp[i][ch - 'a'];
            if (i == -1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ada";
        String t = "aveaniceday";
        boolean res = isSubsequence(s, t);
        System.out.println(res);
    }
}
