package edu.csu.leetcode.array;

/**
 * @author dongcheng_2018@163.com
 * @Date 2022/5/24 0:42
 */
public class NumIslands {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int m, n;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for (int[] direction : directions) {
            dfs(grid, r + direction[0], c + direction[1]);
        }
    }
}
