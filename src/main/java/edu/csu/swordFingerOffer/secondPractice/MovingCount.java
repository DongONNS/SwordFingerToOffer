package edu.csu.swordFingerOffer.secondPractice;

public class MovingCount {
    private int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    private int rows;
    private int cols;
    private int[][] digitsSum;
    private int cnt = 0;
    private int threshold;

    /**
     * 计算数位和小于threshold的格子数量
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.cnt = 0;
        this.threshold = threshold;
        initDigitsSum();
        boolean[][] marked = new boolean[rows][cols];
        bfs(marked,0,0);
        return cnt;
    }

    private void bfs(boolean[][] marked,int r,int c){
        if(r < 0 || r >= rows || c < 0 || c >= cols || digitsSum[r][c] > threshold || marked[r][c]){
            return;
        }

        marked[r][c] = true;
        cnt++;
        for(int[] direction : directions){
            bfs(marked,r + direction[0],c + direction[1]);
        }
    }

    // 初始化i j位置的每个数字
    private void initDigitsSum(){
        // 计算单个数字各数位相加之和，用于后面的复用
        int[] digitsSumOne = new int[Math.max(rows,cols)];
        for(int i = 0;i < digitsSumOne.length;i++){
            int temp = i;
            while(temp > 0){
                digitsSumOne[i] += (temp % 10);
                temp /= 10;
            }
        }

        this.digitsSum = new int[rows][cols];
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                this.digitsSum[i][j] = digitsSumOne[i] + digitsSumOne[j];
            }
        }
    }
}

