package edu.csu.demo;

import java.util.Comparator;

public class Person {

    private int age;

    private String name;

    Person(int age,String name){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", comparator=" + comparator +
                '}';
    }

    //在类中自定义比较器
    //如果是前减后(p1 - p2)按照升序排列，后减前(p2 - p1)按照降序排列
    public Comparator<Person> comparator =
            (person1,person2) ->{
                return person2.age - person1.age;
            };


}
