package edu.csu.leetcode.bitOperation;

public class CountBits {
    public int[] countBits(int num) {
        // 动态规划
        int[] res = new int[num + 1];
        for(int i = 1;i <= num;i++){
            // i & (i - 1)的作用是消去 i 最后的一位 1
            res[i] = res[i & (i - 1)] + 1;
        }

        return res;
    }
}
