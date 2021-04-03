package edu.csu.swordFingerOffer.ThirdPractice.dp;

import java.util.Arrays;

public class JumpFloorII {
//    public int jumpFloorII(int target){
//        return (int)Math.pow(2,target - 1);
//    }

    public static int jumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp,1);
        for(int i = 1;i < target;i++){
            for(int j = 0;j < i;j++){
                dp[i] += dp[j];
            }
        }
        return dp[target - 1];
    }

    public static void main(String[] args) {
        jumpFloorII(3);
    }
}
