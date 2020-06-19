package edu.csu.leetcode.DynamicPlanning;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int res = minPathSum(grid);
        System.out.println(res);
    }
    public static int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        int len1 = grid.length,len2 = grid[0].length;
        int[][] dp = new int[len1][len2];
        dp[0][0] = grid[0][0];
        //将数组的第一列进行初始化
        for(int i = 1;i < len1;i++) dp[i][0] = grid[i][0] + dp[i-1][0];
        //将数组的第一行进行初始化
        for(int i = 1;i < len2;i++) dp[0][i] = grid[0][i] + dp[0][i-1];
        //状态转移方程 dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + dp[i][j];
        for(int i = 1;i < len1;i++){
            for(int j = 1;j < len2;j++)
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
        }
        return dp[len1-1][len2-1];
    }
}
