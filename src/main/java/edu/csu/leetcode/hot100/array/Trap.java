package edu.csu.leetcode.hot100.array;

public class Trap {

    public static void main(String[] args) {
        Trap solution = new Trap();
        int[] input = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int res = solution.trap(input);
        System.out.println(res);
    }
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int[] max_right = new int[height.length];
        int max_left = 0;
        int sum = 0;

        // 统计i位置右边的最大高度
        for(int i = height.length - 2;i >= 0;i--){
            max_right[i] = Math.max(max_right[i + 1],height[i + 1]);
        }

        for(int i = 1;i < height.length - 1;i++){
            max_left = Math.max(max_left,height[i - 1]);

            int min = Math.min(max_left,max_right[i]);

            sum += (min > height[i] ? min - height[i] : 0);
        }
        return sum;
    }
}
