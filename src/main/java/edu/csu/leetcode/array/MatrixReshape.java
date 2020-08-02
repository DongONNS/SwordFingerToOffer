package edu.csu.leetcode.array;

public class MatrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        // 判断数量是否一致，若不相等直接返回
        int m = nums.length,n = nums[0].length;
        if(m*n != r*c) return nums;

        int[][] reshapeArray = new int[r][c];

        int index = 0;
        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                reshapeArray[i][j] = nums[index / n][index % n];
                index++;
            }
        }

        return reshapeArray;
    }
}
