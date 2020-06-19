package edu.csu.leetcode.DoubelPointer;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length == 0) return null;
        int left = 0,right = numbers.length - 1;
        int[] result = new int[2];
        while(left < right){
            int tempSum = numbers[left] + numbers[right];
            if(tempSum == target){
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }else if(tempSum < target) left++;
            else right--;
        }
        return null;
    }
}
