package edu.csu.swordFingerOffer.firstPractice.problem32;

public class CountDigitOne {
    public int countDigitOne(int n){
        return f(n);
    }
    private int f(int n){
        if (n <= 0) return 0;
        String string = String.valueOf(n);
        int high = string.charAt(0) - '0';
        int pow = (int)Math.pow(10,string.length()-1);
        int last = n - high*pow;
        if (high == 1)
            return f(pow-1) + last + 1 + f(last);
        else
            return pow + high * f(pow - 1) + f(last);
    }
}
