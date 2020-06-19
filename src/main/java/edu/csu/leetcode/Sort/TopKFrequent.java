package edu.csu.leetcode.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        //1.统计频数
        Map<Integer,Integer> frequencyForNum = new HashMap<>();
        for(int num : nums){
            frequencyForNum.put(num,frequencyForNum.getOrDefault(num,0) + 1);
        }

        //2.桶排序,桶的下标就是频数
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for(int key : frequencyForNum.keySet()){
            int frequency = frequencyForNum.get(key);
            if(buckets[frequency] == null)
                buckets[frequency] = new ArrayList<>();
            buckets[frequency].add(key);
        }

        //3.统计前k个数字
        //注意考虑同频的数字
        List<Integer> top_k = new ArrayList<>();
        for(int i = buckets.length - 1;i >= 0 && top_k.size() < k;i--){
            if(buckets[i] == null) continue;
            if(buckets[i].size() <= k - top_k.size())
                top_k.addAll(buckets[i]);
            else
                top_k.addAll(buckets[i].subList(0,k - top_k.size()));


        }
        int[] res = new int[top_k.size()];

        for (int i = 0;i < top_k.size();i++)
            res[i] = top_k.get(i);
        return res;
    }


    //    public List<Integer> topKFrequent(int[] nums, int k){
//        //统计数组中元素的频数
//        Map<Integer,Integer> frequencyForNum = new HashMap<>();
//        for (int num : nums){
//            frequencyForNum.put(num,frequencyForNum.getOrDefault(num,0) + 1);
//        }
//
//        //数组的下标表示的是数字出现的频数，遍历得出各频数的数字
//        List<Integer>[]  buckets = new ArrayList[nums.length + 1];
//        for (int key : frequencyForNum.keySet()){
//            int frequency = frequencyForNum.get(key);
//            if (buckets[frequency] == null)
//                buckets[frequency] = new ArrayList<>();
//            buckets[frequency].add(key);
//        }
//
//        //统计出前k个高频的数字
//        List<Integer> top_k = new ArrayList<>();
//        for (int i = buckets.length;i >= 0 && top_k.size() < k;i--){
//            if (buckets[i] == null) continue;
//            //如果出现了同样频数的数字有多个，那么需要判断我们的前K个数里面还需要添加的数字是否在
//            if (buckets[i].size() <= (k - top_k.size()))
//                top_k.addAll(buckets[i]);
//            else
//                top_k.addAll(buckets[i].subList(0,k - top_k.size()));
//
//        }
//    return top_k;
//    }
}
