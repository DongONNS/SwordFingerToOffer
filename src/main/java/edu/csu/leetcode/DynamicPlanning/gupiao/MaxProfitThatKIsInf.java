package edu.csu.leetcode.DynamicPlanning.gupiao;

public class MaxProfitThatKIsInf {
    public int maxProfit(int[] prices){
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;

        for(int i = 0;i < prices.length;i++){
            int temp = dp_i_0;

            dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1,temp - prices[i]);
        }
        return dp_i_0;
    }
}
