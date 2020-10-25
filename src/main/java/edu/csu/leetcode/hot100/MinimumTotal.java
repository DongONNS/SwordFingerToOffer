package edu.csu.leetcode.hot100;

import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle,0,0);
    }

    private int dfs(List<List<Integer>> triangle,int i,int j){
        if(i == triangle.size()){
            return 0;
        }
        return Math.min(dfs(triangle,i + 1,j),dfs(triangle,i + 1,j + 1)) + triangle.get(i).get(j);
    }
}
