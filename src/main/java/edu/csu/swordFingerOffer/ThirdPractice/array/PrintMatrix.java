package edu.csu.swordFingerOffer.ThirdPractice.array;

import java.util.ArrayList;

public class PrintMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2},{3,4}};
        PrintMatrix printMatrix = new PrintMatrix();
        ArrayList<Integer> res = printMatrix.printMatrix(arr);
        System.out.println(res);
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;

        int rows = matrix.length,cols = matrix[0].length;
        int left = 0,right = cols - 1,up = 0,down = rows - 1;

        while(left <= right && up <= down){
            // 从左到右
            for(int i = left;i <= right;i++){
                res.add(matrix[up][i]);
            }
            // 从上到下
            for(int i = up + 1;i <= down;i++){
                res.add(matrix[i][right]);
            }
            // 从右到左
            if(down > up){
                for(int i = right - 1;i >= left;i--){
                    res.add(matrix[down][i]);
                }
            }

            // 从下到上
            if(right > left){
                for(int i = down - 1; i > up;i--){
                    res.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }
}
