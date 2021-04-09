package edu.csu.swordFingerOffer.ThirdPractice.math;

public class NumberOf1 {

    public static int numberOf1II(int n){
        int count = 0;
        while(n != 0){
            count++;
            n = n&(n-1);
        }
        return count;
    }

    public static int numberOf1(int n) {
        int count = 0;
        int flag = 1;
        int index = 0;
        while(index++ < 32){
            if((n&flag) != 1){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int res = numberOf1II(10);
        System.out.println("res的结果为：" + res);
    }
}
