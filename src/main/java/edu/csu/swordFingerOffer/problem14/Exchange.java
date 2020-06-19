package edu.csu.swordFingerOffer.problem14;

import java.util.Arrays;

//给定一个数组，将数组中的全部奇数放在偶数前面
public class Exchange {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int[] old  = new int[len];
        int[] even = new int[len];
        Arrays.fill(old ,0);
        Arrays.fill(even,0);
        int oldIndex = 0,evenIndex = 0;
        for(int i = 0;i < len;i++){
            if(nums[i]%2==1)
                old[oldIndex++]  = nums[i];   // 奇数存入old数组中
            else
                even[evenIndex++] = nums[i];  //偶数存入even数组中
        }
        evenIndex = 0;
        for(;oldIndex < len;oldIndex++){
            old[oldIndex] = even[evenIndex++];
        }
        return old;
    }
}
