package edu.csu.leetcode.array;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] src = {1, 2, 0};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int res = firstMissingPositive.firstMissingPositive(src);
        System.out.println(res);
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
