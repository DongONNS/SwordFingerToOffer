package edu.csu.leetcode.array;

/**
 * @author dongcheng_2018@163.com
 * @date 2022/4/24 23:54
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] src = new int[]{1,8,6,2,5,4,8,3,7};
        MaxArea maxArea = new MaxArea();
        int res = maxArea.maxArea(src);
        System.out.println(res);
    }

    private int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int sum = 0;
        while(left < right) {
            int currLen = right - left;
            int currMax = height[left] < height[right] ? currLen * height[left++] : currLen * height[right--];
            sum = Math.max(sum , currMax);
        }
        return sum;
    }
}
