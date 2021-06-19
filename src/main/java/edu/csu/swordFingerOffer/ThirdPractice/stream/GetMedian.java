package edu.csu.swordFingerOffer.ThirdPractice.stream;

import java.util.PriorityQueue;

public class GetMedian {
    private PriorityQueue<Integer> left  = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    private int N;

    public void Insert(Integer num) {
        // 奇数添加到左边，偶数添加到右边
        if(N % 2 == 0){
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if(N % 2 == 0){
            double res = (left.peek() + right.peek()) / 2.0;
            return res;
        } else {
            return (double)left.peek();
        }
    }
}
