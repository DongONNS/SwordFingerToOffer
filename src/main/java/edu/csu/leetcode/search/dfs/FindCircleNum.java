package edu.csu.leetcode.search.dfs;

public class FindCircleNum {
    private int n;
    //查找好友圈的数量
    public int findCircleNum(int[][] M) {
        n = M.length;
        int circleNum = 0;

        boolean[] hasVisited = new boolean[n];
        for(int i = 0;i < n;i++){
            if(!hasVisited[i]){
                dfs(M,i,hasVisited);
                circleNum++;
            }
        }
        return circleNum;
    }

    private void dfs(int[][] M,int i,boolean[] hasVisited){
        hasVisited[i] = true;
        for(int j = 0;j < n;j++){
            //如果i 和 K 是好友，那么继续沿着k向下搜索
            if(M[i][j] == 1 && !hasVisited[j])
                dfs(M,j,hasVisited);
        }
    }
}
