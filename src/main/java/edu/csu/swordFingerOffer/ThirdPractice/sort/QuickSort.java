package edu.csu.swordFingerOffer.ThirdPractice.sort;

public class QuickSort {
    public int[] quickSort(int[] arr){
        int left = 0,right = arr.length - 1;
        int[] res = quickSort(arr, left, right);
        return res;
    }

    public int[] quickSort(int[] arr,int left,int right){
        // 如果数组长度小于2 或数组为null，那么直接返回arr即可
        if (arr == null || arr.length < 2){
            return arr;
        }
        int part = partition(arr,left,right);
        quickSort(arr,left,part - 1);
        quickSort(arr,part + 1,right);
        return arr;
    }

    /**
     * 实现将数组按某个特定的元素进行切分
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arr,int left,int right){
        int comp = arr[left];
        int i = left + 1,j = right;

        while(true){
            while(i <= j && arr[i] <= comp){
                i++;
            }

            while(i <= j && arr[j] >= comp){
                j--;
            }

            if (i >= j){
                break;
            }
            swap(arr,i,j);
        }
        swap(arr,left,j);
        return j;
    }

    /**
     * 交换数组中i,j位置的元素
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
