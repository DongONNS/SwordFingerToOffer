package edu.csu.swordFingerOffer.firstPractice.problem44;

import java.util.HashSet;
import java.util.Set;

public class isStraight {

    public static void main(String[] args) {
        int[] nums = {8,7,11,0,9};
        boolean res = isStraight(nums);
        System.out.println(res);
    }

    public static boolean isStraight(int[] nums) {
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE,zeroCount = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length;i++){
            if (nums[i]!= 0 && !set.add(nums[i])) return false;
            if(nums[i] == 0) zeroCount++;
            if(nums[i] != 0) min = Math.min(min,nums[i]);
            if(nums[i] != 0) max = Math.max(max,nums[i]);
        }

        //这个是在不包含重复元素的情况下
        if(zeroCount > 0 && (max-min) < 5) return true;
        if(zeroCount==0 && (max-min) == 4) return true;
        else return false;
    }
}
