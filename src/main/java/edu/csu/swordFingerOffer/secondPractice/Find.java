package edu.csu.swordFingerOffer.secondPractice;

public class Find {
    public boolean find(int target,int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int r = 0,c = cols - 1;
        while (r < rows && c >= 0){
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                r++;
            else
                c--;
        }
        return false;
    }
}
