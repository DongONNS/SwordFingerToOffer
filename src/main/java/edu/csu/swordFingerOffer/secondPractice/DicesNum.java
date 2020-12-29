package edu.csu.swordFingerOffer.secondPractice;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DicesNum {
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // 定义初始变量
        int face = 6;
        int pointNum = face * n;

        // dp[i][j] 表示前i个骰子组成数j的组合数
        int[][] dp = new int[n + 1][pointNum + 1];

        for(int i = 1;i <= face;i++){
            dp[1][i] = 1;
        }

        for(int i = 2;i <= n;i++){
            for(int j = i;j <= pointNum;j++){
                for(int k = 1;k <= face && k <= j;k++){
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        double sumCom = Math.pow(6,n);
        List<Map.Entry<Integer,Double>> res = new ArrayList();

        for(int i = 1;i <= pointNum;i++){
            res.add(new AbstractMap.SimpleEntry(i,dp[n][i]/sumCom));
        }
        return res;
    }
}
