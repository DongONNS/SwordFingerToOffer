package edu.csu.leetcode.Top300;

public class FindPeakElement2 {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums,0,nums.length-1);
    }
    public int findPeakElement(int[] nums,int left,int right){
        while(left < right){
            int mid = (left + right)>>1;
            //如果mid处元素处于上升子序列，那么peak在右侧[mid+1,right]之间
            if(nums[mid] < nums[mid+1]) left = mid+1;
            else right = mid;
        }
        return left;
    }
}
