package edu.csu.leetcode.hot100;

public class Trap_solution2 {
    public int trap(int[] height) {
        int sum = 0;
        for(int i = 1;i < height.length - 1;i++){
            // 找出第i列左侧的最大高度
            int max_left = 0;
            for(int j = i - 1;j >= 0;j--){
                if(height[j] > max_left)
                    max_left = height[j];
            }

            // 找出右边最大的高度
            int max_right = 0;
            for(int j = i + 1;j < height.length;j++){
                if(height[j] > max_right)
                    max_right = height[j];
            }

            // 找出两端较小的
            int min = Math.min(max_left,max_right);

            // 只有较小的一端大于当前列的高度才会有水，其他情况下不会有水
            if(min > height[i])
                sum = sum + (min - height[i]);
        }
        return sum;
    }
}
