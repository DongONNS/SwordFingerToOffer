package edu.csu.problem7;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class CQueue2 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;
    public CQueue2(){
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        size = 0;
    }
    public void appendTail(int value){
        stack1.push(value);
        size++;
    }
    public int deleteHead(){
        if(size == 0) return -1;
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        size--;
        return stack2.pop();
    }
}
