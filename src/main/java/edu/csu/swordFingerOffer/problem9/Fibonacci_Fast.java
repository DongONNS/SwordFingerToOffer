package edu.csu.swordFingerOffer.problem9;
//这个做法比使用递归的方法要快很多
public class Fibonacci_Fast {
    public static void main(String[] args) {
        System.out.println(fibonacci(45));
    }
    public static long fibonacci(int n){
        int[] result = {0,1};
        if (n < 2) return result[n];
        long fibonacci_One = 0;
        long fibonacci_Two = 1;
        long fibN = 0;
        for (int i = 2;i <= n;i++){
            fibN = fibonacci_One+fibonacci_Two;
            fibonacci_One = fibonacci_Two;
            fibonacci_Two = fibN;
        }
        return fibN;
    }

//    public static long fibonacci(int n){
//        int a = 0,b = 1,sum;
//        for (int i = 0;i < n;i++){
//            sum = a + b;
//            a = b;
//            b = sum;
//        }
//        return a;
//    }
}
