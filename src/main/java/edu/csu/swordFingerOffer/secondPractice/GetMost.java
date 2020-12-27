package edu.csu.swordFingerOffer.secondPractice;

public class GetMost {
    public int getMost(int[][] values) {
        // 判空
        if (values == null || values.length == 0 || values[0].length == 0)
            return 0;

        int n = values[0].length;
        int[] dp = new int[n];

        // 开始抄表
        for (int[] value : values) {
            dp[0] += value[0];
            for (int i = 1; i < n; i++)
                // dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]) + values[i][j]
                // 当前位置的最大值为左边值或上方值中的较大值加上当前位置元素的值
                dp[i] = Math.max(dp[i], dp[i - 1]) + value[i];
        }
        return dp[n - 1];
    }
}
