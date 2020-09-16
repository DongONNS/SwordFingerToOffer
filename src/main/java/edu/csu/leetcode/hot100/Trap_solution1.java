package edu.csu.leetcode.hot100;

public class Trap_solution1 {
    public int trap(int[] height) {
        int sum = 0;
        int max = getMax(height);

        // 这个i表示的是强面的高度
        for(int i = 1;i <= max;i++){
            // 用于标记是否已经开始更新
            boolean isStart = false;

            int temp_sum = 0;
            for(int j = 0;j < height.length;j++){
                // 如果已经开始更新了并且小于墙面高度，那必然是能够接到雨水的，但不一定能存得住
                if(isStart && height[j] < i){
                    temp_sum++;
                }

                // 如果有一面墙高度大于等于我们在求高度的雨水量，那么可以将其顺利存储下来
                if(height[j] >= i){
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    // 获取强面的最大高度
    public int getMax(int[] height){
        int max = 0;
        for(int i = 0;i < height.length;i++){
            if(height[i] > max)
                max = height[i];
        }
        return max;
    }
}
