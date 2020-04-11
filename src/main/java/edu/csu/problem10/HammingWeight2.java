package edu.csu.problem10;

public class HammingWeight2 {
//    利用n&(n-1)来进行计算
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            res++;
            n &= (n-1);
        }
        return res;
    }
}
