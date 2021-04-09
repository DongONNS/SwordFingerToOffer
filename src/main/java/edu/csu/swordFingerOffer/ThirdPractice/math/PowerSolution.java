package edu.csu.swordFingerOffer.ThirdPractice.math;

public class PowerSolution {
    public static double Power(double base, int exponent) {
        // 特例判断
        if(base == 0) return 0;
        if(exponent == 0) return 1;
        if(exponent == 1) return base;

        boolean flag = (exponent < 0) ? false : true;
        if(!flag) exponent = -exponent;

        double res = 0;
        res = Power(base,exponent>>1);
        res *= res;
        if((exponent & 1) != 0){
            res *= base;
        }
        return flag ? res : 1/res;
    }

    public static void main(String[] args) {
        double res = Power(2, -3);
        System.out.println(res);
    }
}
