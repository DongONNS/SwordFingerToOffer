package edu.csu.demo;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        List<Integer> sub = arr.subList(3,5);

        sub.remove(0);

        System.out.println("修改后的arr数组" + arr.toString());

        System.out.println("修改后的sub数组" + sub.toString());
    }

}
