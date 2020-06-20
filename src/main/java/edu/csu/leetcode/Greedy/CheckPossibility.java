package edu.csu.leetcode.Greedy;

public class CheckPossibility {
    public static boolean checkPossibility(int[] nums) {
        if(nums.length < 2) return true;
        int count = 0;
        for(int i = 1;i < nums.length && count < 2;i++){
            if(nums[i] >= nums[i - 1]) continue;
            count++;
            if(i - 2 >= 0 && nums[i - 2] > nums[i])
                nums[i] = nums[i - 1];
            else
                nums[i - 1] = nums[i];
        }
        return count < 2;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,3,2,4};
        boolean res = checkPossibility(nums);
        System.out.println(res);
    }
}
