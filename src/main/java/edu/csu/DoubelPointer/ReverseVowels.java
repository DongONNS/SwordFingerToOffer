package edu.csu.DoubelPointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    private final static Set<Character> set = new HashSet(
            Arrays.asList('a','e','i','o','u','A','E','I','O','U')
    );
    public static String reverseVowels(String s) {
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!set.contains(ci)) {
                result[i++] = ci;
            } else if (!set.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
//    public static String reverseVowels(String s) {
//
//        char[] arrayChar = s.toCharArray();
//
//        int left = 0,right = s.length() - 1;
//
//        char[] result = new char[s.length()];
//
//        while(left <= right){
//            char cl = arrayChar[left];
//            char cr = arrayChar[right];
//
//            //如果左右指针都是指向的元音字母，那么将二者进行交换并且修改左右指针
//            if(set.contains(cl) && set.contains(cr)){
//                result[left++]  = cr;
//                result[right--] = cl;
//
//                //如果只有左指针指向了元音字母，那么将右指针对应位置的结果集填充右指针指向的字母，
//                //并修改右指针
//            }else if(set.contains(cl))
//                result[right--] = cr;
//                //如果二者都没有指向元音字母，那么修改结果集为对应的左右指针指向的字母，并调整指针指向
//            else if(set.contains(cr))
//                result[left++]  = cl;
//            else{
//                result[left++]  = cl;
//                result[right--]  = cr;
//            }
//        }
//        return new String(result);
//    }


    public static void main(String[] args) {
        String s = "hello";
        String res = reverseVowels(s);
        System.out.println(res);
    }
}
