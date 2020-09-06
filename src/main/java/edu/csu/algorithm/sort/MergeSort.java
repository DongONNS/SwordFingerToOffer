package edu.csu.algorithm.sort;

import java.util.Arrays;

/*
时间复杂度：O(n * log(n))
空间复杂度：O(n)
是否稳定排序：稳定排序
是否原地排序：否
 */

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1};

        int[] res = mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(res));
    }

    public static int[] mergeSort(int[] arr,int left,int right){
        // 如果left == right,表示只有一个元素，不需要进行排序
        if (left < right){
            // 把大数组分成两个数组
            int mid = left + (right - left) / 2;

            // 对左半部分进行排序
            mergeSort(arr,left,mid);

            // 对右半部分进行排序
            mergeSort(arr,mid + 1,right);

            // 合并
            merge(arr,left,mid,right);
        }
        return arr;
    }

    // 合并函数，把两个有序的数组进行合并
    private static void merge(int[] arr,int left,int mid,int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;

        int i = left;
        int j = mid + 1;

        // 当左右两个数组都还没有被清空
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j])
                temp[index++] = arr[i++];

            else
                temp[index++] = arr[j++];
        }

        while (i <= mid)
            temp[index++] = arr[i++];

        while (j <= right)
            temp[index++] = arr[j++];

        for(i = 0;i < index;i++) {
            arr[left++] = temp[i];
        }
    }
}
