package edu.csu.leetcode.binarySearch;

public class SearchRange_version2 {

    public static void main(String[] args) {
        SearchRange_version2 srv = new SearchRange_version2();
        int[] nums = new int[0];
        int target = 0;
        srv.searchRange(nums,target);
    }

     public int[] searchRange(int[] nums, int target) {
         int first = findFirst(nums,target);
         int last = findFirst(nums,target + 1) - 1;

         if(first == nums.length || nums[first] != target){
             return new int[]{-1,-1};
         }else {
             return new int[]{first,Math.max(first,last)};
         }
     }

     private int findFirst(int[] nums,int target){
         int left = 0,right = nums.length;

         while(left < right){
             int mid = left + (right - left) / 2;
             // 如果当前位置的值大于target,那么大于target的第一个值在[left,mid]之间
             if(nums[mid] >= target){
                 right = mid;
             } else {
                 left = mid + 1;
             }
         }
         return left;
     }
}
