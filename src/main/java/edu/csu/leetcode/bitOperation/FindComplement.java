package edu.csu.leetcode.bitOperation;

public class FindComplement {
    public int findComplement(int num) {
        //如果num为 0 那么直接返回 1；
        if(num == 0) return 1;

        //计算补码
        //1.先找到第一位的1;
        int mask = 1 << 30;
        while ((num & mask) == 0)
            mask = mask >> 1;
        //2.将从mask的第一位开始设置后面所有位为 1;
        mask = (mask << 1) - 1;

        return mask ^ num;
    }
}
