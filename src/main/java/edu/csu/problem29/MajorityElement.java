package edu.csu.problem29;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = nums.length>>1;
        int index = partition(nums,start,end);
        while(index != mid){
            if(index > mid){
                end = index - 1;
                index = partition(nums,start,end);
            }else{
                start = index + 1;
                index = partition(nums,start,end);
            }
        }
        int result = nums[mid];
        return result;
    }
    private int partition(int[] nums,int start,int end){
        int std = nums[start];
        int left = start;
        while(start < end){
            while(start < end && nums[start]<= std){
                start ++;
            }
            while(start < end && nums[end] > std){
                end --;
            }
            swap(nums,start,end);
        }
        swap(nums,start,left);
        return start;
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
