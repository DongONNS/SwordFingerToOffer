package edu.csu.leetcode.array;

/**
 * @author dongcheng_2018@163.com
 * @date 2022/5/2 23:41
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        int left = binarySearch(nums, target);
        int right = binarySearch(nums, target + 1) - 1;

        if(left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
