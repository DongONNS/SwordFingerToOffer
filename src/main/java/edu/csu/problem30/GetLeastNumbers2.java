package edu.csu.problem30;

import java.util.*;

public class GetLeastNumbers2 {
    public static void main(String[] args) {
        int[] arr = {3,2,1};
        int k = 2;
        int[] result = getLeastNumbers(arr, k);
//        System.out.println(Arrays.toString(result));
    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 ||k <= 0) return new int[0];
        Queue<Integer> pq = new PriorityQueue<Integer>((v1,v2) -> v2 - v1);
        for (int num:arr){
            if (pq.size() < k){
                pq.offer(num);
            }else if (pq.peek() > num){
                    pq.poll();
                    pq.offer(num);
            }
        }
        int[] result = new int[pq.size()];
        int index = 0;
        for (int num:pq){
            result[index++] = num;
        }
        return result;
    }
}
