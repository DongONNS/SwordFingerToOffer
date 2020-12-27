package edu.csu.swordFingerOffer.secondPractice;

import java.util.Arrays;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int curLen = 0,maxLen = 0;
        // 这里考虑到可能有空格等字符，所以只用26个字符是不够的
        int[] preIndexs = new int[128];
        Arrays.fill(preIndexs,-1);

        for(int curIndex = 0;curIndex < s.length();curIndex++){
            int ch = s.charAt(curIndex) - 'a';
            int preIndex = preIndexs[ch];
            // 当前字符是第一个出现或以当前字符为末尾节点可以得到更长的长度
            if(preIndex == -1 || curIndex - preIndex > curLen){
                curLen++;
            }else{
                // 以当前字符为结尾时不能再延续先前的长度，需要重新开始新的当前长度计算
                maxLen = Math.max(curLen,maxLen);
                curLen = curIndex - preIndex;
            }
            preIndexs[ch] = curIndex;
        }
        maxLen = Math.max(curLen,maxLen);
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        int res = solution.lengthOfLongestSubstring(" ");
//        int res = solution.lengthOfLongestSubstring("asbajdafdj");
        System.out.println(res);
    }
}
