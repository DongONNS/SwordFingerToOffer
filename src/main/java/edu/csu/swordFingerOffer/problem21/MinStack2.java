package edu.csu.swordFingerOffer.problem21;

import java.util.Stack;

public class MinStack2 {
    private Stack<Integer> stack;
    private int min;
    //初始化数据结构
    public MinStack2() {
        stack = new Stack();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x <= min ){//注意：这里要使用<=号
            stack.push(min);//在每一个min入栈之前将它前一个min入栈
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min){//如果取出来的是当前min，就将压在它底下下的前一个min出栈
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
