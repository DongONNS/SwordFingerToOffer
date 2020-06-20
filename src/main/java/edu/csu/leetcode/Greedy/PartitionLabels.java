package edu.csu.leetcode.Greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S){
        int[] lastIndexOfChar = new int[26];

        //记录下每个字符最后出现的位置
        //比如我们第一个字符是a，我们需要找到最后一个出现a的位置
        for (int i = 0;i < S.length();i++)
            lastIndexOfChar[charToIndex(S.charAt(i))] = i;

        //用于保留结果
        List<Integer> partitions = new ArrayList<>();
        int firstIndex = 0;
        while(firstIndex < S.length()){

            //每次外循环需要从firstIndex开始
            int lastIndex = firstIndex;

            for(int i = firstIndex;i < S.length() && i <= lastIndex;i++){
                //因为我们再字符c-字符c的序列中可能会出现更靠后的位置，
                // 这需要我们调整第一段的结束位置
                int index = lastIndexOfChar[charToIndex(S.charAt(i))];
                if (index > lastIndex)
                    lastIndex = index;
            }

            //partition用于记录每个子字符串的长度
            partitions.add(lastIndex - firstIndex + 1);

            //下一次循环需要从上一子串的结束位置下一字符开始
            firstIndex = lastIndex + 1;
        }
        return partitions;
    }

    //将字符转换成数组下标
    private int charToIndex(char c){
        return c - 'a';
    }
}
