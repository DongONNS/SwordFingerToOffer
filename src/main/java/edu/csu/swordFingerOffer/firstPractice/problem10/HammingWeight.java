package edu.csu.swordFingerOffer.firstPractice.problem10;

public class HammingWeight {
    public static int hammingWeight(int n){
        int res = 0;
        while(n != 0){
            res += (n&1);
            n >>>= 1;
        }
        return res;
    }

//    利用n&(n-1)来进行计算
//    public int hammingWeight(int n) {
//        int res = 0;
//        while(n != 0){
//            res++;
//            n &= (n-1);
//        }
//        return res;
//    }

}
