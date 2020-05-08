package edu.csu.problem38;

import java.util.Arrays;
import java.util.HashMap;

public class SingleNumbers {
    public static void main(String[] args) {
        int[] nums = {1,2,10,4,1,4,3,3};
        int[] result = singleNumbers(nums);
        System.out.println(Arrays.toString(result));
    }
    public static int[] singleNumbers(int[] nums) {
        if(nums.length == 0 || nums == null) return new int[0];
        HashMap<Integer,Boolean> map = new HashMap();
        for(int i = 0;i < nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],true);
            }else{
                map.put(nums[i],false);
            }
        }
        int[] result = new int[2];
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            if(map.get(nums[i]) == true)
                result[count++] = nums[i];
        }
        return result;
    }
}
