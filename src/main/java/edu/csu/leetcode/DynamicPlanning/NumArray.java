package edu.csu.leetcode.DynamicPlanning;

public class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1;i < nums.length;i++){
            sum[i] = sum[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0) return sum[j];
        else return sum[j] - sum[i-1];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        int res = numArray.sumRange(2, 5);
        System.out.println(res);
    }
}
