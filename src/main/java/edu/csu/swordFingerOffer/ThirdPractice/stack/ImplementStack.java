package edu.csu.swordFingerOffer.ThirdPractice.stack;

import java.util.Stack;

public class ImplementStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        // 在数字插入时正常插入
        stack1.push(node);
    }

    public int pop() {
        // 在数据弹出时候如果stack2 有数据直接弹出，否则先将stack1的数据压入stack2
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
