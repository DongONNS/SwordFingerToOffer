package edu.csu.algorithm.sort;

/*
时间复杂度:O(n * log(n))
空间复杂度:O(log(n))
是否稳定排序:非稳定排序
是否原地排序：是

数组[1,2,...,n]和数组[n,n-1,...1,]使用快速排序哪个快些
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        int[] arr_reverse = new int[10000];

        for(int i = 0;i < 10000;i++){
            arr[i] = i;
            arr_reverse[i] = 10000 - i;
        }
        quickSort(arr);

        quickSort(arr_reverse);

    }

    public static int[] quickSort(int[] arr){
        long start = System.currentTimeMillis();

        int[] res = quickSort(arr, 0, arr.length - 1);

        long end = System.currentTimeMillis();
        System.out.println("排序耗时为 : " + (end - start));

        return res;
    }

    public static int[] quickSort(int[] arr,int left,int right){
        if(arr == null || arr.length < 2)
            return arr;

        if(left < right){
            // 获取中轴元素所处的位置
            int mid = partition(arr,left,right);
            quickSort(arr,left,mid - 1);
            quickSort(arr,mid + 1,right);
        }
        return arr;
    }

    private static int partition(int[] arr,int left,int right){
        int cmp = arr[left];
        int i = left + 1;
        int j = right;

        while(true){
            // 想右遍历，找到第一个大于cmp的值
            while(i <= j && arr[i] <= cmp)
                i++;

            // 向左遍历，找到第一个小于cmp的值
            while(i <= j && arr[j] >= cmp)
                j--;

            // 说明它是默认的分开了在cmp的左右两侧
            if(i >= j)
                break;

            swap(arr,i,j);
        }
        // 交换两个元素的位置，使得左边元素不大于cmp,右边元素不小于cmp;
        arr[left] = arr[j];
        arr[j] = cmp;

        return j;
    }

    // 交换元素的位置
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
