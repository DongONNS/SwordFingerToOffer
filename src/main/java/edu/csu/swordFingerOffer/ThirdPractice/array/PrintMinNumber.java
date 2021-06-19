package edu.csu.swordFingerOffer.ThirdPractice.array;

import java.util.Arrays;

public class PrintMinNumber {

    public static void main(String[] args) {
        int[] src = new int[]{3,32,321};
        String res = PrintMinNumber(src);
        System.out.println("拼凑的结果为: " + res);
    }
    public static String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) return null;

        String[] strArr = new String[numbers.length];
        for(int i = 0;i < numbers.length;i++){
            strArr[i] = numbers[i] + "";
        }

        Arrays.sort(strArr,(o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        StringBuilder res = new StringBuilder();
        for (int i = 0;i < strArr.length;i++){
            res.append(strArr[i]);
        }
        return res.toString();
    }
}
