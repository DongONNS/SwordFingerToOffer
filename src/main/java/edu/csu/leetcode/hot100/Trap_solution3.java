package edu.csu.leetcode.hot100;

public class Trap_solution3 {
    public int trap(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        // 获取左边的最大墙高度
        for(int i = 1;i < height.length - 1;i++){
            max_left[i] = Math.max(max_left[i - 1],height[i - 1]);
        }

        // 获取右边的最大墙高度
        for(int i = height.length - 2;i >= 0;i--){
            max_right[i] = Math.max(max_right[i + 1],height[i + 1]);
        }

        for(int i = 1;i < height.length - 1;i++){
            int min = Math.min(max_left[i],max_right[i]);
            if(min > height[i])
                sum += (min - height[i]);
        }
        return sum;
    }
}
