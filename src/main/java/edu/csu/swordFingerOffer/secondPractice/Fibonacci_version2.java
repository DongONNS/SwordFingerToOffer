package edu.csu.swordFingerOffer.secondPractice;

public class Fibonacci_version2 {
    public int Fibonacci(int n) {
        if(n <= 1){
            return n;
        }
        // pre2 表示与当前数字相差2位，pre1表示与当前数字相差1位
        int pre2 = 0,pre1 = 1;
        int fib = 1;

        for(int i = 2;i <= n;i++){
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }
}
