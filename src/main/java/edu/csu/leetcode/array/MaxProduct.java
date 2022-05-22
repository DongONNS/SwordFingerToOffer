package edu.csu.leetcode.array;

/**
 * @author dongcheng_2018@163.com
 * @Date 2022/5/22 23:58
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int min = 1, max = 1;

        for (int num : nums) {
            if (num < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(num * max, num);
            min = Math.min(num * min, num);

            res = Math.max(max, res);
        }
        return res;
    }
}
