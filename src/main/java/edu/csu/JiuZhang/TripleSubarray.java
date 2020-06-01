package edu.csu.JiuZhang;

public class TripleSubarray {
    public int tripletSubarray(int[] nums, int limit) {
        int left = 0, res = 0;
        int mod = 99997867;
        for (int right = 2; right < nums.length; right++){
            while (nums[right] - nums[left] > limit){
                left ++;
            }
            if (right - left >= 2){
                res =(res + (right - left) * (right - left - 1) / 2) % mod;
            }
        }
        return res;
    }
}
