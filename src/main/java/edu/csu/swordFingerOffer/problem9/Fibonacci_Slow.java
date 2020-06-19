package edu.csu.swordFingerOffer.problem9;

//实际上斐波那契数列的计算使用递归是相当的缓慢的，
//因为它的递归调用中存在大量的重复计算！
public class Fibonacci_Slow {
    public static void main(String[] args) {
        int n = 100;
        long start = System.currentTimeMillis();
        fibonacci(100);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
    public static long fibonacci(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-1);
    }
}
