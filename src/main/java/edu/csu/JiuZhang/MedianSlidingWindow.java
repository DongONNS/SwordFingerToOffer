package edu.csu.JiuZhang;

import java.util.*;

public class MedianSlidingWindow {
    public static List<Integer> medianSlidingWindow(int[] A,int k){
        PriorityQueue<Integer> maxHeap,minHeap;
        List<Integer> res = new ArrayList<>();
        int n = A.length;
        if (n == 0) return res;
        maxHeap = new PriorityQueue<>(n, Collections.reverseOrder());
        minHeap = new PriorityQueue<>(n);

        int i;
        for (i = 0;i < n;i++){
            //在大顶堆中添加的是滑动窗口中一般较大的元素
            if (maxHeap.size() == 0 || A[i] <= maxHeap.peek()) maxHeap.offer(A[i]);
            else minHeap.offer(A[i]);
            balance(maxHeap,minHeap);
            if (i - k >= 0){
                if (A[i-k] > maxHeap.peek()) minHeap.remove(A[i-k]);
                else maxHeap.remove(A[i-k]);
            }
            balance(maxHeap,minHeap);
            if (i >= k-1) res.add(maxHeap.peek());
        }
        return res;
    }
    private static void balance(PriorityQueue<Integer> maxHeap,PriorityQueue<Integer> minHeap){
        while(maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll());
        while (maxHeap.size() >minHeap.size()+1) minHeap.offer(maxHeap.poll());
    }
    public static void main(String[] args) {
        int[] nums = {1,2,7,7,2};
        int k = 3;
        List<Integer> res = medianSlidingWindow(nums, k);
        System.out.println(res.toString());
    }
}
