package edu.csu.swordFingerOffer.secondPractice;

import java.util.Arrays;

public class JumpFloorII {
    public int jumpFloorII(int target){
        int[] cnt = new int[target];
        Arrays.fill(cnt,1);
        for (int i = 1;i < target;i++){
            for (int j = 0;j < i;j++){
                cnt[i] += cnt[j];
            }
        }
        return cnt[target - 1];
    }

    /**
     * 采用数学解法得出结果
     * @param target
     * @return
     */
    private int jumpFloorIII(int target){
        // 该值是一个等比数列
        // f(n) = f(n-1) + f(n-2) + ... + f(1);
        // f(n-1) = f(n-2) + f(n-3) + f(1);
        // 上下两式相减: f(n) - f(n-1) = f(n-1);
        return (int)Math.pow(2,target - 1);
    }
}


