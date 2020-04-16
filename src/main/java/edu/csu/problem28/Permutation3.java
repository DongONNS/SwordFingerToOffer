package edu.csu.problem28;

import java.util.ArrayList;
import java.util.Collections;
/*
    输入一个含有八个数字的数组，判断有没有可能把这8个数字分别放到正方体的8个顶点上
    使得正方体三组相对的面上的4个顶点的和全都相等。
 */
public class Permutation3 {
    public static void main(String[] args) {

        String str = "12345678";
        // 得到全排列的结果
        ArrayList<String> list = permutation(str);
        System.out.println("组合结果："+list);
        // 判断是否有满足条件的
        isTrue(list);
    }

    private static void isTrue(ArrayList<String> list) {
        if(list==null || list.size()<=0){
            return ;
        }
        for (String str:list) {
            char[] c = str.toCharArray();
            if((c[0]+c[1]+c[2]+c[3])==(c[4]+c[5]+c[6]+c[7]) &&
                    (c[0]+c[2]+c[4]+c[6])==(c[1]+c[3]+c[5]+c[7]) &&
                    (c[0]+c[1]+c[4]+c[6])==(c[2]+c[3]+c[6]+c[7])){
                System.out.println(String.valueOf(str));
            }
        }
    }

    public static ArrayList<String> permutation(String str){
        if(str==null || str.length()<=0){
            return null;
        }
        ArrayList<String> list = new ArrayList<String>();
        char[] chars = str.toCharArray();
        permutation(chars,0,list);
        Collections.sort(list);
        return list;
    }

    public static void permutation(char[] str,int i,ArrayList<String> list){
        if(str==null){
            return ;
        }
        if(i==str.length-1){
            //判断当前排列是否已经包含在列表中
            if(!list.contains(String.valueOf(str))){
                list.add(String.valueOf(str));
            }else{
                return;
            }
        }else{
            for(int j=i;j<str.length;j++){
                swap(str,i,j);
                permutation(str,i+1,list);
                swap(str,i,j);
            }
        }
    }

    //交换数组m位置和n位置上的值
    public static void swap(char[] arrayA,int m,int n){
        char temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
    }
}
