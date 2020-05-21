package edu.csu.DynamicPlanning;

import java.util.Arrays;

public class SupperEggDrop {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N+1][K+1];
        for(int i = 0;i <= N;i++){
            Arrays.fill(dp[i],i);
        }
        //楼层数量为0的时候，不用扔鸡蛋;
        for(int j = 0;j <= K;j++){
            dp[0][j] = 0;
        }
        //在一楼时候如果没有鸡蛋 那么不用扔，如果有一个及以上的鸡蛋，那么只需要扔一个鸡蛋就可以测出结果来;
        dp[1][0] = 0;
        for(int j = 1;j <= K;j++){
            dp[1][j] = 1;
        }
        //如果没有鸡蛋，那么不用扔
        //如果有一个鸡蛋，只能通过线性扫面得到结果
        for(int i = 0;i <= N;i++){
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        //从二楼，拥有两个鸡蛋开始
        for(int i = 2;i <= N;i++){
            for(int j = 2;j <= K;j++){
                for(int k = 1;k <= i;k++)
                    dp[i][j] = Math.min(dp[i][j],Math.max(dp[k-1][j-1],dp[i - k][j]) + 1);
            }
        }
        return dp[N][K];
    }
}
