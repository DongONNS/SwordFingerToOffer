package edu.csu.leetcode.array;

/**
 * @author dongcheng_2018@163.com
 * @Date 2022/5/7 23:24
 */
public class CanJump {
    public boolean canJump(final int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
