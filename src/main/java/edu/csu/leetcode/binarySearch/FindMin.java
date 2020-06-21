package edu.csu.leetcode.binarySearch;

public class FindMin {
    public int findMin(int[] nums) {
        int left = 0,right = nums.length - 1;

        //循环终止条件是left == right
        while(left < right){
            int mid = left + (right - left) / 2;

            //如果mid处的元素 小于等于 right处的元素，那么说明[mid,right]是一个排序数组
            //旋转点应该在[left，mid]之间
            if(nums[mid] <= nums[right])
                right = mid;
                //否则，旋转点在[mid + 1,right]之间
            else
                left = mid + 1;
        }
        return nums[left];
    }
}
