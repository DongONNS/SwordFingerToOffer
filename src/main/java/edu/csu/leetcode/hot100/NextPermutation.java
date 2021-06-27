package edu.csu.leetcode.hot100;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] input = new int[]{5,1,1};

        NextPermutation solution = new NextPermutation();
        solution.nextPermutation(input);
        System.out.println(Arrays.toString(input));
    }

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2) return;

        int i = nums.length - 2;
        while(i >= 0 && nums[i + 1] <= nums[i]){
            i--;
        }

        if(i >= 0){
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i + 1,nums.length - 1);
    }

    private void reverse(int[] nums,int left,int right){
        while(left < right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
