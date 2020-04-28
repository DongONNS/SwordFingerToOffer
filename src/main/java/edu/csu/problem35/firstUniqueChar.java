package edu.csu.problem35;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;

public class firstUniqueChar {
    public static void main(String[] args) {
        String s = "abbaccddeeeff";
        char c = firstUniqChar(s);
        System.out.println(c);
    }
    public static char firstUniqChar(String s) {
        char[] array = s.toCharArray();
        Map<Character,Integer> map = new HashMap();
        for(int i = 0;i < array.length;i++){
            char c = array[i];
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            char ch = (char)iterator.next();
            int count = map.get(ch);
            if(count == 1) return ch;
        }
        return ' ';
    }
}
