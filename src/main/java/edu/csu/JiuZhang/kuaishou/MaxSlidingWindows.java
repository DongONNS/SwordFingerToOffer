package edu.csu.JiuZhang.kuaishou;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaxSlidingWindows {
    //辅助栈
    static int[] aux;
    static void inQueue(Deque<Integer> deque,int pos){
        while(!deque.isEmpty() && aux[deque.peekLast()] <= aux[pos]){
            deque.pollLast();
        }
        deque.offer(pos);
    }
    static void outQueue(Deque<Integer> deque,int pos){
        if (deque.peekFirst() == pos)
            deque.pollFirst();
    }

    public static List<Integer> maxSlidingWindows(int[] nums, int k){
        aux = nums;
        //存储结果
        ArrayList<Integer> ans = new ArrayList<>();
        //存储滑动窗口的值
        Deque<Integer> deque = new ArrayDeque<>();
        if (nums.length == 0) return ans;
        //将前k-1个元素加入到deque中
        for (int i = 0;i < k - 1;i++){
            inQueue(deque,i);
        }
        //处理后面添加的元素
        for (int i = k - 1;i < nums.length;i++){
            inQueue(deque,i);
            ans.add(aux[deque.peekFirst()]);
            outQueue(deque,i - k + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,7,7,2};
        int k = 1;
        List<Integer> res = maxSlidingWindows(nums, k);
        System.out.println(res);
    }
}
