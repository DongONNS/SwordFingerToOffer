package edu.csu.leetcode.array;

/**
 * @author dongcheng_2018@163.com
 * @Date 2022/5/26 2:13
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (k < 0 || k > nums.length) {
            return -1;
        }
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int part = partition(nums, left, right);
            if (part == k) {
                break;
            } else if (part > k) {
                right = part - 1;
            } else {
                left = part + 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] arr, int left, int right) {
        int cmp = arr[left];
        int i = left + 1, j = right;

        while (i <= j) {
            while (i <= j && arr[i] <= cmp) {
                i++;
            }
            while (i <= j && arr[j] >= cmp) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
