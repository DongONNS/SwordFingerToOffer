package edu.csu.leetcode.DynamicPlanning.zeroonepackage;

public class CoinChange {
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins,int amount){
        if (coins.length == 0) return -1;
        findWay(coins,amount,0);
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }
    public void findWay(int[] coins,int amount,int count){
        if (amount < 0) return;
        if (amount == 0) res = Math.min(res,count);
        for (int i = 0;i < coins.length;i++){
            findWay(coins,amount-coins[i],count+1);
        }
    }
}
