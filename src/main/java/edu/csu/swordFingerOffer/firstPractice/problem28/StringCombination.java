package edu.csu.swordFingerOffer.firstPractice.problem28;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class StringCombination {
    private static StringBuilder sb;
    private static Set<String> result;
    private static int index;

    public static ArrayList<String> stringCombination(String string){
        if(string == null || string.trim().length() == 0){
            return new ArrayList<String>();
        }
        char[] chars = string.toCharArray();
        sb = new StringBuilder();
        result = new TreeSet<String>();
        index = 0;
        for(int i = 1;i <= string.length();i++){
            stringCombination(chars,i);
        }
        return new ArrayList<String>(result);
    }
    private static void stringCombination(char[] chars,int length){
        if (length == 0){
            result.add(sb.toString());
            return;
        }
        if (chars.length - index < length) return;
        //选择第一个，从剩下的中选择length - 1个
        sb.append(chars[index]);
        ++index;
        stringCombination(chars,length-1);
        //在递归结束后需要把原来的操作回退
        sb.deleteCharAt(sb.length() - 1);
        //不选择第一个，从剩下的中选择length个
        stringCombination(chars,length);
        --index;
    }

    public static void main(String[] args) {
        System.out.println(stringCombination("abc"));
    }
}
