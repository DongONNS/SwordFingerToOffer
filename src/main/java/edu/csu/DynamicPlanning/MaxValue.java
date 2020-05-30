package edu.csu.DynamicPlanning;

public class MaxValue {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int max = maxValue(grid);
        System.out.println(max);
    }

    public static int maxValue(int[][] grid) {
        if(grid.length == 0||grid[0].length == 0) return 0;
        int rows = grid.length,cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        //为dp数组的第一列复赋值（就是礼物数组的第一列）
        dp[0][0] = grid[0][0];
        for(int i =1;i < rows;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        //为dp数组的第一行赋值（就是礼物数组的第一行）
        for(int i = 1; i < cols;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i = 1;i< rows;i++){
            for(int j = 1;j < cols;j++){
                dp[i][j] = Math.max(dp[i][j-1]+grid[i][j],dp[i-1][j]+grid[i][j]);
            }
        }
        //我们的最后一个元素就是礼物的最大值；
        return dp[rows-1][cols-1];
    }
}
