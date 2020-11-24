package edu.csu.swordFingerOffer.secondPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class FIndNumberWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int cur = nums[i] + nums[j];
            if (cur == target)
                return new ArrayList<>(Arrays.asList(nums[i], nums[j]));
            if (cur < target)
                i++;
            else
                j--;
        }
        return new ArrayList<>();
    }
}
