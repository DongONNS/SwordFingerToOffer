package edu.csu.leetcode.DoubelPointer;

public class JudgeSquareSum {
    public boolean judgeSquareSum(int target){
        if (target < 0) return false;
        int left = 0,right = (int)Math.sqrt(target);
        while(left <= right){
            int sum = left*left + right*right;
            if (sum == target) return true;
            else if (sum < target) left++;
            else right--;
        }
        return false;
    }
}
