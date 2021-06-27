package edu.csu.leetcode.hot100.array;

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
        SearchRange solution = new SearchRange();
        int[] input = new int[]{5,7,7,8,8,10};
        int target = 6;
        int[] res = solution.searchRange(input, target);
        System.out.println(Arrays.toString(res));
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        int left = binarySearch(nums,target);
        int right = binarySearch(nums,target + 1) - 1;

        if(left == nums.length || nums[left] != target){
            return new int[]{-1,-1};
        }
        return new int[]{left,right};
    }

    private int binarySearch(int[] nums,int target){
        int left = 0,right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
