package edu.csu.JiuZhang.bytedance;

public class GiveChange {
    public static void main(String[] args) {
        int amount = 200;
        int ans = giveChange(amount);
        System.out.println(ans);
    }

    public static int giveChange(int amount) {
        int num = 1024 - amount;
        int count_64 = num / 64;        //64面值的数量
        int count_16 = (num % 64) / 16; //面值16的数量
        int count_4  = (num % 16) / 4;  //面值4的数量
        int count_1  = (num % 4)  / 1;  //面值1的数量
        int sum = count_1+count_4+count_16+count_64;
        return sum;
    }
}
