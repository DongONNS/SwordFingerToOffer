package edu.csu.algorithm.sort;

import java.util.Arrays;

public class QuickSortDemo {
//    请用非递归方式实现快排，并给出最坏及最好case示例

// 最好情况 4 2 1 3 6 5 7 每次partition可以将数组均匀切分
// 最坏情况 7 6 5 4 3 2 1 每次partition得到的数组都没有得到切分

    public static void main(String[] args) {
        int[] src = new int[]{7,6,5,4,3,2,1};
        int[] res = quickSort(src);
        System.out.println(Arrays.toString(res));
    }

    static int[] unChangedArr;

    public static int[] quickSort(int[] arr){
        if(arr == null || arr.length == 0) return null;

        unChangedArr = arr.clone();
        int[] res = quickSort(arr,0,arr.length - 1);

        return res;

    }

    private static int[] quickSort(int[] arr,int left,int right){
        // 参数校验
        if(left > right) return null;
        int[] res = new int[arr.length];

        // partition中是用arr[left]作为比较值 此处每次获取arr[i]在数组中的位置并存储到res数组中
        for(int i = 0;i < arr.length;i++){
            int valueIndex = partition(arr,i);
            // 因为partition会修改arr的值 所以此处需要将我们的arr恢复一下
            arr = unChangedArr.clone();
            res[valueIndex] = arr[i];
        }

        return res;
    }

    // 以arr[left]作为判断，将数组中的数字分别换到arr[left]的两边，得到arr[left]在数组中的索引下标
    private static int partition(int[] arr,int compIndex){

        int comp = arr[compIndex];
        int i = 0, j = arr.length - 1;

        while(true){
            while(i <= arr.length - 1 && arr[i] < comp){
                i++;
            }

            while(j >= 0 && arr[j] > comp){
                j--;
            }

            if(i >= j){
                break;
            }

            swap(arr,i,j);

        }
        return j;
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
