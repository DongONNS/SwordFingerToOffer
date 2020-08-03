package edu.csu.leetcode.bitOperation;

public class hammingDistance {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int cnt = 0;
        while (z != 0){
            // 消去最后一位的 1;
            z &= (z - 1);
            cnt++;
        }
        return cnt;
    }
}
