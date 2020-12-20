package edu.csu.swordFingerOffer.firstPractice.problem3;

public class FindNumberIn2DArray2 {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18, 21, 23, 26, 30}};
        boolean ans = findNumberIn2DArray(matrix, 20);
        System.out.println(ans);

    }
    public static boolean findNumberIn2DArray(int[][] matrix,int target){
        if (matrix==null||matrix.length==0||matrix[0].length==0)return false;
        int R = matrix.length,C= matrix[0].length;
        int r = 0,c = C-1;
        while(r < R && c >= 0){
            int num = matrix[r][c];
            if (num == target) return true;
            else if(num > target) c--;
            else r++;
        }
        return false;
    }
}
