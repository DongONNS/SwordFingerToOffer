package edu.csu.swordFingerOffer.firstPractice.problem21;

import java.util.Stack;
//实现一个栈的数据结构，该数据结构能够快速的得到我们栈中的最小元素
public class MinStack {
    Stack<Integer> normalStack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        normalStack = new Stack();
        minStack = new Stack();
    }

    public void push(int x) {
        normalStack.push(x);
        if(minStack.isEmpty() || minStack.peek() >= x)
            minStack.push(x);
    }

    public void pop() {
        if(normalStack.pop().equals(minStack.peek()))
            minStack.pop();
    }

    public int top() {
        return normalStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
