package edu.csu.algorithm.sort;

import java.util.Arrays;

/*
时间复杂度:O(n*log(n))
空间复杂度:O(1)
是否稳定排序：否
原地排序：是
 */

public class Heap {

    public int[] heapSort(int[] arr){
        int n = arr.length;

        // 构建大顶堆
        for(int i = (n - 2) / 2;i >= 0;i--){
            sink(arr,i,n - 1);
        }

        // 进行堆排序
        for(int i = n - 1;i >= 1;i--){
            // 把堆顶元素和最后一个元素进行交换
            swap(arr,i,0);

            // 将堆定元素下沉
            sink(arr,0,i - 1);
        }
        return arr;
    }

    public void sink(int[] arr,int parent,int n){
        // 临时保存要下沉的元素
        int temp = arr[parent];

        // 定位左孩子节点的位置
        int child = 2 * parent + 1;

        // 开始下沉
        while(child <= n){
            // 如果右孩子节点存在，并且大于左孩子，那么修改child为较大的值
            if(child + 1 <= n && arr[child] < arr[child + 1])
                child++;

            // 如果孩子节点小于等于要下沉的节点，下沉结束
            if(arr[child] <= temp)
                break;

            // 实现下沉操作,先不用实现交换
            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent + 1;
        }
        arr[parent] = temp;
    }

    // 交换数组的child和parent位置
    private void swap(int[] arr,int parent,int child){
        int temp = arr[parent];
        arr[parent] = arr[child];
        arr[child] = temp;
    }


    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] arr = {1,7,5,9,6};
        heap.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
