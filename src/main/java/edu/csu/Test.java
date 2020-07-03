package edu.csu;

public class Test {

    static String str = new String("good");
    static char[] ch = {'a','b','c'};

    public static void main(String[] ars) {

        Test test = new Test();
        test.change(str,ch);

        System.out.println(test.str + " and " + test.ch[0] + test.ch[1] + test.ch[2]);
    }

    public void change(String str,char[] ch){
        str = "test ok";
        ch[0] = 'g';
    }
}
