package edu.csu.algorithm.sort;


/*
时间复杂度：O(n^2)
空间复杂度：O(1)
稳定性：非稳定排序
是否原地排序：是
 */

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1};
        int[] res = selectSort(arr);
        System.out.println("选择排序的结果为: " + Arrays.toString(res));
    }

    public static int[] selectSort(int[] arr){
        // 非空判断
        if(arr == null) return null;

        int n = arr.length;

        for (int i = 0;i < n - 1;i++){
            // 设置当前位置为最小值索引
            int min = i;

            for(int j = i + 1;j < n;j++){

                // 遍历查找后面的数组中的最小值
                if(arr[min] > arr[j])
                    min = j;
            }
            // 每次遍历的目的就是为了将最小的元素排到剩余元素的最前面
            swap(arr,i,min);
        }
        return arr;
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}