package edu.csu.swordFingerOffer.secondPractice;

public class BinarySearch {
    public int binarySearch(int[] nums, int K) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] == K) {
                return m;
            } else if (nums[m] > K) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
