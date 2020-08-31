package edu.csu.niuke.huawei;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TransferBase {
    public static String transferBase(String string){

        Map<Character,Integer> map = new HashMap();
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
        map.put('A',10);
        map.put('B',11);
        map.put('C',12);
        map.put('D',13);
        map.put('E',14);
        map.put('F',15);

        String prefix = string.substring(0,2);

        if(!prefix.equals("ox")){
            throw new IllegalArgumentException("string should start with 'ox'");
        }

        String nums = string.substring(2);

        // 用于记录数位
        int len = nums.length();

        // 计算十进制数字
        int res = 0;

        for(int i = 0;i< len;i++){
            char c = nums.charAt(i);
            Set<Character> characters = map.keySet();
            boolean exists = characters.contains(c);
            if (!exists)
                throw new IllegalArgumentException("string contains illegal character : " + c);

            int num = map.get(c);
            res += num * Math.pow((double)16,(double)(len - i - 1));
        }

        return res + "";
    }

    public static void main(String[] args) {
        String string = "oxW";
        String res = transferBase(string);
        System.out.println(res);

        Map<Integer,Integer> map = new HashMap<>();

        Map<Integer, Integer> integerIntegerMap = Collections.synchronizedMap(map);

    }
}
