package edu.csu.leetcode.search.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {

    private int m,n;
    private int[][] matrix;
    private int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();

        if(matrix == null || matrix.length == 0) return res;

        m = matrix.length;
        n = matrix[0].length;

        this.matrix = matrix;

        //用于能否达到太平洋和大西洋
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        //判断从左右两侧能否进入大西洋和太平洋
        for(int i = 0;i < m;i++){
            //判断从左侧能否进入太平洋
            dfs(i,0,canReachP);

            //判断从右侧能否进入大西洋
            dfs(i,n - 1,canReachA);
        }

        //判断能否从上下两侧进入到大西洋和太平洋
        for(int i = 0;i < n;i++){
            //判断从上侧能否进入太平洋
            dfs(0,i,canReachP);

            //判断从下侧能否进入
            dfs(m - 1,i,canReachA);
        }

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                //如果既能进入太平洋又能进入大西洋，那么就直接将其假如结果集中
                if(canReachA[i][j] && canReachP[i][j])
                    res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }

    private void dfs(int r,int c,boolean[][] canReach){
        //如果从(r,c) 可以进入两洋，那么就直接返回
        if(canReach[r][c]) return;

        canReach[r][c] = true;
        //进行深搜
        for(int[] d : direction){
            int nextR = r + d[0];
            int nextC = c + d[1];

            // 如果下一个位置的海拔 低于 从海边“流上来”的海拔 那就直接返回
            if(nextC < 0 || nextC >= n || nextR < 0 || nextR >= m || matrix[r][c] > matrix[nextR][nextC])
                continue;

            dfs(nextR,nextC,canReach);
        }
    }
}
