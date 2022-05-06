package edu.csu.leetcode.string;

import java.util.*;

/**
 * @author dongcheng_2018@163.com
 * @Date 2022/5/6 23:56
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(final String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> subList = new ArrayList();
                subList.add(str);
                map.put(key, subList);
            }
        }
        for (String key: map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}
