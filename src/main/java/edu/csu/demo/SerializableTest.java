package edu.csu.demo;

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) throws Exception {
        SerializableTest test = new SerializableTest();
        test.serial();
//        test.revSerial();
    }

    /**
     * 验证序列化
      */
    public void serial() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F://person.txt"));
        Person person = new Person("Megvii",24);
        oos.writeObject(person);
        oos.writeObject(person);
    }

    /**
     * 验证反序列化
     * @throws IOException
     */
    public void revSerial() throws IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E://person.txt"));
        try {
            Person personSerial = (Person)ois.readObject();
            System.out.println("对象反序列化结果==" + personSerial);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public class Person implements Serializable {
        private String name;
        private int age;

        public Person(String name,int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name +'\'' +
                    ",age=" + age +
                    '}';
        }
    }
}
