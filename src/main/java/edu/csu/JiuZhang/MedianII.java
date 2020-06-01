package edu.csu.JiuZhang;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianII {
    public static int[] medianII(int[] nums) {
        int len = nums.length;
        //非空判断
        if (len == 0) return new int[0];
        PriorityQueue<Integer> maxHeap, minHeap;
        //大顶堆中存放的是较小的一半元素
        maxHeap = new PriorityQueue<Integer>(len, Collections.reverseOrder());
        //小顶堆存放的是较大的一半元素
        minHeap = new PriorityQueue<Integer>(len);

        int[] res = new int[len];
        for (int i = 0; i < len; ++i) {
            if (maxHeap.isEmpty() || nums[i] < maxHeap.peek()) maxHeap.offer(nums[i]);
            else minHeap.offer(nums[i]);
            balance(maxHeap,minHeap);
            res[i] = maxHeap.peek();
        }
        return res;
    }
    /*
     调整大顶堆小顶堆的大小
     */
    public static void balance(PriorityQueue<Integer> maxHeap,PriorityQueue<Integer> minHeap){
        while(maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll());
        while(maxHeap.size() > minHeap.size()+1) minHeap.offer(maxHeap.poll());
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] res = medianII(nums);
        System.out.println(Arrays.toString(res));
    }
}