package edu.csu.DataStructure.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapEx {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>(111);
        map.put(1,"hello");

        // 使用通配符 ？ 无法向集合中添加元素
        List<?> c = new ArrayList<String>();
//        c.add(new Object());
//        c.add("hello");
    }


    // 泛型类派生子类的时候需要指明泛型类中的类型，K V这样的是解析不了的
    class A extends HashMap<Integer,Integer>{

    }
}
