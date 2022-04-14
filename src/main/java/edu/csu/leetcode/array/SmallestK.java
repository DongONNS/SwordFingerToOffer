package edu.csu.leetcode.array;

import java.util.PriorityQueue;

public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->a-b);
        for (int i : arr) q.add(i);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = q.poll();
        return ans;
    }
}
