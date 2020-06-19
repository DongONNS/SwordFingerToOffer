package edu.csu.leetcode.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort {
    public String frequencySort(String s) {
        //1.统计频数
        Map<Character,Integer> frequencyForNum = new HashMap<>();
        for(char c : s.toCharArray()){
            frequencyForNum.put(c,frequencyForNum.getOrDefault(c,0) + 1);
        }

        //2.桶排序
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for(Character key : frequencyForNum.keySet()){
            int frequency = frequencyForNum.get(key);
            if(buckets[frequency] == null)
                buckets[frequency] = new ArrayList();
            buckets[frequency].add(key);
        }

        //3.按频数从高到低排序
        StringBuilder sb = new StringBuilder();
        for(int i = buckets.length - 1;i >= 0;i--){
            if(buckets[i] == null) continue;
            //对于频数相同的字母，按照出现的先后次序添加
            for(char c : buckets[i])
                //i为c出现的频数
                for(int j = 0;j < i;j++)
                    sb.append(c);
        }
        return sb.toString();
    }
}
