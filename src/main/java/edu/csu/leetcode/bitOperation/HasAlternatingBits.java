package edu.csu.leetcode.bitOperation;

public class HasAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        // 如果n是没有连续0 1的数，则n ^ n >> 1 将得到的数所有位都是1
        // eg 10 ==> 1010
        //    10 >> 1 ==> 101
        //    1010 ^ 101 ==> 1111
        int num = n ^ (n >> 1);
        return (num & (num + 1)) == 0;
    }
}
