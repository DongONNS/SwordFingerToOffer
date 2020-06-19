package edu.csu.swordFingerOffer.problem38;

import java.util.Arrays;

public class SingleNumbers {
    public static void main(String[] args) {
        int[] nums = {1,2,10,4,1,4,3,3};
        int[] result = singleNumbers(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] singleNumbers(int[] nums) {
        int sum = 0;
        int[] result = new int[2];
        for(int num : nums){
            sum ^= num;
        }
        int lowbit = sum & (-sum);
        for(int num : nums){
            if((num & lowbit) == 0)
                result[0] ^= num;
            else
                result[1] ^= num;
        }
        return result;
    }



//    public static int[] singleNumbers(int[] nums) {
//        if(nums.length == 0 || nums == null) return new int[0];
//        HashMap<Integer,Boolean> map = new HashMap();
//        for(int i = 0;i < nums.length;i++){
//            if(!map.containsKey(nums[i])){
//                map.put(nums[i],true);
//            }else{
//                map.put(nums[i],false);
//            }
//        }
//        int[] result = new int[2];
//        int count = 0;
//        for(int i = 0;i < nums.length;i++){
//            if(map.get(nums[i]) == true)
//                result[count++] = nums[i];
//        }
//        return result;
//    }
}
