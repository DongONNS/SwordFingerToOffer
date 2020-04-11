package edu.csu.problem14;
//采用快慢双指针法完成奇偶数的交换......
public class Exchange3 {
    public int[] exchange(int[] nums) {
        int slow = 0,fast = 0;
        while(fast < nums.length){
            if((nums[fast]&1)==1){
                swap(nums,slow,fast);
                slow++;
            }
            fast++;
        }
        return nums;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j]  = temp;
    }
}