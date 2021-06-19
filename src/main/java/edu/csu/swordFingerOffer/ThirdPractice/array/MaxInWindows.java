package edu.csu.swordFingerOffer.ThirdPractice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxInWindows {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,2,6,2,5,1};
        int size = 3;
        ArrayList<Integer> res = maxInWindows(nums, size);
        System.out.println(res.toString());
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2) -> o2 - o1);
        ArrayList<Integer> res = new ArrayList<>();

        if(num == null || num.length == 0) return res;
        for(int i = 0;i < size && i < num.length;i++){
            maxHeap.add(num[i]);
        }
        res.add(maxHeap.peek());
        if(size >= num.length) return res;

        for(int i = size;i < num.length;i++){
            maxHeap.remove(num[i - size]);
            maxHeap.add(num[i]);
            res.add(maxHeap.peek());
        }
        return res;
    }
}
