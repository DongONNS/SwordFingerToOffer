package edu.csu.leetcode.bitOperation;

public class MaxProduct {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] val = new int[n];

        //将每个字符串用int正数表示
        for(int i = 0;i < n;i++){
            for(char c : words[i].toCharArray()){
                val[i] |= (1 << (c - 'a'));
            }
        }

        //遍历所有的字符串，如果没有相同的字符则计算乘积 得出最大结果
        int res = 0;
        for(int i = 0;i < n;i++){
            for(int j = i + 1;j < n;j++){
                if((val[i] & val[j]) == 0)
                    res = Math.max(res,words[i].length() * words[j].length());
            }
        }
        return res;
    }
}
