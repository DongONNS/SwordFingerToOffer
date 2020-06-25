package edu.csu.leetcode.search.dfs;

public class MaxAreaOfIsland {
    private int row,column;
    private int[][] direction = {{0,1},{1,0},{0,1},{-1,0}};

    public int maxAreaOfIsland(int[][] grid){
        if(grid == null || grid[0].length == 0) return 0;

        row = grid.length;
        column = grid.length;

        int maxArea = 0;

        for (int i = 0;i < row;i++){
            for (int j = 0;j < column;j++)
                maxArea = Math.max(maxArea,dfs(grid,i,j));
        }
        return maxArea;
    }

    /**
     * 进新深度优先遍历
     * @param grid
     * @param r
     * @param c
     * @return
     */
    private int dfs(int[][] grid,int r,int c){
        if (r < 0 || c >= row || c < 0 || c >= column || grid[r][c] == 0)
            return 0;

        //访问过后修改状态
        grid[r][c] = 0;
        int area = 1;

        for (int[] d : direction){
            area += dfs(grid,r + d[0],c + d[1]);
        }
        return area;
    }
}
