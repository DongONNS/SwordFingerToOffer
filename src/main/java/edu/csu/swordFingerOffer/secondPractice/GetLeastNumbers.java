package edu.csu.swordFingerOffer.secondPractice;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GetLeastNumbers {
    public ArrayList<Integer> getLeastNumbers(int[] nums, int k) {
        if (k > nums.length || k <= 0)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }
}
