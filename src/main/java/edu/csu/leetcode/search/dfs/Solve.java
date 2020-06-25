package edu.csu.leetcode.search.dfs;

public class Solve {
    //先把外侧填充了，在填充里侧
    private int m,n;
    private int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

    public void solve(char[][] board) {
        if(board == null || board.length == 0)
            return;

        m = board.length;
        n = board[0].length;

        //把左右边界上的‘O’进行填充
        for(int i = 0;i < m;i++){
            dfs(board,i,0);
            dfs(board,i,n - 1);
        }
        //把上下边界的‘O’进行填充
        for(int i = 0;i < n;i++){
            dfs(board,0,i);
            dfs(board,m - 1,i);
        }

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                //如果是与边界'O'相连的岛屿，那么将其重新修改成'O'
                if(board[i][j] == 'T')
                    board[i][j] = 'O';
                    //如果是内部的岛屿，那么将其修改成为'X'
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board,int r,int c){
        if(r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O')
            return;

        //将与边界上上的O相连的岛屿都修改成T
        board[r][c] = 'T';
        for(int[] d : direction)
            dfs(board,r + d[0],c + d[1]);
    }
}
