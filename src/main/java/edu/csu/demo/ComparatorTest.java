package edu.csu.demo;

import java.util.ArrayList;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        Person person1 = new Person(23,"钟栋成");
        Person person2 = new Person(22,"徐宗林");

        list.add(person1);
        list.add(person2);

        list.sort(person1.comparator);

        for (Person person : list){
            System.out.println(person);
        }
    }
}
