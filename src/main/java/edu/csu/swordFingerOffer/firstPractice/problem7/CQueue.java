package edu.csu.swordFingerOffer.firstPractice.problem7;

import java.util.Stack;

//  利用两个栈实现一个队列
public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue(){
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    public void appendTail(int value){
        if (stack1 == null)
            stack1.push(value);
        else{
            //先将stack1中的数据转移到stack2中
            while(!stack1.isEmpty()){
                int temp = stack1.pop();
                stack2.push(temp);
            }
            //将我们需要放入队尾的值压在栈底
            stack1.push(value);
            //再将辅助栈中的元素转移回来
            while(!stack2.isEmpty()){
                int temp = stack2.pop();
                stack1.push(temp);
            }
        }
    }
    public int deleteHead(){
        if (!stack1.isEmpty()) return stack1.pop();
        else return -1;
    }
}
