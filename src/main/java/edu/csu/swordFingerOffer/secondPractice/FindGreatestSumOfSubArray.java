package edu.csu.swordFingerOffer.secondPractice;

//输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        // 判空
        if(array == null || array.length == 0)
            return 0;
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int val : array){
            // 此处判断是否要保留前值
            sum = sum < 0 ? val : sum + val;
            greatestSum = Math.max(greatestSum,sum);
        }
        return greatestSum;
    }
}
