package edu.csu.swordFingerOffer.problem8;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {4,3,1,6,5};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void sort(int[] array){
        sort(array,0,array.length-1);
    }
    public static void sort(int[] array,int lo,int hi){
        if(hi<=lo)  return;
        int j = partition(array,lo,hi);
        sort(array,lo,j-1);
        sort(array,j+1,hi);
    }
    public static int partition(int[] array,int lo,int hi){
        int i = lo;
        int j = hi + 1;
        int std =array[lo];
        while(true){
            while(array[++i] < std){
                if (i == hi) break;
            }
            while(array[--j] > std){
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(array,i,j);
        }
        //这一步是我们快排的关键
        swap(array,lo,j);
        return j;
    }
    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
