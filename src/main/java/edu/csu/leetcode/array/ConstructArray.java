package edu.csu.leetcode.array;

public class ConstructArray {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        res[0] = 1;

        //先构建k - 1个不同的差值
        for(int i = 1,interval = k;i <= k;i++,interval--){
            if(i % 2 == 1)
                res[i] = res[i - 1] + interval;
            else
                res[i] = res[i - 1] - interval;
        }

        //随后的几个值直接按序赋值即可
        for(int i = k + 1;i < n;i++){
            res[i] = i + 1;
        }

        return res;
    }
}
