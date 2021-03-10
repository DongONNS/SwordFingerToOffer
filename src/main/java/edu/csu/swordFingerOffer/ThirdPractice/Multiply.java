package edu.csu.swordFingerOffer.ThirdPractice;

import java.util.Arrays;

public class Multiply {
    public static int[] multiply(int[] A){
        int n = A.length;
        int[] B = new int[n];

        for (int i = 0,product = 1;i < n;product *= A[i],i++){
            B[i] = product;
        }

        for (int i = n - 1,product = 1; i >= 0;product *= A[i],i--){
            B[i] *= product;
        }

        return B;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        int[] multiply = multiply(array);
        System.out.println(Arrays.toString(multiply));
    }
}
