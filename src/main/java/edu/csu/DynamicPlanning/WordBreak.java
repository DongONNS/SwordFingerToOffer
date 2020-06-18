package edu.csu.DynamicPlanning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        boolean res = wordBreak(s, wordDict);
        System.out.println(res);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        //将wordDict数组放入到set中
        Set<String> wordDictSet = new HashSet(wordDict);
        //dp[i]的含义为0 - i之间的字符串能否被拆为两个由wordDict中字符串组成的字符串
        boolean[] dp = new boolean[s.length() + 1];
        //“”空字符串是可以组成的
        dp[0] = true;
        //[0,i]之间的字符串逐个验证
        for(int i = 1;i <= s.length();i++){
            //[0,j] 和 [j,i]两个字符串能否由wordDict中字符串重组
            for(int j = 0;j < i;j++){
                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
