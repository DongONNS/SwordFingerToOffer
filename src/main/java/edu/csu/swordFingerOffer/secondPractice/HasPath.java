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
        if (row < 0 || row >= rows || col < 0 || col >= cols ||matrix[row][col] != str[len] || marked[row][col]){
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
     * 测试hasPath方法
     * @param args
     */
    public static void main(String[] args) {
        HasPath solution = new HasPath();
        char[] array = {'A','B','C','E','S','F','C','S','A','D','E','E'};
        char[] str = {'S','E','E'};
        boolean res = solution.hasPath(array, 3, 4, str);
        System.out.println(res ? "含有该执行路径":"不含该执行路径");
    }
}
