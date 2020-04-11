package edu.csu.problem;

public class MyPow {
    public static void main(String[] args) {
        double result = myPow(8.84372, -5);
        System.out.println(result);
    }
    public static double myPow(double x,int n){
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0){
            b = -b;
            x = 1/x;
        }
        while(b > 0){
            if ((b&1)==1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
    //上述的计算可以改为用递归计算
//    public static double myPow(double x,int n){
//        if(x == 0 || x == 1) return x;
//        long b = n;
//        if(b < 0){
//            b = -b;
//            x = 1/x;
//        }
//        double res = power(x,b);
//        return res;
//    }
//    public static double power(double x,long b){
//        if(b == 0) return 1;
//        if(b == 1) return x;
//        double res = power(x,b>>1);
//        res *= res;
//        if((b&1)==1) res *= x;
//        return res;
//    }

    //一开始的解法，并不正确
//    public static double myPow(double x,int n){
//        boolean flag = n >= 0; //首先判断进制是否为负树
//        if (n == 0) return 1;
//        if (x == 0|| x ==1) return x;
//        if (x==-1){
//            if (n%2==0) return 1;
//            else return -1;
//        }
//        int absN = n>0?n:-n;  //获得n的正数值
//        double ans = x;
//        while(absN>1){
//            if ( absN%2==1 ){
//                ans *= ans;
//                ans *= x;
//            }else{
//                ans*=ans;
//            }
//            absN/=2;
//        }
//        return flag?ans:1/ans;
//    }
}
