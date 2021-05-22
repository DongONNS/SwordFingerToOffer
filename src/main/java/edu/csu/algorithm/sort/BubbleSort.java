package edu.csu.algorithm.sort;

/*
时间复杂度：O(n^2)
空间复杂度：O(1)
稳定性：稳定排序
是否原地排序：是
 */

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] src = {7,6,5,4,3,2,1};
        int[] res = bubbleSort(src);
        System.out.println(Arrays.toString(res));
    }

    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n -i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    flag = false;
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
            //一趟下来是否发生位置交换
            if(flag)
                break;
        }
        return arr;
    }
}
