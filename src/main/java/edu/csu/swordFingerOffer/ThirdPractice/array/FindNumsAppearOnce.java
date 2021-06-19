package edu.csu.swordFingerOffer.ThirdPractice.array;

import java.util.Arrays;

public class FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,1,6};
        int[] res = FindNumsAppearOnce(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] FindNumsAppearOnce (int[] array) {
        if(array == null || array.length == 0) return null;
        int[] res = new int[2];

        // 计算所有数字的异或结果
        int diff = 0;
        for(int num : array){
            diff ^= num;
        }
        diff &= -diff;

        for(int num : array){
            if((diff & num) == 0){
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        if(res[0] > res[1]){
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
        return res;
    }
}
