package edu.csu.swordFingerOffer.ThirdPractice.stack;

import java.util.Stack;

public class IsPopOrder {
    public boolean IsPopOrder(int[] pushA,int[] popA){
        Stack<Integer> stack = new Stack<>();

        for (int i = 0;i < pushA.length;i++){
            stack.push(pushA[i]);
            int index = 0;

            while(stack.peek() == popA[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
