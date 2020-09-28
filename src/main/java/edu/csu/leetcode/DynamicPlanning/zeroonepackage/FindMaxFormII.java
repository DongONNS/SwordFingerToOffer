package edu.csu.leetcode.DynamicPlanning.zeroonepackage;

/*
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: There are totally 4 strings can be formed by the using of 5 0s and 3 1s,
which are "10","0001","1","0"
 */

/*
这是一个多维费用的 0-1 背包问题，有两个背包大小，0 的数量和 1 的数量。
 */

public class FindMaxFormII {
    public int findMaxForm(String[] strs,int m,int n){

        //dp[i][j] : 表示消耗i个0,j个1可以组成的字符数量
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;

        // 外层循环是物品，内层循环是背包的体积
        for(String str : strs){
            // 计算0 和 1的数量
            int[] cnt = countZeroAndOne(str);

            int zeros = cnt[0];
            int ones  = cnt[1];

            for(int i = m;i >= zeros;i--){
                for (int j = n;j >= ones;j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    //计算0 1的数量
    private int[] countZeroAndOne(String string){
        int[] cnt = new int[2];
        for(char c : string.toCharArray())
            cnt[c - '0']++;
        return cnt;
    }

}
