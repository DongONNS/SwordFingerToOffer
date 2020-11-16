package edu.csu.swordFingerOffer.secondPractice;

import java.util.BitSet;

public class FirstNotRepeatingChar2 {
    public int firstNotRepeatingChar(String str){
        BitSet bs1 = new BitSet();
        BitSet bs2 = new BitSet();
        for (char c : str.toCharArray()){
            // 一次都没有存储
            if (!bs1.get(c) && !bs2.get(c)){
                bs1.set(c);
            }
            // 存储了一次
            if (bs1.get(c) && !bs2.get(c)){
                bs2.set(c);
            }
        }

        // 找到 0 1的数据
        for (int i = 0;i < str.length();i++){
            char c = str.charAt(i);
            if (bs1.get(c) && !bs2.get(c)){
                return i;
            }
        }
        return -1;
    }
}
