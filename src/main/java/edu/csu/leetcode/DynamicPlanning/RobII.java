package edu.csu.leetcode.DynamicPlanning;

public class RobII {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0],nums[1]);
        return Math.max(myRob(nums,0,len - 1),myRob(nums,1,len));
    }
    public int myRob(int[] nums,int start,int end){
        int pre1 = 0,pre2 = 0;
        for(int i = start;i < end;i++){
            int curr = Math.max(pre1,pre2 + nums[i]);
            pre2 = pre1;
            pre1 = curr;
        }
        return pre1;
    }
}
