package edu.csu.algorithm;

/*
时间复杂度：O(n^2)
空间复杂度：O(1)
稳定性：稳定排序
是否原地排序：是
 */

public class BubbleSort {
    public int[] bubbleSort(int[] arr){
        // 非空判断
        if(arr == null || arr.length < 2)
            return null;

        int n = arr.length;

        // 总共需要n - 1轮循环
        for(int i = 0;i < n;i++){
            boolean flag = true;

            // 如果当前位置元素大于后一位的数字，那么就将其进行交换
            for(int j = 0;j < n - 1 - i;j++){
                if(arr[j] > arr[j + 1])
                    flag = false;
                    swap(arr,i,j);
            }

            // 一趟下来是否发生交换,如果没有发生交换，那说明就是所有的都有序了
            // 直接跳出循环
            if(flag)
                break;
        }
        return arr;
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
