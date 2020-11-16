package edu.csu.swordFingerOffer.secondPractice;

public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str){
        int[] cnts = new int[128];
        // 存储每个字符出现的次数
        for (int i = 0;i < str.length();i++){
            cnts[str.charAt(i)]++;
        }

        // 找到第一个次数为1的数字
        for (int i = 0;i < str.length();i++){
            if (cnts[str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }
}
