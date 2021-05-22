package edu.csu.swordFingerOffer.ThirdPractice.sort;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        // 判空操作
        if(input == null || input.length == 0){
            return res;
        }

        // 构建一个大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2) -> o2 - o1);

        for(int i = 0;i < input.length;i++){
            maxHeap.add(input[i]);
            // 如果元素数量大于k了，那么弹出堆定元素
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }
}
