package edu.csu.DynamicPlanning;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        if(n == 0) return false;
        //完成数组的创建及初始化
        Pair[][] dp = new Pair[n][n];
        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                dp[i][j] = new Pair(0,0);
            }
        }
        //填入基本状况
        for(int i = 0;i < n;i++){
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }
        for(int l = 2;l <= n;l++){
            for(int i = 0;i <= n - l;i++){
                int j = l + i - 1;
                int left  = piles[i] + dp[i+1][j].sec;
                int right = piles[j] + dp[i][j-1].sec;
                if(left > right){
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i+1][j].fir;
                }else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j-1].fir;
                }
            }
        }
        Pair res = dp[0][n-1];
        return res.fir - res.sec > 0;
    }
}
class Pair{
    int fir,sec;
    Pair(int fir,int sec){
        this.fir = fir;
        this.sec = sec;
    }
}
