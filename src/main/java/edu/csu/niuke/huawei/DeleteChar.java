package edu.csu.niuke.huawei;

public class DeleteChar {
    public static int getResult(String str){
        StringBuilder sb  = new StringBuilder(str);
        String reverseStr = sb.reverse().toString();
        char[] c1 = str.toCharArray();
        char[] c2 = reverseStr.toCharArray();
        int len = str.length();

        //dp[i][j] 表示c1在[0,i]和c2在[0,2]之间最长的公共子数组的长度
        int[][] dp = new int[len+1][len+1];

        for(int i = 1;i < len;i++){
            for (int j = 1; j < len + 1; j++) {

                // i和i要比对应的char[] 的索引前一位，所以要减1
                if (c1[i - 1] == c2[j - 1]) {
                    // 如果相等，那么长度+1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果不相等，那么删除c1中的i-1时索引位置或者c2中的j-1索引位置
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len][len];
    }
}
