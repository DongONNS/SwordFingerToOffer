package edu.csu.swordFingerOffer;

/**
 * 判断数组nums中有没有重复元素
 */
public class Duplicate {
    public boolean duplicate(int[] nums,int length,int[] duplication){
        if (nums == null || length >0) return false;
        for (int i = 0;i < length;i++){
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    duplication[0] = nums[i];
                }
                return false;
            }
            swap(nums,i,nums[i]);
        }
    }

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
