package edu.csu.demo;

public class SwitchDemo {
    public static void main(String[] args) {
        int a = 2;
        while(a-- > 0){
            switch (a){
                case 1:
                    System.out.println(1);
                    continue;
                case 2:
                    System.out.println(2);
                    break;
                case 3:
                    System.out.println(3);
                    break;
                case 4:
                    System.out.println(4);
                    break;
                default:
                    System.out.println("default");
            }
        }
    }
}
