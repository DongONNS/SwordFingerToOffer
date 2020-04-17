package edu.csu.problem29;

import java.util.Arrays;

/*
    找出数组中出现次数超过数组长度一半的数;
    摩尔投票法
 */
public class MajorityElement3 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int vote = 0,x = 0;
        for(int num : nums){
            if (vote == 0) x = num;
            vote += num==x?1:-1;
        }

        int count = 0;
        for(int num : nums){
            if (num == x)
                count++;
        }
        if (count <= nums.length>>1)
            throw new RuntimeException("invalid arguments");
        return x;
    }
}
