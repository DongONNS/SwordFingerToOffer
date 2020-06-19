package edu.csu.swordFingerOffer.problem14;
//采用首位双指针法
public class Exchange2 {
    public int[] exchange(int[] nums) {
        int left = 0,right = nums.length-1;
        while(left<right){
            while(left<right && (nums[left]%2==1)){  //如果这个数是奇数，那么继续将left向后推
                left++;
            }
            while(left<right && (nums[right]%2==0)){  //如果这个书是偶数，那么继续将right向前推
                right--;
            }
            swap(nums,left++,right--);
        }
        return nums;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
