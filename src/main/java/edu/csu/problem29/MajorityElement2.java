package edu.csu.problem29;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MajorityElement2 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length <= 0)
            return -1;
        int mid = nums.length>>1;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i < nums.length;i++){
            if (map.containsKey(i)){
                int count = map.get(i);
                map.put(i,count+1);
            }else{
                map.put(i,1);
            }
        }
        Set<Integer> keys = map.keySet();
        Iterator<Integer> iterator = keys.iterator();
        while(iterator.hasNext()){
            int key = iterator.next();
            int count = map.get(key);
            if (count > mid) return key;
        }
        return -1;
    }
}
