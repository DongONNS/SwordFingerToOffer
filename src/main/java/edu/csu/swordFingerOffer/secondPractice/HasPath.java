package edu.csu.swordFingerOffer.secondPractice;

public class HasPath {
    private final int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    private int rows;
    private int cols;

    public boolean hasPath(char[] array,int rows,int cols,char[] str){
        if (rows == 0 || cols == 0) return false;
        this.rows = rows;
        this.cols = cols;

        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);

        for (int i = 0;i < rows;i++){
            for (int j = 0;j < cols;j++){
                if (backtracking(matrix,str,marked,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] matrix,char[] str,boolean[][] marked,int len,int row,int col){
        if (len == str.length) return true;
        if (row < 0 || row >= rows || col < 0 || col >= rows ||matrix[row][col] != str[len] || marked[row][col]){
            return false;
        }

        marked[row][col] = true;

        for (int[] direction : directions){
            if (backtracking(matrix,str,marked,len + 1,row + direction[0],col + direction[1])){
                return true;
            }
        }

        marked[row][col] = false;
        return false;
    }

    /**
     * 将一维的字符数组转换为二维字符数组
     * @param array
     * @return
     */
    private char[][] buildMatrix(char[] array){
        char[][] matrix = new char[rows][cols];
        for (int i = 0,index = 0;i < rows;i++){
            for (int j = 0;j < cols;j++){
                matrix[i][j] = array[index++];
            }
        }
        return matrix;
    }
}
