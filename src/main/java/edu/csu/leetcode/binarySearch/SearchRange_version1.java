package edu.csu.leetcode.binarySearch;

public class SearchRange_version1 {

    public static void main(String[] args) {
        SearchRange_version1 srv = new SearchRange_version1();
        int[] nums = new int[0];
        int target = 0;
        srv.searchRange(nums,target);
    }


    public int[] searchRange(int[] nums,int target){
        if(nums == null) return null;

        int first = insertIndex(nums,target);
        int last = insertIndex(nums,target + 1) - 1;

        // 如果要插入的位置大于数组最长索引位置或者没有找到目标值
        // 直接返回[-1,-1]
        if(first == nums.length || nums[first] != target)
            return new int[]{-1,-1};

        return new int[]{first,Math.max(first,last)};
    }


    // target在nums中的第一个位置或者是应该插入的位置
    private int insertIndex(int[] nums,int target){
        int left = 0,right = nums.length - 1;
        // 如果target值大于数组最大值，那么直接返回数组长度

        if(target > nums[right]) return nums.length;

        while(left < right){
            int mid = left + (right - left) / 2;

            // 如果nums[mid]的值小于target值，那么查找区间应该是[mid + 1,right]
            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
