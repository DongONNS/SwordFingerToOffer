package edu.csu.leetcode.DynamicPlanning;

public class NumberOfArithmeticSlices {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int res = numberOfArithmeticSlices(A);
        System.out.println(res);
    }

    public static int numberOfArithmeticSlices(int[] A) {
        if (A.length == 0 || A == null) return 0;
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 2;i < n;i++){
            if (A[i] - A[i-1] == A[i-1] - A[i-2])
                dp[i] = dp[i-1] + 1;
        }
        int total = 0;
        for (int cnt : dp){
            total += cnt;
        }
        return total;
    }
}
