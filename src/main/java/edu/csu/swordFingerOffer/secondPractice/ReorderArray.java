package edu.csu.swordFingerOffer.secondPractice;

public class ReorderArray {
    public void reorderArray(int[] nums){
        int oddCnt = 0;
        for (int num : nums){
            if (isOdd(num)){
                oddCnt++;
            }
        }

        int[] copy = nums.clone();
        int i = 0,j = oddCnt;
        for (int num : copy){
            if (isOdd(num)){
                nums[i++] = num;
            }else{
                nums[j++] = num;
            }
        }
    }

    private boolean isOdd(int num){
        return num % 2 == 1;
    }
}
