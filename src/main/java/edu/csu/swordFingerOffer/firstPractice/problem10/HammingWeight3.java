package edu.csu.swordFingerOffer.firstPractice.problem10;

//给定两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n
//这个解法分为两步，第一步是将m和n求异或，第二部是计算出异或结果中1的位数
//下例中的10（1010），13（1101） 10^13 = 7，再将7这个结果进行求二进制1的运算。
public class HammingWeight3 {
    public static void main(String[] args) {
        int a = 10,b = 13;
        int temp = a^b;
        int ans = hammingWeight(temp);
        System.out.println(ans);
    }
//    利用n&(n-1)来进行计算
    public static int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            res++;
            n &= (n-1);
        }
        return res;
    }
}
