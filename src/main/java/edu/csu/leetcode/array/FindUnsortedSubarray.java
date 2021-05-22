package edu.csu.leetcode.array;

import java.util.Stack;

public class FindUnsortedSubarray {
    public static void main(String[] args) {
        int[] nums = {2,1};
        int length = findUnsortedSubarray(nums);
        System.out.println("最短子序列的长度为: " + length);
    }

    public static int findUnsortedSubarray(int[] nums) {
        int left = nums.length;
        int right = 0;
        Stack<Integer> stack = new Stack();

        for(int i = 0;i < nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                left = Math.min(stack.pop(),left);
            }
            stack.push(i);
        }

        stack.clear();

        for(int i = nums.length - 1;i > 0;i--){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                right = Math.max(stack.pop(),right);
            }
            stack.push(i);
        }

        return right - left > 0 ? right - left + 1 : 0;
    }
}
