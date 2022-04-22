package edu.csu.leetcode.array;

public class MaxRotateFunction {

    public static void main(final String[] args) {
        final int[] src = new int[]{4, 3, 2, 6};
        MaxRotateFunction maxRotateFunction = new MaxRotateFunction();
        int res = maxRotateFunction.maxRotateFunction(src);
        System.out.println(res);
    }

    /**
     * 计算旋转函数.
     *
     * @param nums 原始数组
     * @return 旋转函数计算结果
     */
    private int maxRotateFunction(final int[] nums) {
        int n = nums.length;
        int[] sum = new int[2 * n + 1];

        for (int i = 1; i <= 2 * n; i++) {
            sum[i] = sum[i - 1] + nums[(i - 1) % n];
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += nums[i - 1] * (i - 1);
        }

        for (int i = n + 1, cur = ans; i < 2 * n; i++) {
            cur += nums[(i - 1) % n] * (n - 1);
            cur -= sum[i - 1] - sum[i - n];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
