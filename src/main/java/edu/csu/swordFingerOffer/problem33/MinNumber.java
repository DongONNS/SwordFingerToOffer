package edu.csu.swordFingerOffer.problem33;

import java.util.ArrayList;
import java.util.List;

public class MinNumber {
    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
        MinNumber minNumber = new MinNumber();
        String result = minNumber.minNumber(arr);
        System.out.println(result);
    }
    public String minNumber(int[] nums){
        List<String> stringList = new ArrayList();
        //将数字转换成字符
        for (int num : nums){
            stringList.add(String.valueOf(num));
        }
        stringList.sort((s1,s2) ->(s1+s2).compareTo(s2+s1));
        StringBuilder sb = new StringBuilder();
        for (String str : stringList){
            sb.append(str);
        }
        String string = new String();
        return sb.toString();
    }
}
