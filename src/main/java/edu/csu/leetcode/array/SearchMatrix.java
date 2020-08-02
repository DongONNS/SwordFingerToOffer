package edu.csu.leetcode.array;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //非空判断
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int r = matrix.length,c = matrix[0].length;

        //从右上角开始搜索
        int m = 0,n = c - 1;

        while(m < r && n >= 0){
            if(matrix[m][n] == target) return true;
                //若是大于目标值 则目标值在左侧
            else if(matrix[m][n] > target) n--;

                //若是小于目标值，则目标值在下侧
            else m++;
        }

        return false;
    }
}
