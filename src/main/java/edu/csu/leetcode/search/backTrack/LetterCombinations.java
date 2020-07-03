package edu.csu.leetcode.search.backTrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    // 键对应的字符串
    private static final String[] keys = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static List<String> letterCombinations(String digits) {
        //用于存储结果集
        List<String> res = new ArrayList();
        if(digits == null || digits.length() == 0) return res;
        //递归回溯所有可能的结果
        doCombination(new StringBuilder(),res,digits);
        return res;
    }

    /**
     * 回溯所有的状态表示
     */
    private static void doCombination(StringBuilder prefix,List res,String digits){
        //如果每个键都存储了对应字符了，存储结果并返回
        if(prefix.length() == digits.length()){
            res.add(prefix.toString());
            return ;
        }

        //得出当前的字符所对应的键值，根据相应的键得到其字符串值
        int curDigit = digits.charAt(prefix.length()) - '0';
        String letters = keys[curDigit];

        //递归过程，要注意递归后要回到递归处理之前的状态
        for(char c : letters.toCharArray()){
            prefix.append(c);
            doCombination(prefix,res,digits);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        for(String ans : res){
            System.out.println(ans);
        }
    }
}
