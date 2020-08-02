package edu.csu.leetcode.array;

public class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int right = 0;
        for(int i = 0;i < arr.length;i++){
            right = Math.max(right,arr[i]);
            if(right == i) res++;
        }
        return res;
    }
}
