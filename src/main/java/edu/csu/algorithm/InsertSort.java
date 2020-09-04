package edu.csu.algorithm;

/*
时间复杂度：O(n^2)
空间复杂度：O(1)
是否稳定排序：是
是否原地排序：是
 */




public class InsertSort {
    public int[] insertSort(int[] arr){
        if(arr == null) return null;

        int n = arr.length;

        for(int i = 1;i < n;i++){
            int temp = arr[i];

            // 找到左边小于temp的最大的数
            int k = i - 1;
            while(k >= 0 && arr[k] > temp){
                k--;
            }

            // 对元素进行移动,使得在k之后的所有元素向后移动一位
            for(int j = i; j > k + 1;j--){
                arr[j] = arr[j - 1];
            }

            // 把我们的k后面的那个值设置为temp;
            arr[k + 1] = temp;
        }
        return arr;
    }
}
