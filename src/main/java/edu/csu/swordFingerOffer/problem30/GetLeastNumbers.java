package edu.csu.swordFingerOffer.problem30;

import java.util.Arrays;

public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] arr = {3,2,1};
        int k = 2;
        int[] result = getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(result));
    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k <= 0)
            return new int[0];
        int low = 0,high = arr.length-1;
        int index = 0;
        index = partition(arr,low,high);
        while(index != k-1){
            if(index > k-1){
                high = index - 1;
                index = partition(arr,low,high);
            }else{
                low = index + 1;
                index = partition(arr,low,high);
            }
        }
        int[] res = new int[k];
        for(int i = 0;i < k;i++){
            res[i] = arr[i];
        }
        return res;
    }
    //快速排序中的分割函数;
    private static int partition(int[] arr,int low,int high){
        int temp = arr[low];
        while(low < high){
            while(low < high && arr[low] <= temp){
                low++;
            }
            arr[high] = arr[low];

            while(low < high && arr[high] >= temp){
                high--;
            }
            arr[low] = arr[high];
        }
        arr[low] = temp;
        return low;
    }
}
